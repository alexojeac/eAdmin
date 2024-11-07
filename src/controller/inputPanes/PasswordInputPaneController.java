package controller.inputPanes;

import db.QueryProcessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import views.panel_views.PasswordInputPane;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Account;
import utils.Constants;

public class PasswordInputPaneController {
    private final PasswordInputPane view;
    private final Connection connection;
    private final QueryProcessor query;
    private final String user;
    
    public PasswordInputPaneController(PasswordInputPane view, Connection connection, String user) throws SQLException {
        this.view = view;
        this.connection = connection;
        this.user = user;
        this.query = new QueryProcessor(this.connection);
        this.view.addPasswordTextFieldListener(this.getPasswordTextFieldFocusListener());
        this.view.addRepeatPasswordTextFieldListener(this.getRepeatPasswordTextFieldFocusListener());
        this.view.addAcceptButtonListener(this.getAcceptButtonActionListener());
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
    
    private FocusListener getRepeatPasswordTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getRepeatPassText().equals("jPasswordField1")) {
                    view.setRepeatPassText("");
                    view.setValidRepeatPass(true);
                }
                
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (view.getRepeatPassText().equals("")) {
                    view.setRepeatPassText("jPasswordField1");
                    view.setValidRepeatPass(false);
                }
            }
        };
        return listener;
    }
    
    private ActionListener getAcceptButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValidPassword(view.getPassText())) {
                    if (passwordsMatch()) {
                        Account account = new Account(view.getPassText());
                        try {
                            query.executeStatement("UPDATE cuentas SET clave = '" + account.getPass() + "' WHERE nombre_usuario = '" + user + "'");
                            query.executeStatement("UPDATE cuentas SET nuevo = 1 WHERE nombre_usuario = '" + user + "'");
                            view.dispose();
                        } catch (SQLException ex) {
                            //Logger.getLogger(PasswordInputPaneController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(view, Constants.PASS_MATCH_ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, Constants.PASS_MATCH_ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        return al;
    }
    
    public boolean passwordsMatch() {
        return view.getPassText().equals(view.getRepeatPassText());
    }
    
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{6,}$";
        
        Pattern pattern = java.util.regex.Pattern.compile(passwordRegex);
        
        if (password == null) {
            return false;
        }
        
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
