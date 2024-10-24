package controller;

import db.QueryProcessor;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.Constants;
import views.LoginView;
import model.DatabaseConnection;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import model.Account;
import model.Employee;
import views.NavigationView;
import views.panel_views.PasswordInputPane;


public class FrontController {
    private final LoginView view;
    private final Connection connection;
    private final QueryProcessor query;

    public FrontController(LoginView view) throws SQLException {
        this.view = view;
        DatabaseConnection.connect(Constants.DB_HOST, Constants.DB_USER_NAME, Constants.DB_PASSWORD);
        this.connection = DatabaseConnection.getConnection();
        this.query = new QueryProcessor(connection);
        this.view.addExitLabelListener(this.getExitLabelMouseListener());
        this.view.addLoginButtonLabelListener(this.getLoginButtonLabelMouseListener());
        this.view.addUserTextFieldListener(this.getUserTextFieldFocusListener());
        this.view.addPasswordTextFieldListener(this.getPasswordTextFieldFocusListener());
        this.view.addPasswordTextFieldEnterListener(this.getPasswordTextFieldEnterKeyListener());
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

    private MouseAdapter getLoginButtonLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    appAcces();
                }
            }
        };
        return adapter;
    }

    private KeyAdapter getPasswordTextFieldEnterKeyListener() {
        KeyAdapter ka = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    appAcces();
                }
            }
        };
        return ka;
    }

    private boolean isNew() {
        try {
            ResultSet rs = query.executeQuery("SELECT nuevo FROM CUENTAS WHERE nombre_usuario = '" + view.getUserText() + "'");
            return (rs.next() && rs.getInt("nuevo") == 0);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private boolean checkUser() {
        boolean check = false;
        try {
            ResultSet rs = query.executeQuery("SELECT * FROM CUENTAS WHERE nombre_usuario = '" + view.getUserText() + "'");

            if (rs.next()) {
                Account account = new Account(rs.getString("nombre_usuario"), rs.getString("clave"));
                check = account.checkPass(view.getPassText(), account.getPass());
            }

        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }

    private void appAcces() {
        try {
            if (view.getUserText().equals("admin")) {
                if (query.chekAdmin(view.getUserText(), view.getPassText())) {
                    view.dispose();
                    NavigationView appView = new NavigationView(view, true);
                    NavigationController controller = new NavigationController(appView, connection, checkEmployee());
                    appView.setVisible(true);
                }
            } else {
                if (checkUser()) {
                    if (isNew()) {
                        PasswordInputPane newPass = new PasswordInputPane(view, true);
                        PasswordInputPaneController newPassController = new PasswordInputPaneController(newPass, connection, view.getUserText());
                        newPass.setVisible(true);
                    }
                    view.dispose();
                    NavigationView appView = new NavigationView(view, true);
                    NavigationController controller = new NavigationController(appView, connection, checkEmployee());
                    appView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(view, Constants.LOGIN_ERROR, "Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private FocusListener getUserTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getUserText().equals("Ingrese su nombre")) {
                    view.setUserText("");
                    view.setValidUser(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getUserText().equals("")) {
                    view.setUserText("Ingrese su nombre");
                    view.setValidUser(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getPasswordTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getPassText().equals("jPasswordField1")) {
                    view.setPassText("");
                    view.setValidPass(true);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getPassText().equals("")) {
                    view.setPassText("jPasswordField1");
                    view.setValidPass(false);
                }
            }
        };
        return listener;
    }

    private Employee checkEmployee() {
        try {
            ResultSet rs = query.executeQuery("SELECT * FROM EMPLEADOS WHERE emp_id = (SELECT emp_id FROM CUENTAS WHERE nombre_usuario = '" + view.getUserText() + "')");

            if (rs.next()) {
                if (rs.getInt("emp_id") == 1) {
                    Employee emp = new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"));
                    return emp;
                } else {
                    return new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                            String.valueOf(rs.getDate("fecha_contrato")), rs.getString("correo"), rs.getString("tlf"));
                }
            }
            return new Employee();
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
