
package controller.views;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.panelViews.DeptView;

public class DeptController {
    DeptView view;

    public DeptController(DeptView view) {
        this.view = view;
        this.view.addNameTextFieldListener(this.getNameTextFieldFocusListener());
        this.view.addPhoneTextFieldListener(this.getPhoneTextFieldFocusListener());
        this.view.addNameSearchTextFieldListener(this.getSearchNameTextFieldFocusListener());
        this.view.addIdTextFieldListener(this.getIdTextFieldFocusListener());
    }
    
    private FocusListener getNameTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNameText().equals("Nombre depto")) {
                    view.setNameText("");
                    view.setValid(view.getNameTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNameText().equals("")) {
                    view.setNameText("Nombre depto");
                    view.setValid(view.getNameTextFieldComponent(), false);
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
    
    private FocusListener getSearchNameTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getSearchNameText().equals("Nombre depto")) {
                    view.setSearchNameText("");
                    view.setValid(view.getSearchNameTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getSearchNameText().equals("")) {
                    view.setSearchNameText("Nombre depto");
                    view.setValid(view.getSearchNameTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
    
    private FocusListener getIdTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getIdText().equals("id empleado")) {
                    view.setIdText("");
                    view.setValid(view.getIdTextFieldComponent(), true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getIdText().equals("")) {
                    view.setIdText("id empleado");
                    view.setValid(view.getIdTextFieldComponent(), false);
                }
            }
        };
        return listener;
    }
}
