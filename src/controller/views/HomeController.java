package controller.views;

import java.awt.event.ActionEvent;
import java.sql.*;
import view.panelViews.HomeView;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.SignOn;
import utils.QueryProcessor;

public class HomeController {

    private final HomeView view;
    private final Connection connection;
    private final Employee currentlyEmployee;
    private final QueryProcessor query;
    private ArrayList<SignOn> signs;

    public HomeController(HomeView view, Connection connection, Employee employee) throws SQLException {
        this.view = view;
        this.connection = connection;
        this.query = new QueryProcessor(connection);
        this.currentlyEmployee = employee;
        setUserName();
        setDepartment();
        this.view.addOnTimeButtonInListenner(this.getOnTimeButtonInActionListener());
        this.view.addOnTimeButtonOutListenner(this.getOnTimeButtonOutActionListener());
        coverSigns();
    }

    private void setUserName() {
        this.view.setUserName(currentlyEmployee.getName() + " " + currentlyEmployee.getLastname1());
    }

    private void setDepartment() {
        try {
            ResultSet rs = query.executeQuery("SELECT nombre FROM departamentos WHERE dept_id = (SELECT departamento_id FROM empleados WHERE emp_id = " + currentlyEmployee.getId() + ")");

            if (rs.next()) {
                this.view.setDepartment(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void coverSigns() {
        try {
            signs = new ArrayList<>();
            ResultSet rs = query.executeQuery("SELECT fecha, entrada, salida FROM fichadas WHERE emp_id = " + currentlyEmployee.getId());

            while (rs.next()) {
                if (rs.getTime("salida") == null) {
                    signs.add(new SignOn(String.valueOf(rs.getDate("fecha")), rs.getTime("entrada").toLocalTime()));
                } else {
                    signs.add(new SignOn(String.valueOf(rs.getDate("fecha")), rs.getTime("entrada").toLocalTime(), rs.getTime("salida").toLocalTime()));
                }
            }

            repaintTable(signs);
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ActionListener getOnTimeButtonInActionListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!existsSign()) {
                        query.executeStatement("INSERT INTO fichadas (entrada, emp_id) VALUES (CURRENT_TIME()," + currentlyEmployee.getId() + ")");
                    }
                    coverSigns();
                } catch (Exception ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return listener;
    }

    private ActionListener getOnTimeButtonOutActionListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    query.executeStatement("UPDATE fichadas SET salida = CURRENT_TIME() WHERE fecha = CURRENT_DATE()");

                    coverSigns();
                } catch (Exception ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return listener;
    }

    private boolean existsSign() {
        try {
            ResultSet rs = query.executeQuery("SELECT * FROM fichadas WHERE fecha = CURRENT_DATE()");

            return rs.next();

        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    private void repaintTable(ArrayList<SignOn> signs) {
        view.removeDataTable();

        for (SignOn s : signs) {
            Vector row = new Vector();

            row.add(s.getDate());
            row.add(s.getIn());
            row.add(s.getOut());

            view.addRowTable(row);
        }
    }

}
