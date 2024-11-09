package controller.panel_views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.DAO.Impl.DepartmentDAOImpl;
import model.DAO.Impl.EmployeeDAOImpl;
import model.Department;
import model.Employee;
import utils.Constants;
import views.panel_views.DepartmentView;

public class DepartmentViewController {

    private final DepartmentView view;
    private final Connection connection;
    private final EmployeeDAOImpl employeeDAO;
    private final DepartmentDAOImpl deptDAO;

    public DepartmentViewController(DepartmentView view, Connection connection) throws SQLException {
        this.view = view;
        this.connection = connection;
        this.employeeDAO = new EmployeeDAOImpl(connection);
        this.deptDAO = new DepartmentDAOImpl(connection);
        this.coverDeptoCombo(deptDAO.findAll());
        this.view.addRefreshButtonListener(this.getRefreshButtonActionListener());
        this.view.addAddDeptButtonListener(this.getAddDeptButtonActionListener());
        this.view.addUpdateDeptButtonListener(this.getUpdateDeptButtonListener());
        this.view.addDeleteDeptButtonListener(this.getDeleteDeptButton());
        this.view.addNewDeptTextFieldListener(this.getNewDeptTextFieldFocusListener());
        this.view.addUpdateNameTextField(this.getUpdateDeptTextFieldFocusListener());
    }

    private ActionListener getRefreshButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            repaintEmployeesTable(employeeDAO.findByDeptId(deptDAO.findByName(view.getSelectedDept()).getId()));
        };
        return al;
    }

    private ActionListener getAddDeptButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            if (!view.getNewDeptText().equals("Nombre")) {
                deptDAO.insert(new Department(view.getNewDeptText(), view.getNewRightsCombo().equals("Usuario") ? 0
                        : view.getNewRightsCombo().equals("Recursos humanos") ? 1 : 2));

                coverDeptoCombo(deptDAO.findAll());
                view.setNewDeptText("Nombre");
                view.setValidNewDept(false);
            } else {
                JOptionPane.showMessageDialog(view, Constants.ERROR_DEPT_NAME, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
        return al;
    }

    private ActionListener getUpdateDeptButtonListener() {
        ActionListener al = (ActionEvent e) -> {
            if (!view.getUpdateNametext().equals("Nuevo nombre")) {
                Department dept = deptDAO.findByName(view.getUpdateDeptCombo());
                dept.setName(view.getUpdateNametext());
                dept.setRight(view.getNewRightsCombo().equals("Usuario") ? 0
                        : view.getNewRightsCombo().equals("Recursos humanos") ? 1 : 2);

                deptDAO.update(dept);

                coverDeptoCombo(deptDAO.findAll());
                view.setUpdateNameText("Nuevo nombre");
                view.setValidUpdateDept(false);
            } else {
                JOptionPane.showMessageDialog(view, Constants.ERROR_DEPT_NAME, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
        return al;
    }

    private ActionListener getDeleteDeptButton() {
        ActionListener al = (ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(view, Constants.CONFIRM_DELETE_DEPT, Constants.CONFIRM,
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                employeeDAO.findByDeptId(deptDAO.findByName(view.getDeleteDeptCombo()).getId())
                        .forEach(employee -> employeeDAO.updateDept(employee.getId(), deptDAO.findByName("Genérico").getId()));

                deptDAO.delete(deptDAO.findByName(view.getDeleteDeptCombo()).getId());
                coverDeptoCombo(deptDAO.findAll());
            }
        };
        return al;
    }

    private FocusListener getNewDeptTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNewDeptText().equals("Nombre")) {
                    view.setNewDeptText("");
                    view.setValidNewDept(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNewDeptText().equals("")) {
                    view.setNewDeptText("Nombre");
                    view.setValidNewDept(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getUpdateDeptTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getUpdateNametext().equals("Nuevo nombre")) {
                    view.setUpdateNameText("");
                    view.setValidUpdateDept(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getUpdateNametext().equals("")) {
                    view.setUpdateNameText("Nuevo nombre");
                    view.setValidUpdateDept(false);
                }
            }
        };
        return listener;
    }

    private void coverDeptoCombo(List<Department> depts) {
        view.removeAllItemsDeptCombo();
        view.removeAllItemsUpdateDeptCombo();
        view.removeAllItemsDeleteDeptCombo();

        for (Department dept : depts) {
            if (dept.getId() != 2 && dept.getId() != 3 && dept.getId() != 4) {
                view.setDeptsCombo(dept.getName());
                view.setDeleteDeptCombo(dept.getName());
                view.setUpdateDeptCombo(dept.getName());
            }
        }
    }

    private void repaintEmployeesTable(List<Employee> holidays) {
        view.removeEmpDataTable();

        for (Employee e : holidays) {
            Vector row = new Vector();

            row.add(e.getName());
            row.add(e.getLastname1() + " " + e.getLastname2());
            row.add(e.getContractDate());
            row.add(e.getAddress());
            row.add(e.getTelephone());

            view.addEmpRowTable(row);
        }
    }

}
