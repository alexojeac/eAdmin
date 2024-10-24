package controller;

import db.QueryProcessor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import views.NavigationView;
import java.sql.*;
import java.util.logging.*;
import model.Employee;
import views.panel_views.DepartmentView;
import views.panel_views.HomeView;
import views.panel_views.RRHHView;

public class NavigationController {
    private final NavigationView view;
    //private final Connection connection;
    private final Employee currentlyEmployee;
    private final QueryProcessor query;

    public NavigationController(NavigationView view, Connection connection, Employee employee) throws SQLException {
        this.view = view;
        //this.connection = connection;
        query = new QueryProcessor(connection);
        this.currentlyEmployee = employee;
        this.view.addExitLabelListener(this.getExitLabelMouseListener());
        this.view.addRRHHLabelListener(this.getRRHHLabelMouseListener());
        this.view.addHomeLabelListener(getHomeLabelMouseListener());
        this.view.addDeptosLabelListener(this.getDeptosLabelMouseListener());
        HomeView currentView = new HomeView();
        //HomeController controller = new HomeController(currentView, connection, currentlyEmployee);
        view.setView(currentView);
        this.checkRol(this.checkPermits(currentlyEmployee.getId()));
    }

    private void checkRol(int dept) {
        switch (dept) {
            case 1:
                view.setAdminLabelVisible(false);
                break;
            case 2:
                break;
            default:
                view.setRRHHLabelVisible(false);
                view.setDepartmentLabelVisible(false);
                view.setAdminLabelVisible(false);
        }
    }

    private int checkPermits(int id) {
        try {
            ResultSet rs = query.executeQuery("SELECT PERMISOS FROM DEPARTAMENTOS WHERE dept_id = (SELECT departamento_id FROM EMPLEADOS WHERE emp_id = " + id + ")");

            if (rs.next()) {
                return rs.getInt("permisos");
            }

        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    private MouseAdapter getExitLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                view.getExitPanel().setBackground(Color.red);
                view.getExitLabel().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                view.getExitPanel().setBackground(Color.white);
                view.getExitLabel().setForeground(Color.black);
            }
        };
        return adapter;
    }

    private MouseAdapter getHomeLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    HomeView currentView = new HomeView();
                    /*try {
                        HomeController controller = new HomeController(currentView, connection, currentlyEmployee);
                    } catch (SQLException ex) {
                        Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    view.setView(currentView);
                }
            }

        };
        return adapter;
    }

    private MouseAdapter getRRHHLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    RRHHView currentView = new RRHHView();
                    /*try {
                        RRHHController controller = new RRHHController(currentView, connection);
                    } catch (SQLException ex) {
                        Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    view.setView(currentView);
                }
            }
        };
        return adapter;
    }

    private MouseAdapter getDeptosLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    DepartmentView currentView = new DepartmentView();
                    /*try {
                        DeptController controller = new DeptController(currentView, connection);
                    } catch (SQLException ex) {
                        Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    view.setView(currentView);
                }
            }
        };
        return adapter;
    }
}
