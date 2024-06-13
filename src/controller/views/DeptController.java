package controller.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.panelViews.DeptView;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Department;
import utils.Constantes;
import utils.QueryProcessor;

public class DeptController {

    private final DeptView view;
    private final Connection connection;
    private final QueryProcessor query;
    private ArrayList<Department> searchedDeptos;

    public DeptController(DeptView view, Connection connection) throws SQLException {
        this.view = view;
        this.connection = connection;
        this.query = new QueryProcessor(connection);
        this.view.addNameTextFieldListener(this.getNameTextFieldFocusListener());
        this.view.addNameSearchTextFieldListener(this.getSearchNameTextFieldFocusListener());
        this.view.addIdTextFieldListener(this.getIdTextFieldFocusListener());
        this.view.addAddButtonListener(this.getAddButtonActionListener());
        this.view.addSearchButtonListener(this.getSearchButtonActionListener());
        this.view.addAddToDeptButtonListener(this.getAddToDeptButtonActionListener());
        coverDeptos();
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

    private ActionListener getAddButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValidDepto()) {
                    try {
                        query.executeStatement("INSERT INTO departamentos (nombre) VALUES ('" + view.getNameText() + "')");

                        JOptionPane.showMessageDialog(view, Constantes.ACTION_CONFIRM, "Departamento añadido", JOptionPane.INFORMATION_MESSAGE);
                        view.setNameText("Nombre depto");
                        view.setValid(view.getNameTextFieldComponent(), false);
                        coverDeptos();

                    } catch (Exception ex) {
                        Logger.getLogger(DeptController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, Constantes.DEPTO_ERROR, Constantes.ERROR, JOptionPane.WARNING_MESSAGE);
                }

            }
        };
        return al;
    }

    private ActionListener getSearchButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getSearchNameText().equals("Nombre depto")) {
                    coverDeptos();
                } else {
                    try {
                        searchedDeptos = new ArrayList<>();
                        ResultSet rs = query.executeQuery("SELECT dept_id, nombre FROM departamentos WHERE nombre = '" + view.getSearchNameText() + "'");

                        while (rs.next()) {
                            searchedDeptos.add(new Department(rs.getInt("dept_id"), rs.getString("nombre")));
                        }

                        repaintTable(searchedDeptos);
                        view.setSearchNameText("Nombre depto");
                        view.setValid(view.getSearchNameTextFieldComponent(), false);
                    } catch (Exception ex) {
                        Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        return al;
    }

    private ActionListener getAddToDeptButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (view.getIdText().equals("1")) {
                        JOptionPane.showMessageDialog(view, Constantes.CHANGE_ADMIN_WAR, Constantes.ERROR, JOptionPane.WARNING_MESSAGE);
                        view.setIdText("id empleado");
                        view.setValid(view.getIdTextFieldComponent(), false);
                        return;
                    }

                    if (isValidDeptoChange() && view.getSelectedDepartmentId() != -1) {
                        int option = JOptionPane.showConfirmDialog(view, "Cambiar el departamento de este usuario?",
                                "Cambio dept", JOptionPane.YES_NO_OPTION);

                        if (option == 0) {
                            query.executeStatement("UPDATE empleados SET departamento_id = " + view.getSelectedDepartmentId() + " WHERE emp_id = " + view.getIdText());
                        }

                        view.setIdText("id empleado");
                        view.setValid(view.getIdTextFieldComponent(), false);
                    } else {
                        JOptionPane.showMessageDialog(view, Constantes.INVALID_CHANGE_ERROR, Constantes.ERROR, JOptionPane.WARNING_MESSAGE);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DeptController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(view, Constantes.CHANGE_DEPT_USER, Constantes.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        return al;
    }

    private void coverDeptos() {
        try {
            searchedDeptos = new ArrayList<>();
            ResultSet rs = query.executeQuery("SELECT dept_id, nombre FROM departamentos");

            while (rs.next()) {
                searchedDeptos.add(new Department(rs.getInt("dept_id"), rs.getString("nombre")));
            }

            repaintTable(searchedDeptos);
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void repaintTable(ArrayList<Department> employees) {
        view.removeDataTable();

        for (Department d : employees) {
            Vector row = new Vector();

            row.add(d.getId());
            row.add(d.getName());

            view.addRowTable(row);
        }
    }

    private boolean isValidDepto() {
        return !(view.getNameText().trim().equals("Nombre depto") || view.getNameText().trim().equals(""));
    }

    private boolean isValidDeptoChange() {
        return !(view.getIdText().trim().equals("") || view.getIdText().trim().equals("id empleado"));
    }
}
