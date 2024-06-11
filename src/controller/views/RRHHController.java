package controller.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.panelViews.RRHHView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
import utils.Constantes;
import utils.QueryProcessor;

public class RRHHController {

    private final RRHHView view;
    private final Connection connection;
    private final QueryProcessor query;

    public RRHHController(RRHHView view, Connection connection) {
        this.view = view;
        this.connection = connection;
        this.query = new QueryProcessor(connection);
        this.view.addNameTextFieldListener(this.getNameTextFieldFocusListener());
        this.view.addSurnameTextFieldListener(getSurnameameTextFieldFocusListener());
        this.view.addSurname2TextFieldListener(this.getSurnameame2TextFieldFocusListener());
        this.view.addPhoneTextFieldListener(this.getPhoneTextFieldFocusListener());
        this.view.addMailTextFieldListener(this.getMailTextFieldFocusListener());
        this.view.addSurnameSearchTextFieldListener(this.getSurnameSearchTextFieldFocusListener());
        this.view.addAddButtonListener(this.getAddButtonActionListener());
        this.coverDeptCombo();
    }

    private void coverDeptCombo() {
        try {
            ResultSet rs = query.executeQuery("SELECT nombre FROM departamentos");

            while (rs.next()) {
                view.addDepartmentItem(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private ActionListener getAddButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUserSQL();
                addAccountSQL();
            }
        };
        return al;
    }

    private void addUserSQL() {
        int idDept = 0;
        try {
            ResultSet rs = query.executeQuery("SELECT dept_id FROM departamentos WHERE nombre = '" + view.getDepartment() + "'");
            if (rs.next()) {
                idDept = rs.getInt("dept_id");
            }

            final StringBuilder sql = new StringBuilder("INSERT ");
            sql.append("INTO EMPLEADOS (nombre, apellido1, apellido2, tlf, correo, departamento_id) ");
            sql.append("VALUES ('");
            sql.append(view.getNameText()).append("', '");
            sql.append(view.getSurnameText()).append("', '");
            sql.append(view.getSurname2Text()).append("', '");
            sql.append(view.getPhoneText()).append("', '");
            sql.append(view.getMailText()).append("', ");
            sql.append(idDept).append(")");

            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, Constantes.ADD_USER_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addAccountSQL() {
        int idEmp = 0;
        try {
            ResultSet rs = query.executeQuery("SELECT emp_id FROM empleados WHERE correo = '" + view.getMailText() + "'");
            if (rs.next()) {
                idEmp = rs.getInt("emp_id");
            }
            final StringBuilder sql = new StringBuilder("INSERT ");
            sql.append("INTO CUENTAS (nombre_usuario, clave, emp_id) ");
            sql.append("VALUES ('");
            sql.append(view.getNameText().toLowerCase()).append(".").append(view.getSurnameText().toLowerCase()).append("', '");
            sql.append("abc123.', ");
            sql.append(idEmp).append(")");

            query.executeStatement(sql.toString());

            JOptionPane.showMessageDialog(view, Constantes.ACTION_CONFIRM, "Añadido empleado", JOptionPane.PLAIN_MESSAGE);
            setDefault();
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, Constantes.ADD_USER_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setDefault() {
        view.setNameText("Nombre");
        view.setValid(view.getNameTextFieldComponent(), false);
        view.setSurnameText("Apellido1");
        view.setValid(view.getSurnameTextFieldComponent(), false);
        view.setSurname2Text("Apellido2");
        view.setValid(view.getSurname2TextFieldComponent(), false);
        view.setPhoneText("tlf");
        view.setValid(view.getPhoneTextFieldComponent(), false);
        view.setMailText("correo");
        view.setValid(view.getMailTextFieldComponent(), false);
    }
}
