package controller;

import controller.app.AppController;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.login.LoginView;
import view.app.AppView;

public class FrontController {

    private final LoginView view;

    public FrontController(LoginView view) {
        this.view = view;
        this.view.addExitLabelListener(this.getExitLabelMouseListener());
        this.view.addLoginButtonLabelListener(this.getLoginButtonLabelMouseListener());
        this.view.addUserTextFieldListener(this.getUserTextFieldFocusListener());
        this.view.addPasswordTextFieldListener(this.getPasswordTextFieldFocusListener());
    }

    private MouseAdapter getExitLabelMouseListener() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.exit(0);
                    System.out.println("Exit pulsado");
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
                    view.dispose();
                    AppView accountView = new AppView(view, true);
                    AppController controller = new AppController(accountView);

                    accountView.setVisible(true);
                }
            }
        };
        return adapter;
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
}
