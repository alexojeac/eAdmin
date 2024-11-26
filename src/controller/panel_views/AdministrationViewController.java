package controller.panel_views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DAO.Impl.DepartmentDAOImpl;
import model.DAO.Impl.EmployeeDAOImpl;
import model.DAO.Impl.EnterpriseDAOImpl;
import model.Enterprise;
import utils.Constants;
import utils.Validator;
import views.panel_views.AdministrationView;

/**
 *
 * @author Alejandro Ojea
 */
public class AdministrationViewController {

    private AdministrationView view;
    private Connection connection;
    private EnterpriseDAOImpl enterpriseDAO;
    private EmployeeDAOImpl empDAO;
    private DepartmentDAOImpl deptDAO;

    public AdministrationViewController(AdministrationView view, Connection connection) throws Exception {
        this.view = view;
        this.connection = connection;
        enterpriseDAO = new EnterpriseDAOImpl(connection);
        empDAO = new EmployeeDAOImpl(connection);
        deptDAO = new DepartmentDAOImpl(connection);
        coverData();
        view.setEmpNumber(String.valueOf(empDAO.countEmployees()));
        view.setDeptNumber(String.valueOf(deptDAO.countDepartments()));
        this.view.addSaveButtonListener(this.getSaveButtonActionListener());
    }

    private ActionListener getSaveButtonActionListener() {
        ActionListener al = (ActionEvent e) -> {
            if (Validator.isValidEmail(view.getMailText())) {
                try {
                    if (enterpriseDAO.enterpriseExists(view.getIdText())) {
                        enterpriseDAO.update(new Enterprise(view.getIdText(), view.getNameText(), view.getAddressText(), view.getMailText()));
                    } else {
                        enterpriseDAO.insert(new Enterprise(view.getIdText(), view.getNameText(), view.getAddressText(), view.getMailText()));
                    }
                    JOptionPane.showMessageDialog(view, Constants.ENTERPRISE_SAVE, Constants.CONFIRM, JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, Constants.ENTERPRISE_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
                    Logger.getLogger(AdministrationViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(view, Constants.EMAIL_ERROR, Constants.ERROR, JOptionPane.WARNING_MESSAGE);
            }
        };
        return al;
    }

    private void coverData() throws Exception {
        Enterprise enterprise = enterpriseDAO.findAll();
        view.setNameText(enterprise.getName());
        view.setAddressText(enterprise.getAddress());
        view.setIdText(enterprise.getId());
        view.setMailText(enterprise.getMail());
    }

}
