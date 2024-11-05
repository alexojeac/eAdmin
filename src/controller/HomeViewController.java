package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.panel_views.HomeView;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Vector;
import model.DAO.Impl.EmployeeDAOImpl;
import model.DAO.Impl.TimeRecordDAOImpl;
import model.Employee;
import model.TimeRecord;

public class HomeViewController {

    private final HomeView view;
    private final Connection connection;
    private final TimeRecordDAOImpl trDAO;
    private final EmployeeDAOImpl empDAO;
    private final Employee currentlyEmployee;

    public HomeViewController(HomeView view, Connection connection, Employee currentlyEmployee) throws SQLException {
        this.view = view;
        this.connection = connection;
        this.currentlyEmployee = currentlyEmployee;
        this.trDAO = new TimeRecordDAOImpl(connection);
        this.empDAO = new EmployeeDAOImpl(connection);
        this.repaintTable(trDAO.findByEmpId(currentlyEmployee.getId()));
        view.setNotes(currentlyEmployee.getNotes());
        this.view.addRefreshButtonListener(this.getRefreshButtonActionListener());
        this.view.addSaveNotesButtonListener(this.getSaveNotesButtonActionListener());
        this.view.addSignButtonListener(this.getSignButtonActionListener());
        this.view.addInOutComboListener(this.getInOutComboActionListener());
    }

    private ActionListener getRefreshButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            repaintTable(trDAO.findByEmpIdAndDateFromUntil(currentlyEmployee.getId(), view.getDateFrom(), view.getDateUntil()));
        };
        return al;
    }

    private ActionListener getSaveNotesButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            empDAO.updateNotes(currentlyEmployee.getId(), view.getNotes());
        };
        return al;
    }

    private ActionListener getSignButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            if (view.getStringInOutCombo().equals("Entrada")) {
                trDAO.insert(new TimeRecord(currentlyEmployee.getId(), LocalDate.now(), LocalTime.now()));
            } else {
                trDAO.update();
            }
            repaintTable(trDAO.findByEmpId(currentlyEmployee.getId()));
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

    private void repaintTable(List<TimeRecord> tr) {
        view.removeDataTable();

        for (TimeRecord s : tr) {
            Vector row = new Vector();

            row.add(currentlyEmployee.getName());
            row.add(s.getDate());
            row.add(s.getIn());
            row.add(s.getOut());
            row.add(s.getOut() != null ? String.format("%02d:%02d", Duration.between(s.getIn(), s.getOut()).toHours(),
                    Duration.between(s.getIn(), s.getOut()).toMinutes() % 60) : "00:00");

            view.addRowTable(row);
        }
    }

}
