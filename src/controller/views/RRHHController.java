package controller.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.panelViews.RRHHView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Account;
import model.Employee;
import utils.Constantes;
import utils.QueryProcessor;

public class RRHHController {

    private final RRHHView view;
    private final Connection connection;
    private final QueryProcessor query;
    private ArrayList<Employee> searchedEmployees;

    public RRHHController(RRHHView view, Connection connection) throws SQLException {
        this.view = view;
        this.connection = connection;
        this.query = new QueryProcessor(this.connection);
        this.view.addNameTextFieldListener(this.getNameTextFieldFocusListener());
        this.view.addSurnameTextFieldListener(getSurnameameTextFieldFocusListener());
        this.view.addSurname2TextFieldListener(this.getSurnameame2TextFieldFocusListener());
        this.view.addPhoneTextFieldListener(this.getPhoneTextFieldFocusListener());
        this.view.addMailTextFieldListener(this.getMailTextFieldFocusListener());
        this.view.addSurnameSearchTextFieldListener(this.getSurnameSearchTextFieldFocusListener());
        this.view.addAddButtonListener(this.getAddButtonActionListener());
        this.view.addSearchButtonListener(this.getSearchButtonActionListener());
        this.view.addDeleteButtonListener(this.getDeleteButtonActionListener());
        this.coverDeptCombo();
        this.coverEmployees();
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
                if (isTextFieldCover()) {
                    if (isValidPhone(view.getPhoneText())) {
                        if (isValidMail(view.getMailText())) {
                            addUserSQL();
                            addAccountSQL();
                            coverEmployees();
                        } else {
                            JOptionPane.showMessageDialog(view, Constantes.MAIL_ERROR, Constantes.ERROR, JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, Constantes.PHONE_ERROR, Constantes.ERROR, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, Constantes.ADD_USER_ERROR, Constantes.ERROR, JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
    }

    private ActionListener getSearchButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getSurnameSearchText().equals("Apellido")) {
                    coverEmployees();
                } else {
                    try {
                        searchedEmployees = new ArrayList<>();
                        ResultSet rs = query.executeQuery("SELECT emp_id, nombre, apellido1, apellido2 FROM empleados WHERE apellido1 = '" + view.getSurnameSearchText() + "'");

                        while (rs.next()) {
                            searchedEmployees.add(new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2")));
                        }

                        repaintTable(searchedEmployees);
                    } catch (Exception ex) {
                        Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        return al;
    }

    private ActionListener getDeleteButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getSelectedEmployeeId() == -1) {
                    JOptionPane.showMessageDialog(view, Constantes.DELETE_USER_ERROR, "Borrar", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int option = JOptionPane.showConfirmDialog(view, "Borrar usuario?", "Borrar", JOptionPane.YES_NO_OPTION);

                        if (option == 0) {
                            query.executeStatement("DELETE FROM fichadas WHERE emp_id = " + view.getSelectedEmployeeId());
                            query.executeStatement("DELETE FROM cuentas WHERE emp_id = " + view.getSelectedEmployeeId());
                            query.executeStatement("DELETE FROM empleados WHERE emp_id = " + view.getSelectedEmployeeId());
                        }

                        coverEmployees();
                    } catch (Exception ex) {
                        Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        return al;
    }

    private void coverEmployees() {
        try {
            searchedEmployees = new ArrayList<>();
            ResultSet rs = query.executeQuery("SELECT emp_id, nombre, apellido1, apellido2 FROM empleados");

            while (rs.next()) {
                searchedEmployees.add(new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2")));
            }

            repaintTable(searchedEmployees);
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            JOptionPane.showMessageDialog(view, Constantes.ADD_USER_ERROR, Constantes.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addAccountSQL() {
        Account account;
        try {
            ResultSet rs = query.executeQuery("SELECT emp_id FROM empleados WHERE correo = '" + view.getMailText() + "'");
            if (rs.next()) {
                account = new Account(view.getNameText().toLowerCase() + "." + view.getSurnameText().toLowerCase(), "abc123.", rs.getInt("emp_id"));
                final StringBuilder sql = new StringBuilder("INSERT ");
                sql.append("INTO CUENTAS (nombre_usuario, clave, emp_id) ");
                sql.append("VALUES ('");
                sql.append(account.getUserName()).append("','");
                sql.append(account.getPass()).append("',");
                sql.append(account.getUser_id()).append(")");

                query.executeStatement(sql.toString());

                JOptionPane.showMessageDialog(view, Constantes.ACTION_CONFIRM, "Añadido empleado", JOptionPane.INFORMATION_MESSAGE);
                setDefault();
            }

        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, Constantes.ADD_USER_ERROR, Constantes.ERROR, JOptionPane.ERROR_MESSAGE);
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

    private void repaintTable(ArrayList<Employee> employees) {
        view.removeDataTable();

        for (Employee e : employees) {
            Vector row = new Vector();

            row.add(e.getId());
            row.add(e.getName());
            row.add(e.getLastname1());
            row.add(e.getLastname2());

            view.addRowTable(row);
        }
    }

    private boolean isTextFieldCover() {
        return !((view.getNameText().trim().equals("") || view.getNameText().trim().equals("Nombre"))
                && (view.getSurnameText().trim().equals("") || view.getSurnameText().trim().equals("Apellido1"))
                && (view.getSurname2Text().trim().equals("") || view.getSurname2Text().trim().equals("Apellido2"))
                && (view.getPhoneText().trim().equals("") || view.getPhoneText().trim().equals("Tlf."))
                && (view.getMailText().trim().equals("")) || view.getMailText().trim().equals("email"));
    }

    private boolean isValidMail(String mail) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        Pattern pattern = java.util.regex.Pattern.compile(emailRegex);
        if (mail == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        String phoneRegex = "^\\+?[1-9]\\d{1,14}$";

        Pattern pattern = java.util.regex.Pattern.compile(phoneRegex);
        if (phone == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
