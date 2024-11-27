package controller.panel_views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.panel_views.HomeView;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DAO.Impl.EmployeeDAOImpl;
import model.DAO.Impl.HolidayDAOImpl;
import model.DAO.Impl.TimeRecordDAOImpl;
import model.Employee;
import model.Holiday;
import model.TimeRecord;
import utils.Constants;

/**
 *
 * @author Alejandro Ojea
 */
public class HomeViewController {

    private final HomeView view;
    private final Connection connection;
    private final TimeRecordDAOImpl trDAO;
    private final EmployeeDAOImpl empDAO;
    private final HolidayDAOImpl holidayDAO;
    private final Employee currentlyEmployee;

    public HomeViewController(HomeView view, Connection connection, Employee currentlyEmployee) throws SQLException, Exception {
        this.view = view;
        this.connection = connection;
        this.currentlyEmployee = currentlyEmployee;
        this.trDAO = new TimeRecordDAOImpl(connection);
        this.empDAO = new EmployeeDAOImpl(connection);
        this.holidayDAO = new HolidayDAOImpl(connection);
        this.repaintTimeRecordsTable(trDAO.findByEmpId(currentlyEmployee.getId()));
        repaintHolidaysTable(holidayDAO.findAllByEmp(currentlyEmployee.getId()));
        view.setNotes(currentlyEmployee.getNotes());
        this.view.addRefreshButtonListener(this.getRefreshButtonActionListener());
        this.view.addSaveNotesButtonListener(this.getSaveNotesButtonActionListener());
        this.view.addSignButtonListener(this.getSignButtonActionListener());
        this.view.addInOutComboListener(this.getInOutComboActionListener());
        this.view.addRequestButtonListener(this.getRequestButtonActionListener());
    }

    private ActionListener getRefreshButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            if (view.getDateFrom() != null && view.getDateUntil() != null && !view.getDateUntil().isBefore(view.getDateFrom())) {
                try {
                    repaintTimeRecordsTable(trDAO.findByEmpIdAndDateFromUntil(currentlyEmployee.getId(), view.getDateFrom(), view.getDateUntil()));
                } catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(view, Constants.DATE_NULL, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
        return al;
    }

    private ActionListener getSaveNotesButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                empDAO.updateNotes(currentlyEmployee.getId(), view.getNotes());
            } catch (Exception ex) {
                Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return al;
    }

    private ActionListener getSignButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                List<TimeRecord> todayRecords = trDAO.findByEmpIdAndDate(currentlyEmployee.getId(), LocalDate.now());

                boolean hasEntrada = todayRecords.stream().anyMatch(record -> record.getIn() != null);
                boolean hasSalida = todayRecords.stream().anyMatch(record -> record.getOut() != null);

                if (view.getStringInOutCombo().equals("Entrada")) {
                    if (hasEntrada) {
                        JOptionPane.showMessageDialog(view, Constants.INVALID_TIME_RECORD_IN, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    } else {
                        trDAO.insert(new TimeRecord(currentlyEmployee.getId(), LocalDate.now(), LocalTime.now(), null));
                    }
                } else {
                    if (hasSalida) {
                        JOptionPane.showMessageDialog(view, Constants.INVALID_TIME_RECORD_OUT, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    } else {
                        trDAO.update();
                    }
                }

                repaintTimeRecordsTable(trDAO.findByEmpId(currentlyEmployee.getId()));
            } catch (Exception ex) {
                Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return al;
    }

    private ActionListener getInOutComboActionListener() {
        ActionListener al = (ActionEvent e) -> {
            if (view.getStringInOutCombo().equals("Entrada")) {
                view.setSignButtonText("Fichar entrada");
            } else {
                view.setSignButtonText("Fichar salida");
            }
        };
        return al;
    }

    private ActionListener getRequestButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            if (view.getDateRequestFrom() != null && view.getDateRequestUntil() != null) {
                if (view.getDateRequestFrom().isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(view, Constants.INVALID_TIME_RECORD_BEFORE_NOW, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!view.getDateRequestUntil().isBefore(view.getDateRequestFrom())) {
                    try {
                        if (isDateValid(view.getDateRequestFrom(), view.getDateRequestUntil())) {
                            try {
                                holidayDAO.insert(new Holiday(currentlyEmployee.getId(), view.getDateRequestFrom(), view.getDateRequestUntil(), 0));
                                repaintHolidaysTable(holidayDAO.findAllByEmp(currentlyEmployee.getId()));
                            } catch (Exception ex) {
                                Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(view, Constants.OVERLAP_DATE, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, Constants.DATE_NULL, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(view, Constants.DATE_NULL, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
        return al;
    }

    private void repaintTimeRecordsTable(List<TimeRecord> trs) {
        view.removeTimeRecordDataTable();

        for (TimeRecord tr : trs) {
            Vector row = new Vector();

            row.add(currentlyEmployee.getName());
            row.add(tr.getDate());
            row.add(tr.getIn());
            row.add(tr.getOut());
            row.add(tr.getOut() != null ? String.format("%02d:%02d", Duration.between(tr.getIn(), tr.getOut()).toHours(),
                    Duration.between(tr.getIn(), tr.getOut()).toMinutes() % 60) : "00:00");

            view.addTimeRecordRowTable(row);
        }
    }

    private void repaintHolidaysTable(List<Holiday> holidays) {
        view.removeHolidaysDataTable();

        for (Holiday h : holidays) {
            Vector row = new Vector();

            row.add(h.getInitDay());
            row.add(h.getFinishDate());
            row.add(h.getAccept() == 0 ? "Pendientes" : h.getAccept() == 1 ? "Aceptadas" : "Denegadas");

            view.addHolidaysRowTable(row);
        }
    }

    private boolean isDateValid(LocalDate from, LocalDate until) throws Exception {

        for (Holiday h : holidayDAO.findAllByEmp(currentlyEmployee.getId())) {

            if (h.getInitDay() != null && h.getFinishDate() != null) {
                boolean isOverlapping
                        = !from.isAfter(h.getFinishDate().plusDays(1)) && !until.isBefore(h.getInitDay().minusDays(1));
                if (isOverlapping) {
                    return false;
                }
            }
        }
        return true;
    }

}
