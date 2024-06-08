package controller.views;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.panelViews.RRHHView;
import java.sql.Connection;

public class RRHHController {
    private final RRHHView view;
    private final Connection connection;

    public RRHHController(RRHHView view, Connection connection) {
        this.view = view;
        this.connection = connection;
        this.view.addNameTextFieldListener(this.getNameTextFieldFocusListener());
        this.view.addSurnameTextFieldListener(getSurnameameTextFieldFocusListener());
        this.view.addSurname2TextFieldListener(this.getSurnameame2TextFieldFocusListener());
        this.view.addPhoneTextFieldListener(this.getPhoneTextFieldFocusListener());
        this.view.addMailTextFieldListener(this.getMailTextFieldFocusListener());
        this.view.addSurnameSearchTextFieldListener(this.getSurnameSearchTextFieldFocusListener());
    }
    
    private FocusListener getNameTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNameText().equals("Nombre")) {
                    view.setNameText("");
                    view.setValid(view.getNameTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNameText().equals("")) {
                    view.setNameText("Nombre");
                    view.setValid(view.getNameTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
    
    private FocusListener getSurnameameTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getSurnameText().equals("Apellido1")) {
                    view.setSurnameText("");
                    view.setValid(view.getSurnameTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getSurnameText().equals("")) {
                    view.setSurnameText("Apellido1");
                    view.setValid(view.getSurnameTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
    
    private FocusListener getSurnameame2TextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getSurname2Text().equals("Apellido2")) {
                    view.setSurname2Text("");
                    view.setValid(view.getSurname2TextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getSurname2Text().equals("")) {
                    view.setSurname2Text("Apellido2");
                    view.setValid(view.getSurname2TextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
    
    private FocusListener getPhoneTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getPhoneText().equals("Tlf.")) {
                    view.setPhoneText("");
                    view.setValid(view.getPhoneTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getPhoneText().equals("")) {
                    view.setPhoneText("Tlf.");
                    view.setValid(view.getPhoneTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
    
    private FocusListener getMailTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getMailText().equals("email")) {
                    view.setMailText("");
                    view.setValid(view.getMailTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getMailText().equals("")) {
                    view.setMailText("email");
                    view.setValid(view.getMailTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
    
    private FocusListener getSurnameSearchTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getSurnameSearchText().equals("Apellido")) {
                    view.setSurnameSearchText("");
                    view.setValid(view.getSurnameSearchTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getSurnameSearchText().equals("")) {
                    view.setSurnameSearchText("Apellido");
                    view.setValid(view.getSurnameSearchTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
}
