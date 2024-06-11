package view.panelViews;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RRHHView extends javax.swing.JPanel {

    public RRHHView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addEmployeeLabel = new javax.swing.JLabel();
        addEmployeeSeparator = new javax.swing.JSeparator();
        surname2TextField = new javax.swing.JTextField();
        mailTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        searchEmployeeLabel = new javax.swing.JLabel();
        searchEmployeeSeparator = new javax.swing.JSeparator();
        surnameSearchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        employeesScrollPane = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        departmentsComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addEmployeeLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        addEmployeeLabel.setText("Añadir empleado");
        add(addEmployeeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        addEmployeeSeparator.setBackground(new java.awt.Color(0, 134, 190));
        addEmployeeSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(addEmployeeSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 410, 10));

        surname2TextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        surname2TextField.setForeground(new java.awt.Color(204, 204, 204));
        surname2TextField.setText("Apellido2");
        add(surname2TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 110, 30));

        mailTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mailTextField.setForeground(new java.awt.Color(204, 204, 204));
        mailTextField.setText("email");
        add(mailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 30));

        nameTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nameTextField.setForeground(new java.awt.Color(204, 204, 204));
        nameTextField.setText("Nombre");
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        surnameTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        surnameTextField.setForeground(new java.awt.Color(204, 204, 204));
        surnameTextField.setText("Apellido1");
        add(surnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 110, 30));

        phoneTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        phoneTextField.setForeground(new java.awt.Color(204, 204, 204));
        phoneTextField.setText("Tlf.");
        add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 110, 30));

        AddButton.setBackground(new java.awt.Color(0, 134, 190));
        AddButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setText("Añadir");
        AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 110, 30));

        searchEmployeeLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        searchEmployeeLabel.setText("Buscar empleado");
        add(searchEmployeeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 30));

        searchEmployeeSeparator.setBackground(new java.awt.Color(0, 134, 190));
        searchEmployeeSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(searchEmployeeSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 410, 10));

        surnameSearchTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        surnameSearchTextField.setForeground(new java.awt.Color(204, 204, 204));
        surnameSearchTextField.setText("Apellido");
        add(surnameSearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, 30));

        searchButton.setBackground(new java.awt.Color(0, 134, 190));
        searchButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Buscar");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 30));

        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id empleado", "Nombre", "Apellido 1", "Apellido 2"
            }
        ));
        employeesScrollPane.setViewportView(employeesTable);

        add(employeesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 330, 130));

        deleteButton.setBackground(new java.awt.Color(0, 134, 190));
        deleteButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Eliminar");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 110, 30));

        departmentsComboBox.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(departmentsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    public void setValid(JTextField text, boolean valid) {
        if (valid) {
            text.setForeground(Color.BLACK);
        } else {
            text.setForeground(new Color(204, 204, 204));
        }
    }

    public void setNameText(String name) {
        this.nameTextField.setText(name);
    }

    public String getNameText() {
        return this.nameTextField.getText();
    }

    public JTextField getNameTextFieldComponent() {
        return this.nameTextField;
    }

    public void setSurnameText(String surname) {
        this.surnameTextField.setText(surname);
    }

    public String getSurnameText() {
        return this.surnameTextField.getText();
    }

    public JTextField getSurnameTextFieldComponent() {
        return this.surnameTextField;
    }

    public void setSurname2Text(String surname) {
        this.surname2TextField.setText(surname);
    }

    public String getSurname2Text() {
        return this.surname2TextField.getText();
    }

    public JTextField getSurname2TextFieldComponent() {
        return this.surname2TextField;
    }

    public void setPhoneText(String phone) {
        this.phoneTextField.setText(phone);
    }

    public String getPhoneText() {
        return this.phoneTextField.getText();
    }

    public JTextField getPhoneTextFieldComponent() {
        return this.phoneTextField;
    }

    public void setMailText(String mail) {
        this.mailTextField.setText(mail);
    }

    public String getMailText() {
        return this.mailTextField.getText();
    }

    public JTextField getMailTextFieldComponent() {
        return this.mailTextField;
    }

    public String getDepartment() {
        return String.valueOf(this.departmentsComboBox.getSelectedItem());
    }

    public void addDepartmentItem(String dept) {
        this.departmentsComboBox.addItem(dept);
    }

    public void setSurnameSearchText(String surname) {
        this.surnameSearchTextField.setText(surname);
    }

    public String getSurnameSearchText() {
        return this.surnameSearchTextField.getText();
    }

    public JTextField getSurnameSearchTextFieldComponent() {
        return this.surnameSearchTextField;
    }

    public void removeDataTable() {
        DefaultTableModel model = (DefaultTableModel) employeesTable.getModel();
        model.setRowCount(0);
        employeesTable.clearSelection();
        employeesTable.revalidate();
        employeesTable.repaint();
    }

    public void addRowTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) employeesTable.getModel();
        model.addRow(row);
    }

    public int getSelectedEmployeeId() {
        int id = -1;
        int row = this.employeesTable.getSelectedRow();
        int col = this.employeesTable.getSelectedColumn();

        if (col >= 0 && row >= 0) {
            id = (int) this.employeesTable.getModel().getValueAt(row, 0);
        }
        return id;
    }

    public void addNameTextFieldListener(FocusListener listener) {
        this.nameTextField.addFocusListener(listener);
    }

    public void addSurnameTextFieldListener(FocusListener listener) {
        this.surnameTextField.addFocusListener(listener);
    }

    public void addSurname2TextFieldListener(FocusListener listener) {
        this.surname2TextField.addFocusListener(listener);
    }

    public void addPhoneTextFieldListener(FocusListener listener) {
        this.phoneTextField.addFocusListener(listener);
    }

    public void addMailTextFieldListener(FocusListener listener) {
        this.mailTextField.addFocusListener(listener);
    }

    public void addSurnameSearchTextFieldListener(FocusListener listener) {
        this.surnameSearchTextField.addFocusListener(listener);
    }

    public void addAddButtonListener(ActionListener listener) {
        this.AddButton.addActionListener(listener);
    }

    public void addSearchButtonListener(ActionListener listener) {
        this.searchButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        this.deleteButton.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel addEmployeeLabel;
    private javax.swing.JSeparator addEmployeeSeparator;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> departmentsComboBox;
    private javax.swing.JScrollPane employeesScrollPane;
    private javax.swing.JTable employeesTable;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchEmployeeLabel;
    private javax.swing.JSeparator searchEmployeeSeparator;
    private javax.swing.JTextField surname2TextField;
    private javax.swing.JTextField surnameSearchTextField;
    private javax.swing.JTextField surnameTextField;
    // End of variables declaration//GEN-END:variables
}
