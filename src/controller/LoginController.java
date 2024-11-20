package controller;

/**
 *
 * @author Alejandro Ojea
 */
import controller.option_pane.PasswordInputPaneController;
import db.DatabaseConnection;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.Constants;
import views.LoginView;
import db.QueryProcessor;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import model.DAO.Impl.AccountDAOImpl;
import model.DAO.Impl.EmployeeDAOImpl;
import model.Employee;
import views.NavigationView;
import views.option_pane.PasswordInputPane;

public class LoginController {

    private final LoginView view;
    private final Connection connection;
    private AccountDAOImpl accountDAO;
    private EmployeeDAOImpl empDAO;
    private QueryProcessor query;

    public LoginController(LoginView view) throws SQLException, Exception {
        this.view = view;
        DatabaseConnection.connect(Constants.DB_HOST, Constants.DB_USER_NAME, Constants.DB_PASSWORD);
        this.connection = DatabaseConnection.getConnection();
        this.query = QueryProcessor.getInstance(connection);
        this.accountDAO = new AccountDAOImpl(connection);
        this.empDAO = new EmployeeDAOImpl(connection);
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
                    try {
                        appAcces();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        appAcces();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        return ka;
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

    private Employee checkEmployee() throws Exception {
        return empDAO.findById(accountDAO.findByName(view.getUserText()).getUser_id());
    }

    private boolean isNew() throws Exception {
        return accountDAO.findByName(view.getUserText()).getNewAccount() == 0;
    }

    public boolean checkUser() throws Exception {
        return accountDAO.findByName(view.getUserText()).checkPass(view.getPassText(), accountDAO.findByName(view.getUserText()).getPass());
    }

    private void appAcces() throws Exception {
        try {
            if (checkUser()) {
                if (isNew()) {
                    PasswordInputPane newPass = new PasswordInputPane(view, true);
                    PasswordInputPaneController newPassController = new PasswordInputPaneController(newPass, connection, view.getUserText());
                    newPass.setVisible(true);
                }
                view.dispose();
                NavigationView appView = new NavigationView(view, true);
                FrontController controller = new FrontController(appView, connection, checkEmployee());
                appView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, Constants.LOGIN_ERROR, "Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
