package controller;

import controller.app.AppController;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.login.LoginView;
import view.app.AppView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
import model.Employee;
import utils.Constantes;
import utils.DatabaseConnector;
import utils.QueryProcessor;

public class FrontController {
    
    private final LoginView view;
    private final Connection connection;
    private final QueryProcessor query;
    
    public FrontController(LoginView view) throws SQLException {
        this.view = view;
        DatabaseConnector.connect(Constantes.DB_HOST, Constantes.DB_USER_NAME, Constantes.DB_PASSWORD);
        this.connection = DatabaseConnector.getConnection();
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
            ResultSet rs = query.executeQuery("SELECT nuevo FROM cuentas WHERE nombre_usuario = '" + view.getUserText() + "'");
            return (rs.next() && rs.getInt("nuevo") == 0);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private void appAcces() {
        try {
            if (query.checkUser(view.getUserText(), view.getPassText())) {
                if (isNew()) {
                    String pass = JOptionPane.showInputDialog(view, "Introduce la contraseña para elnuevo ususario");
                    query.executeStatement("UPDATE cuentas SET clave = '" + pass + "' WHERE nombre_usuario = '" + view.getUserText() + "'");
                    query.executeStatement("UPDATE cuentas SET nuevo = 1 WHERE nombre_usuario = '" + view.getUserText() + "'");
                }
                view.dispose();
                AppView appView = new AppView(view, true);
                AppController controller = new AppController(appView, connection, checkEmployee());
                JOptionPane.showMessageDialog(appView, "La sección de Administración está actualmente en mantenimiento",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                appView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, Constantes.LOGIN_ERROR, "Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(view, Constantes.ACCES_ERROR, "Error", JOptionPane.WARNING_MESSAGE);
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
            ResultSet rs = query.executeQuery("SELECT * FROM empleados WHERE emp_id = (SELECT emp_id FROM cuentas WHERE nombre_usuario = '" + view.getUserText() + "')");
            
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
