package controller.option_pane;

/**
 *
 * @author Alejandro Ojea
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import views.option_pane.PasswordInputPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Validator;
import javax.swing.JOptionPane;
import model.Account;
import model.DAO.Impl.AccountDAOImpl;
import utils.Constants;

public class PasswordInputPaneController {
    private final PasswordInputPane view;
    private final Connection connection;
    private final String user;
    private final AccountDAOImpl accountDAO;
    
    public PasswordInputPaneController(PasswordInputPane view, Connection connection, String user) throws SQLException, Exception {
        this.view = view;
        this.connection = connection;
        this.user = user;
        this.accountDAO = new AccountDAOImpl(connection);
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
                if (Validator.isValidPassword(view.getPassText())) {
                    if (passwordsMatch()) {
                        try {
                            Account account = accountDAO.findByName(user);
                            account.setCryptPass(view.getPassText());
                            accountDAO.update(account);
                            view.dispose();
                        } catch (Exception ex) {
                            Logger.getLogger(PasswordInputPaneController.class.getName()).log(Level.SEVERE, null, ex);
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

}
