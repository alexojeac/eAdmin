package controller.app;

import controller.FrontController;
import controller.views.DeptController;
import controller.views.RRHHController;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.app.AppView;
import view.panelViews.DeptView;
import view.panelViews.HomeView;
import view.panelViews.RRHHView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import utils.QueryProcessor;

public class AppController {

    private final AppView view;
    private final Connection connection;
    private final Employee currentlyEmployee;

    public AppController(AppView view, Connection connection, Employee employee) {
        this.view = view;
        this.connection = connection;
        this.currentlyEmployee = employee;
        this.view.addExitLabelListener(this.getExitLabelMouseListener());
        this.view.addRRHHLabelListener(this.getRRHHLabelMouseListener());
        this.view.addHomeLabelListener(getHomeLabelMouseListener());
        this.view.addDeptosLabelListener(this.getDeptosLabelMouseListener());
        view.setView(new HomeView());
        this.setIdNav();
        this.checkRol(this.checkPermits(currentlyEmployee.getId()));
    }
    
    private void setIdNav() {
        this.view.setUserIdLabel(currentlyEmployee.getName() + ": " + currentlyEmployee.getId());
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
        QueryProcessor query2 = new QueryProcessor(connection);
        try {
            ResultSet rs = query2.executeQuery("SELECT permisos FROM departamentos WHERE dept_id = (SELECT departamento_id FROM empleados WHERE emp_id = " + id + ")");

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
                    RRHHController controller = new RRHHController(currentView, connection);
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
                    DeptView currentView = new DeptView();
                    DeptController controller = new DeptController(currentView, connection);
                    view.setView(currentView);
                }
            }
        };
        return adapter;
    }
}
