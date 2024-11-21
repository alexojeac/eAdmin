package controller.panel_views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
import model.DAO.Impl.AccountDAOImpl;
import model.DAO.Impl.DepartmentDAOImpl;
import model.DAO.Impl.EmployeeDAOImpl;
import model.DAO.Impl.HolidayDAOImpl;
import model.DAO.Impl.TimeRecordDAOImpl;
import model.Department;
import model.Employee;
import model.Holiday;
import model.TimeRecord;
import utils.Constants;
import utils.Validator;
import views.panel_views.RRHHView;

/**
 *
 * @author Alejandro Ojea
 */
public class RRHHController {

    private final RRHHView view;
    private final Connection connection;
    private final EmployeeDAOImpl empDAO;
    private final TimeRecordDAOImpl trDAO;
    private final AccountDAOImpl accountDAO;
    private final HolidayDAOImpl holidayDAO;
    private final DepartmentDAOImpl deptDAO;

    public RRHHController(RRHHView view, Connection connection) throws SQLException, Exception {
        this.view = view;
        this.connection = connection;
        this.empDAO = new EmployeeDAOImpl(connection);
        this.trDAO = new TimeRecordDAOImpl(connection);
        this.accountDAO = new AccountDAOImpl(connection);
        this.holidayDAO = new HolidayDAOImpl(connection);
        this.deptDAO = new DepartmentDAOImpl(connection);
        this.repaintHolidaysTable(holidayDAO.findByState());
        this.coverDeptCombo(deptDAO.findAll());
        this.coverDeptNewEmpCombo(deptDAO.findAll());
        this.coverDeptUpdateCombo(deptDAO.findAll());
        this.coverDeptDeleteCombo(deptDAO.findAll());
        this.coverNewDeptDeleteCombo(deptDAO.findAll());
        try {
            this.coverEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptComboSelectedItem()).getId()));
            this.coverUpdateEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptUpdateComboSelectedItem()).getId()));
            this.coverDeleteEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptDeleteEmpComboSelectedItem()).getId()));
        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.view.addMoreButtonListener(this.getMoreButtonActionListener());
        this.view.addRefreshButtonListener(this.getRefreshButtonActionListener());
        this.view.addUpdateButtonListener(this.getUpdateButtonActionListener());
        this.view.addDeleteButtonListener(this.getDeleteButtonActionListener());
        this.view.addAddButtonListener(this.getAddButtonActionListener());
        this.view.addDeptComboListener(this.getDeptComboActionListener());
        this.view.addDeptUpdateEmpComboListener(this.getDeptUpdateEmpComboActionListener());
        this.view.addDeptDeleteEmpComboListener(this.getDeptDeleteEmpComboActionListener());
        this.view.addNameTextFieldListener(this.getNameTextFieldFocusListener());
        this.view.addLastName1TextFieldListener(this.getLastName1TextFieldFocusListener());
        this.view.addLastName2TextFieldListener(this.getLastName2TextFieldFocusListener());
        this.view.addIdTextFieldListener(this.getIdTextFieldFocusListener());
        this.view.addAddressTextFieldListener(this.getAddressTextFieldFocusListener());
        this.view.addMailTextFieldListener(this.getMailTextFieldFocusListener());
        this.view.addPhoneTextFieldListener(this.getPhoneTextFieldFocusListener());
        this.view.addSalaryTextFieldListener(this.getSalaryTextFieldFocusListener());
        this.view.addNewMailTextFieldListener(this.getNewMailTextFieldFocusListener());
        this.view.addNewSalaryTextFieldListener(this.getNewSalaryTextFieldFocusListener());
        this.view.addNewAddressTextFieldListener(this.getNewAddressTextFieldFocusListener());
        this.view.addNewPhoneTextFieldListener(this.getNewPhoneTextFieldFocusListener());
    }

    private ActionListener getMoreButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            Employee emp;
            try {
                emp = empDAO.findById(accountDAO.findByName(view.getNameSelectedRequestHoliday()).getUser_id());

                Holiday holiday = holidayDAO.findById(view.getIdSelectedRequestHoliday());
                StringBuilder sb = new StringBuilder(emp.getName());
                sb.append(" ").append(emp.getLastname1()).append(" ").append(emp.getLastname2());

                int option = JOptionPane.showOptionDialog(view, String.format(Constants.HOLIDAY_REQUEST_MESSAGE,
                        sb.toString(), holiday.getInitDay(), holiday.getFinishDate()),
                        view.getNameSelectedRequestHoliday(), JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new String[]{"Aceptar", "Rechazar"}, "Aceptar");

                if (option == 0) {
                    holiday.setAccept(1);
                } else if (option == 1) {
                    holiday.setAccept(2);
                }

                holidayDAO.update(holiday);
                repaintHolidaysTable(holidayDAO.findByState());
            } catch (Exception ex) {
                Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return al;
    }

    private ActionListener getRefreshButtonActionListener() {
        return e -> {
            if (view.getDateFrom() == null) {
                JOptionPane.showMessageDialog(view, "La fecha de inicio no puede estar vacía.", Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (view.getDateUntil() == null) {
                JOptionPane.showMessageDialog(view, "La fecha final no puede estar vacía.", Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (view.getDateUntil().isBefore(view.getDateFrom())) {
                JOptionPane.showMessageDialog(view, "La fecha final no puede ser anterior a la fecha de inicio.", Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!view.isDeptComboEmpty() && !view.isEmpComboEmpty()) {
                String selectedItem = view.getEmpComboSelectedItem();
                if (selectedItem == null || selectedItem.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Seleccione un empleado válido.", Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Employee emp;
                try {
                    emp = empDAO.findById(view.getEmpComboSelectedItem().split(" - ")[0]);

                    if (emp == null || emp.getId().equals("")) {
                        JOptionPane.showMessageDialog(view, "Empleado no encontrado.", Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    repaintTimeRecordTable(trDAO.findByEmpIdAndDateFromUntil(emp.getId(),
                            view.getDateFrom(), view.getDateUntil()), emp);
                } catch (Exception ex) {
                    Logger.getLogger(RRHHController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(view, Constants.INVALID_DATA_SEARCH, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
    }

    private ActionListener getUpdateButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                Employee emp = empDAO.findById(view.getEmpUpdateComboSelectedItem().split(" - ")[0]);

                if (Validator.isValidEmail(view.getNewMailText())) {
                    emp.setMail(view.getNewMailText());
                } else {
                    if (!view.getNewMailText().equals("Nuevo email")) {
                        JOptionPane.showMessageDialog(view, Constants.EMAIL_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                if (Validator.isValidPhoneNumber(view.getNewPhoneText())) {
                    emp.setMail(view.getNewPhoneText());
                } else {
                    if (!view.getNewPhoneText().equals("Nuevo tlf")) {
                        JOptionPane.showMessageDialog(view, Constants.PHONE_NUMBER_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                if (!view.getNewSalaryText().equals("Nuevo salario")) {
                    emp.setSalary(Double.parseDouble(view.getNewSalaryText()));
                }

                if (!view.getNewAddressText().equals("Nueva dirección")) {
                    emp.setAddress(view.getNewAddressText());
                }

                if (!view.getUpdateNewDeptComboSelectedItem().equals("")) {
                    emp.setDept_id(deptDAO.findByName(view.getUpdateNewDeptComboSelectedItem()).getId());

                }
                empDAO.update(emp);

                JOptionPane.showMessageDialog(view, Constants.UPDATE_EMP_SUCCESS, Constants.ERROR, JOptionPane.INFORMATION_MESSAGE);

                view.setValidNewMailText(false);
                view.setNewMailText("Nuevo email");
                view.setValidSalaryText(false);
                view.setNewSalaryText("Nuevo salario");
                view.setValidNewAddressText(false);
                view.setNewAddressText("Nueva dirección");
                view.setValidNewPhoneText(false);
                view.setNewPhoneText("Nuevo tlf");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, Constants.INVALID_SALARY, Constants.ERROR, JOptionPane.WARNING_MESSAGE);

            } catch (Exception ex) {
                Logger.getLogger(RRHHController.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, Constants.ERROR_UPDATE_EMP, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
        return al;
    }

    private ActionListener getDeleteButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                int option = JOptionPane.showOptionDialog(view,
                        String.format(Constants.CONFIRM_DELETE_EMP, view.getDeleteEmpComboSelectedItem()),
                        Constants.CONFIRM_DELETE_EMP_TITLE, JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new String[]{"Eliminar", "Cancelar"}, "Eliminar");

                if (option == 0) {
                    empDAO.delete(view.getDeleteEmpComboSelectedItem().split(" - ")[0]);
                    JOptionPane.showMessageDialog(view, Constants.DELETE_EMP, Constants.CONFIRM_DELETE_EMP_TITLE, JOptionPane.WARNING_MESSAGE);
                }
                coverAllEmpCombos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, Constants.ERROR_DELETE_EMP, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }

        };
        return al;
    }

    private ActionListener getAddButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                if (view.getNameText().equals("Nombre") || view.getLastname1Text().equals("Apellido 1")) {
                    JOptionPane.showMessageDialog(view, Constants.ERROR_NAME_LASTNAME, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (!Validator.isValidDni(view.getIdText())) {
                    JOptionPane.showMessageDialog(view, Constants.DNI_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (!Validator.isValidEmail(view.getMailText())) {
                    JOptionPane.showMessageDialog(view, Constants.EMAIL_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (!Validator.isValidPhoneNumber(view.getPhoneText())) {
                    JOptionPane.showMessageDialog(view, Constants.PHONE_NUMBER_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (!Validator.isValidSalary(view.getSalaryText())) {
                    JOptionPane.showMessageDialog(view, Constants.INVALID_SALARY, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Employee emp = new Employee(view.getIdText(), view.getNameText(), view.getLastname1Text(), view.getLastname2Text(), view.getMailText(),
                        LocalDate.now(), deptDAO.findByName(view.getDeptNewEmpComboSelectedItem()).getId(), Double.parseDouble(view.getSalaryText()),
                        view.getPhoneText(), view.getAddressText());

                if (emp.getLastname2().equals("Apellido 1")) {
                    emp.setLastname2("");
                }
                if (emp.getAddress().equals("Dirección")) {
                    emp.setAddress("");
                }

                empDAO.insert(emp);
                accountDAO.insert(new Account(emp.getId(), "abc123.", emp.getId()));
                JOptionPane.showMessageDialog(view, String.format(Constants.INSERT_EMP_SUCCESS,
                        emp.getId()), Constants.CONFIRM, JOptionPane.INFORMATION_MESSAGE);

                view.setValidNameText(false);
                view.setNameText("Nombre");
                view.setValidLastname1Text(false);
                view.setLastname1Text("Apellido 1");
                view.setValidLastname2Text(false);
                view.setLastname2Text("Apellido 2");
                view.setValidAddressText(false);
                view.setIdText("DNI");
                view.setValiIdText(false);
                view.setAddressText("Dirección");
                view.setValidMailText(false);
                view.setMailText("email");
                view.setValidPhoneText(false);
                view.setPhoneText("tlf");
                view.setValidSalaryText(false);
                view.setSalaryText("Salario");
                coverAllEmpCombos();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, Constants.INVALID_SALARY, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, Constants.INSERT_EMP_ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        };
        return al;
    }

    private FocusListener getNameTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNameText().equals("Nombre")) {
                    view.setNameText("");
                    view.setValidNameText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNameText().equals("")) {
                    view.setNameText("Nombre");
                    view.setValidNameText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getLastName1TextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getLastname1Text().equals("Apellido 1")) {
                    view.setLastname1Text("");
                    view.setValidLastname1Text(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNameText().equals("")) {
                    view.setNameText("Apellido 1");
                    view.setValidNameText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getLastName2TextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getLastname2Text().equals("Apellido 2")) {
                    view.setLastname2Text("");
                    view.setValidLastname2Text(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getLastname2Text().equals("")) {
                    view.setLastname2Text("Apellido 2");
                    view.setValidLastname2Text(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getIdTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getIdText().equals("DNI")) {
                    view.setIdText("");
                    view.setValiIdText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getIdText().equals("")) {
                    view.setIdText("DNI");
                    view.setValiIdText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getAddressTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getAddressText().equals("Dirección")) {
                    view.setAddressText("");
                    view.setValidAddressText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getAddressText().equals("")) {
                    view.setAddressText("Dirección");
                    view.setValidAddressText(false);
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
                    view.setValidMailText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getMailText().equals("")) {
                    view.setMailText("email");
                    view.setValidMailText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getPhoneTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getPhoneText().equals("tlf")) {
                    view.setPhoneText("");
                    view.setValidPhoneText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getPhoneText().equals("")) {
                    view.setPhoneText("tlf");
                    view.setValidPhoneText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getSalaryTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getSalaryText().equals("Salario")) {
                    view.setSalaryText("");
                    view.setValidSalaryText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getSalaryText().equals("")) {
                    view.setSalaryText("Salario");
                    view.setValidSalaryText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getNewMailTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNewMailText().equals("Nuevo email")) {
                    view.setNewMailText("");
                    view.setValidNewMailText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNewMailText().equals("")) {
                    view.setNewMailText("Nuevo email");
                    view.setValidNewMailText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getNewSalaryTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNewSalaryText().equals("Nuevo salario")) {
                    view.setNewSalaryText("");
                    view.setValidNewSalaryText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNewSalaryText().equals("")) {
                    view.setNewSalaryText("Nuevo salario");
                    view.setValidNewSalaryText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getNewAddressTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNewAddressText().equals("Nueva dirección")) {
                    view.setNewAddressText("");
                    view.setValidNewAddressText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNewAddressText().equals("")) {
                    view.setNewAddressText("Nueva dirección");
                    view.setValidNewAddressText(false);
                }
            }
        };
        return listener;
    }

    private FocusListener getNewPhoneTextFieldFocusListener() {
        FocusListener listener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.getNewPhoneText().equals("Nuevo tlf")) {
                    view.setNewPhoneText("");
                    view.setValidNewPhoneText(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.getNewPhoneText().equals("")) {
                    view.setNewPhoneText("Nuevo tlf");
                    view.setValidNewPhoneText(false);
                }
            }
        };
        return listener;
    }

    private ActionListener getDeptComboActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                coverEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptComboSelectedItem()).getId()));

            } catch (Exception ex) {
                Logger.getLogger(RRHHController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        };
        return al;
    }

    private ActionListener getDeptUpdateEmpComboActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                coverUpdateEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptUpdateComboSelectedItem()).getId()));

            } catch (Exception ex) {
                Logger.getLogger(RRHHController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        };
        return al;
    }

    private ActionListener getDeptDeleteEmpComboActionListener() {
        ActionListener al = (ActionEvent e) -> {
            try {
                coverDeleteEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptDeleteEmpComboSelectedItem()).getId()));

            } catch (Exception ex) {
                Logger.getLogger(RRHHController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        };
        return al;
    }

    private void coverAllEmpCombos() {
        try {
            coverDeleteEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptDeleteEmpComboSelectedItem()).getId()));
            coverUpdateEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptUpdateComboSelectedItem()).getId()));
            coverEmpCombo(empDAO.findByDeptId(deptDAO.findByName(view.getDeptComboSelectedItem()).getId()));

        } catch (Exception ex) {
            Logger.getLogger(RRHHController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void coverDeptCombo(List<Department> depts) {
        for (Department dept : depts) {
            view.setDeptComboItem(dept.getName());
        }
    }

    private void coverDeptNewEmpCombo(List<Department> depts) {
        for (Department dept : depts) {
            view.setDeptNewEmpComboItem(dept.getName());
        }
    }

    private void coverDeptUpdateCombo(List<Department> depts) {
        for (Department dept : depts) {
            view.setUpdateDeptComboItem(dept.getName());
        }
    }

    private void coverDeptDeleteCombo(List<Department> depts) {
        for (Department dept : depts) {
            view.setDeptDeleteEmpComboItem(dept.getName());
        }
    }

    private void coverNewDeptDeleteCombo(List<Department> depts) {
        view.setUpdateNewDeptComboItem("");
        for (Department dept : depts) {
            view.setUpdateNewDeptComboItem(dept.getName());
        }
    }

    private void coverEmpCombo(List<Employee> employees) {
        view.removeAllItemsEmpCombo();
        for (Employee employee : employees) {
            view.setEmpComboItem(employee.getId() + " - " + employee.getName() + " " + employee.getLastname1());
        }
    }

    private void coverUpdateEmpCombo(List<Employee> employees) {
        view.removeAllItemsUpdateEmpCombo();
        for (Employee employee : employees) {
            view.setEmpUpdateComboItem(employee.getId() + " - " + employee.getName() + " " + employee.getLastname1());
        }
    }

    private void coverDeleteEmpCombo(List<Employee> employees) {
        view.removeAllItemsDeleteEmpCombo();
        for (Employee employee : employees) {
            view.setDeleteEmpComboItem(employee.getId() + " - " + employee.getName() + " " + employee.getLastname1());
        }
    }

    private void repaintTimeRecordTable(List<TimeRecord> timeRecords, Employee emp) {
        view.removeEmpDataTable();

        for (TimeRecord tr : timeRecords) {
            Vector row = new Vector();

            row.add(emp.getName());
            row.add(emp.getLastname1() + " " + emp.getLastname2());
            row.add(tr.getDate());
            row.add(tr.getIn());
            row.add(tr.getOut());

            view.addEmpRowTable(row);
        }
    }

    private void repaintHolidaysTable(List<Holiday> holidays) throws Exception {
        view.removeHolidayReqTable();

        for (Holiday h : holidays) {
            Vector row = new Vector();

            row.add(accountDAO.findByEmpId(h.getEmp_id()).getUserName());
            row.add(h.getInitDay());
            row.add(h.getFinishDate());
            row.add(h.getId());

            view.addHolidayReqRowTable(row);
        }
    }
}
