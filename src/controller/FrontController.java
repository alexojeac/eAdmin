package controller;

/**
 *
 * @author Alejandro Ojea
 */
import controller.panel_views.AdministrationViewController;
import controller.panel_views.DepartmentViewController;
import controller.panel_views.HomeViewController;
import controller.panel_views.RRHHController;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import views.NavigationView;
import java.sql.*;
import java.util.logging.*;
import model.DAO.Impl.DepartmentDAOImpl;
import model.DAO.Impl.EmployeeDAOImpl;
import model.Employee;
import views.LoginView;
import views.panel_views.AdministrationView;
import views.panel_views.DepartmentView;
import views.panel_views.HomeView;
import views.panel_views.RRHHView;

public class FrontController {

    private final NavigationView view;
    private Connection connection;
    private Employee currentlyEmployee;
    private final DepartmentDAOImpl deptoDAO;
    private final EmployeeDAOImpl empDAO;

    public FrontController(NavigationView view, Connection connection, Employee employee) throws SQLException, Exception {
        this.view = view;
        this.connection = connection;
        this.currentlyEmployee = employee;
        this.deptoDAO = new DepartmentDAOImpl(connection);
        this.empDAO = new EmployeeDAOImpl(connection);
        this.view.addExitLabelListener(this.getExitLabelMouseListener());
        this.view.addExitPanelListener(this.getExitPanelMouseListener());
        this.view.addCloseLabelListener(this.getCloseLabelMouseListener());
        this.view.addRRHHLabelListener(this.getRRHHLabelMouseListener());
        this.view.addHomeLabelListener(getHomeLabelMouseListener());
        this.view.addDeptosLabelListener(this.getDeptosLabelMouseListener());
        this.view.addAdminLabelListener(this.getAdminLabelMouseListener());
        HomeView currentView = new HomeView();
        this.view.setsectionLabelText("Área personal");
        HomeViewController controller = new HomeViewController(currentView, connection, currentlyEmployee);
        view.setView(currentView);
        this.checkRol(this.checkPermits(currentlyEmployee.getDept_id()));
    }

    private MouseAdapter getCloseLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                view.getClosePanel().setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                view.getClosePanel().setBackground(new Color(0, 134, 190));
            }
        };
        return adapter;
    }

    private MouseAdapter getExitLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        view.dispose();
                        LoginView login = new LoginView();
                        LoginController controller = new LoginController(login);
                        login.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                view.getExitPanel().setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                view.getExitPanel().setBackground(new Color(0, 153, 204));
            }
        };
        return adapter;
    }

    private MouseAdapter getExitPanelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        view.dispose();
                        LoginView login = new LoginView();
                        LoginController controller = new LoginController(login);
                        login.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                view.getExitPanel().setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                view.getExitPanel().setBackground(new Color(0, 153, 204));
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
                    view.setsectionLabelText("Área personal");
                    try {
                        currentlyEmployee = empDAO.findById(currentlyEmployee.getId());

                        HomeViewController controller = new HomeViewController(currentView, connection, currentlyEmployee);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    view.setsectionLabelText("RRHH");
                    try {
                        RRHHController controller = new RRHHController(currentView, connection);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    view.setsectionLabelText("Departamentos");
                    try {
                        DepartmentViewController controller = new DepartmentViewController(currentView, connection);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    view.setView(currentView);
                }
            }
        };
        return adapter;
    }

    private MouseAdapter getAdminLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    AdministrationView currentView = new AdministrationView();
                    view.setsectionLabelText("Departamentos");
                    try {
                        AdministrationViewController controller = new AdministrationViewController(currentView, connection);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    view.setView(currentView);
                }
            }
        };
        return adapter;
    }

    private void checkRol(int per) {
        switch (per) {
            case 1 -> {
                view.setAdminLabelVisible(false);
                view.setAdminIconLabelVisible(false);
                view.setAdminPanelVisible(false);
            }
            case 0 -> {
                view.setRRHHLabelVisible(false);
                view.setRRHHIconLabelVisible(false);
                view.setRRHHPanelVisible(false);
                view.setDepartmentLabelVisible(false);
                view.setDepartmentIConLabelVisible(false);
                view.setDepartmentPanelVisible(false);
                view.setAdminLabelVisible(false);
                view.setAdminIconLabelVisible(false);
                view.setAdminPanelVisible(false);
            }

        }
    }

    private int checkPermits(int id) throws Exception {
        return deptoDAO.findPermissionById(id);
    }
}
