package views.panel_views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class RRHHView extends javax.swing.JPanel {

    public RRHHView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        titleLabel = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        untilDateChooser = new com.toedter.calendar.JDateChooser();
        deptComboBox = new javax.swing.JComboBox<>();
        empComboBox = new javax.swing.JComboBox<>();
        fromLabel = new javax.swing.JLabel();
        untilLabel = new javax.swing.JLabel();
        deptLabel = new javax.swing.JLabel();
        empLabel = new javax.swing.JLabel();
        empScrollPane = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        separator1 = new javax.swing.JSeparator();
        updateLabel = new javax.swing.JLabel();
        deptUpdateComboBox = new javax.swing.JComboBox<>();
        empUpdateComboBox = new javax.swing.JComboBox<>();
        newDeptComboBox = new javax.swing.JComboBox<>();
        newMailTextField = new javax.swing.JTextField();
        addEmpButton = new javax.swing.JButton();
        separator2 = new javax.swing.JSeparator();
        addEmpLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        lastname1TextField = new javax.swing.JTextField();
        deptNewEmpComboBox = new javax.swing.JComboBox<>();
        emailTextField = new javax.swing.JTextField();
        deleteEmpButton = new javax.swing.JButton();
        separator3 = new javax.swing.JSeparator();
        deptDeleteEmpComboBox = new javax.swing.JComboBox<>();
        deleteEmpComboBox = new javax.swing.JComboBox<>();
        deleteTitleLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        lastName2TextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        salaryTextField = new javax.swing.JTextField();
        newSalaryTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        newAddressTextField = new javax.swing.JTextField();
        newPhoneTextField = new javax.swing.JTextField();
        separator4 = new javax.swing.JSeparator();
        holidayReqScrollPane = new javax.swing.JScrollPane();
        holidayReqTable = new javax.swing.JTable();
        moreButton = new javax.swing.JButton();
        holidayReqLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        titleLabel.setText("Listado entradas/salidas");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        add(fromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 30));
        add(untilDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, 30));

        add(deptComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 130, 30));

        add(empComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 160, 30));

        fromLabel.setText("Desde:");
        add(fromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        untilLabel.setText("Hasta:");
        add(untilLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        deptLabel.setText("Departamento:");
        add(deptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        empLabel.setText("Empleado:");
        add(empLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Fecha", "Hora entrada", "Hora salida", "Horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empScrollPane.setViewportView(empTable);

        add(empScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 610, 170));
        add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 930, 10));

        updateLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        updateLabel.setText("Modificar empleado:");
        add(updateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 30));

        add(deptUpdateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 140, 30));

        add(empUpdateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 140, 30));

        add(newDeptComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 170, 30));

        newMailTextField.setForeground(new java.awt.Color(204, 204, 204));
        newMailTextField.setText("Nuevo email");
        add(newMailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 170, 30));

        addEmpButton.setBackground(new java.awt.Color(0, 134, 190));
        addEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        addEmpButton.setText("Añadir empleado");
        add(addEmpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, 140, 30));
        add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 930, 10));

        addEmpLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        addEmpLabel.setText("Añadir empleado");
        add(addEmpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 30));

        nameTextField.setForeground(new java.awt.Color(204, 204, 204));
        nameTextField.setText("Nombre");
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 100, 30));

        lastname1TextField.setForeground(new java.awt.Color(204, 204, 204));
        lastname1TextField.setText("Apellido 1");
        add(lastname1TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 100, 30));

        add(deptNewEmpComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 220, 30));

        emailTextField.setForeground(new java.awt.Color(204, 204, 204));
        emailTextField.setText("email");
        add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 320, 30));

        deleteEmpButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteEmpButton.setText("Eliminar empleado");
        add(deleteEmpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 170, 30));

        separator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(separator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 10, 110));

        add(deptDeleteEmpComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 150, 30));

        add(deleteEmpComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 270, 30));

        deleteTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        deleteTitleLabel.setText("Eliminar empleado");
        add(deleteTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, -1, 30));

        refreshButton.setBackground(new java.awt.Color(0, 134, 190));
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh_icon.png"))); // NOI18N
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 80, 30));

        lastName2TextField.setForeground(new java.awt.Color(204, 204, 204));
        lastName2TextField.setText("Apellido 2");
        add(lastName2TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 100, 30));

        phoneTextField.setForeground(new java.awt.Color(204, 204, 204));
        phoneTextField.setText("tlf");
        add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 100, 30));

        addressTextField.setForeground(new java.awt.Color(204, 204, 204));
        addressTextField.setText("Dirección");
        add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 180, 30));

        salaryTextField.setForeground(new java.awt.Color(204, 204, 204));
        salaryTextField.setText("Salario");
        add(salaryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 110, 30));

        newSalaryTextField.setForeground(new java.awt.Color(204, 204, 204));
        newSalaryTextField.setText("Nuevo salario");
        add(newSalaryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 100, 30));

        updateButton.setBackground(new java.awt.Color(0, 134, 190));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Modificar");
        add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, 30));

        newAddressTextField.setForeground(new java.awt.Color(204, 204, 204));
        newAddressTextField.setText("Nueva dirección");
        add(newAddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 160, 30));

        newPhoneTextField.setForeground(new java.awt.Color(204, 204, 204));
        newPhoneTextField.setText("Nuevo tlf");
        add(newPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 90, 30));

        separator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(separator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 10, 210));

        holidayReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuario", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        holidayReqScrollPane.setViewportView(holidayReqTable);

        add(holidayReqScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 260, 180));

        moreButton.setBackground(new java.awt.Color(0, 134, 190));
        moreButton.setForeground(new java.awt.Color(255, 255, 255));
        moreButton.setText("Más");
        add(moreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 53, 60, 30));

        holidayReqLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        holidayReqLabel.setText("Solicitudes de vacaciones");
        add(holidayReqLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void removeEmpDataTable() {
        DefaultTableModel model = (DefaultTableModel) empTable.getModel();
        model.setRowCount(0);
        empTable.clearSelection();
        empTable.revalidate();
        empTable.repaint();
    }

    public void addEmpRowTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) empTable.getModel();
        model.addRow(row);
    }

    public void removeHolidayReqTable() {
        DefaultTableModel model = (DefaultTableModel) holidayReqTable.getModel();
        model.setRowCount(0);
        holidayReqTable.clearSelection();
        holidayReqTable.revalidate();
        holidayReqTable.repaint();
    }

    public void addHolidayReqRowTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) holidayReqTable.getModel();
        model.addRow(row);
    }
    
    public String getNameSelectedRequestHoliday() {
        return this.holidayReqTable.getSelectedRow() == 0 ? null 
                : this.holidayReqTable.getModel().getValueAt(this.holidayReqTable.getSelectedRow(), 0).toString();
    }

    public LocalDate getDateFrom() {
        return this.fromDateChooser.getDate() != null ? this.fromDateChooser.getDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate() : null;
    }

    public LocalDate getDateUntil() {
        return this.untilDateChooser.getDate() != null ? this.fromDateChooser.getDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate() : null;
    }

    public String getDeptComboSelectedItem() {
        return this.deptComboBox.getSelectedItem().toString();
    }

    public void setDeptComboItem(String dept) {
        this.deptComboBox.addItem(dept);
    }

    public String getEmpComboSelectedItem() {
        return this.empComboBox.getSelectedItem().toString();
    }

    public void setEmpComboItem(String emp) {
        this.empComboBox.addItem(emp);
    }

    public String getDeptUpdateComboSelectedItem() {
        return this.deptUpdateComboBox.getSelectedItem().toString();
    }

    public void setUpdateDeptComboItem(String dept) {
        this.deptUpdateComboBox.addItem(dept);
    }

    public String getEmpUpdateComboSelectedItem() {
        return this.empUpdateComboBox.getSelectedItem().toString();
    }

    public void setEmpUpdateComboItem(String emp) {
        this.empUpdateComboBox.addItem(emp);
    }

    public String getNewDeptComboSelectedItem() {
        return this.newDeptComboBox.getSelectedItem().toString();
    }

    public void setNewDeptComboItem(String dept) {
        this.newDeptComboBox.addItem(dept);
    }

    public String getDeptDeleteEmpComboSelectedItem() {
        return this.deptDeleteEmpComboBox.getSelectedItem().toString();
    }

    public void getDeptDeleteEmpComboItem(String dept) {
        this.deptDeleteEmpComboBox.addItem(dept);
    }

    public String getDeleteEmpComboSelectedItem() {
        return this.deleteEmpComboBox.getSelectedItem().toString();
    }
    
    public void setDeleteEmpComboItem(String emp) {
        this.deleteEmpComboBox.addItem(emp);
    }
    
    public String getDeptNewEmpComboSelectedItem() {
        return this.deptNewEmpComboBox.getSelectedItem().toString();
    }
    
    public void setDeptNewEmpComboItem(String dept) {
        this.deptNewEmpComboBox.addItem(dept);
    }
    
    public void setValidNewMailText(boolean valid) {
        if (valid) {
            this.newMailTextField.setForeground(Color.BLACK);
        } else {
            this.newMailTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getNewMailText() {
        return this.newMailTextField.getText();
    }
    
    public void setNewMailText(String mail) {
        this.newMailTextField.setText(mail);
    }
    
    public void setValidNewSalaryText(boolean valid) {
        if (valid) {
            this.newSalaryTextField.setForeground(Color.BLACK);
        } else {
            this.newSalaryTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getNewSalaryText() {
        return this.newSalaryTextField.getText();
    }
    
    public void setNewSalaryText(String salary) {
        this.newSalaryTextField.setText(salary);
    }
    
    public void setValidNewAddressText(boolean valid) {
        if (valid) {
            this.newAddressTextField.setForeground(Color.BLACK);
        } else {
            this.newAddressTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getNewAddressText() {
        return this.newAddressTextField.getText();
    }
    
    public void setNewAddressText(String address) {
        this.newAddressTextField.setText(address);
    }
    
    public void setValidNewPhoneText(boolean valid) {
        if (valid) {
            this.newPhoneTextField.setForeground(Color.BLACK);
        } else {
            this.newPhoneTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getNewPhoneText() {
        return this.newPhoneTextField.getText();
    }
    
    public void setNewPhoneText(String phone) {
        this.newPhoneTextField.setText(phone);
    }
    
    public void setValidNameText(boolean valid) {
        if (valid) {
            this.nameTextField.setForeground(Color.BLACK);
        } else {
            this.nameTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getNameText() {
        return this.nameTextField.getText();
    }
    
    public void setNameText(String name) {
        this.nameTextField.setText(name);
    }
    
    public void setValidLastname1Text(boolean valid) {
        if (valid) {
            this.lastname1TextField.setForeground(Color.BLACK);
        } else {
            this.lastname1TextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getLastname1Text() {
        return this.lastname1TextField.getText();
    }
    
    public void setLastname1Text(String lastname) {
        this.lastname1TextField.setText(lastname);
    }
    
    public void setValidLastname2Text(boolean valid) {
        if (valid) {
            this.lastName2TextField.setForeground(Color.BLACK);
        } else {
            this.lastName2TextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getLastname2Text() {
        return this.lastName2TextField.getText();
    }
    
    public void setLastname2Text(String lastname) {
        this.lastName2TextField.setText(lastname);
    }
    
    public void setMailText(boolean valid) {
        if (valid) {
            this.emailTextField.setForeground(Color.BLACK);
        } else {
            this.emailTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getMailText() {
        return this.emailTextField.getText();
    }
    
    public void setMailText(String mail) {
        this.emailTextField.setText(mail);
    }
    
    public void setPhoneText(boolean valid) {
        if (valid) {
            this.phoneTextField.setForeground(Color.BLACK);
        } else {
            this.phoneTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getPhoneText() {
        return this.phoneTextField.getText();
    }
    
    public void setPhoneText(String phone) {
        this.phoneTextField.setText(phone);
    }
    
    public void setSalaryText(boolean valid) {
        if (valid) {
            this.salaryTextField.setForeground(Color.BLACK);
        } else {
            this.salaryTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getSalaryText() {
        return this.salaryTextField.getText();
    }
    
    public void setSalaryText(String salary) {
        this.salaryTextField.setText(salary);
    }

    public void addMoreButtonListener(ActionListener listener) {
        this.moreButton.addActionListener(listener);
    }

    public void addRefreshButtonListener(ActionListener listener) {
        this.refreshButton.addActionListener(listener);
    }

    public void addUpdateButtonListener(ActionListener listener) {
        this.updateButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        this.deleteEmpButton.addActionListener(listener);
    }

    public void addAddButtonListener(ActionListener listener) {
        this.addEmpButton.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmpButton;
    private javax.swing.JLabel addEmpLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton deleteEmpButton;
    private javax.swing.JComboBox<String> deleteEmpComboBox;
    private javax.swing.JLabel deleteTitleLabel;
    private javax.swing.JComboBox<String> deptComboBox;
    private javax.swing.JComboBox<String> deptDeleteEmpComboBox;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JComboBox<String> deptNewEmpComboBox;
    private javax.swing.JComboBox<String> deptUpdateComboBox;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> empComboBox;
    private javax.swing.JLabel empLabel;
    private javax.swing.JScrollPane empScrollPane;
    private javax.swing.JTable empTable;
    private javax.swing.JComboBox<String> empUpdateComboBox;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel holidayReqLabel;
    private javax.swing.JScrollPane holidayReqScrollPane;
    private javax.swing.JTable holidayReqTable;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastName2TextField;
    private javax.swing.JTextField lastname1TextField;
    private javax.swing.JButton moreButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField newAddressTextField;
    private javax.swing.JComboBox<String> newDeptComboBox;
    private javax.swing.JTextField newMailTextField;
    private javax.swing.JTextField newPhoneTextField;
    private javax.swing.JTextField newSalaryTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator3;
    private javax.swing.JSeparator separator4;
    private javax.swing.JLabel titleLabel;
    private com.toedter.calendar.JDateChooser untilDateChooser;
    private javax.swing.JLabel untilLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
