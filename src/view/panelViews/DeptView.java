package view.panelViews;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class DeptView extends javax.swing.JPanel {

    public DeptView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addDeptLabel = new javax.swing.JLabel();
        addDeptSeparator = new javax.swing.JSeparator();
        nameTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        searchDeptLabel = new javax.swing.JLabel();
        searchDeptSeparator = new javax.swing.JSeparator();
        searchNameTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        deptScrollPane = new javax.swing.JScrollPane();
        deptTable = new javax.swing.JTable();
        searchEmployeeLabel = new javax.swing.JLabel();
        searchEmployeeSeparator = new javax.swing.JSeparator();
        idTextField = new javax.swing.JTextField();
        addToDeptButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(590, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addDeptLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        addDeptLabel.setText("Añadir departamento");
        add(addDeptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 30));

        addDeptSeparator.setBackground(new java.awt.Color(0, 134, 190));
        addDeptSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(addDeptSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 410, 10));

        nameTextField.setForeground(new java.awt.Color(204, 204, 204));
        nameTextField.setText("Nombre depto");
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        phoneTextField.setForeground(new java.awt.Color(204, 204, 204));
        phoneTextField.setText("Tlf.");
        add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 110, 30));

        AddButton.setBackground(new java.awt.Color(0, 134, 190));
        AddButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setText("Añadir");
        AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 110, 30));

        searchDeptLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        searchDeptLabel.setText("Buscar departamento");
        add(searchDeptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 30));

        searchDeptSeparator.setBackground(new java.awt.Color(0, 134, 190));
        searchDeptSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(searchDeptSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 410, 10));

        searchNameTextField.setForeground(new java.awt.Color(204, 204, 204));
        searchNameTextField.setText("Nombre depto");
        add(searchNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        searchButton.setBackground(new java.awt.Color(0, 134, 190));
        searchButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Buscar");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, 30));

        deptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id depto", "Nombre", "tlf"
            }
        ));
        deptScrollPane.setViewportView(deptTable);

        add(deptScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 330, 130));

        searchEmployeeLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        searchEmployeeLabel.setText("Buscar empleado");
        add(searchEmployeeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 150, 30));

        searchEmployeeSeparator.setBackground(new java.awt.Color(0, 134, 190));
        searchEmployeeSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(searchEmployeeSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 410, 10));

        idTextField.setForeground(new java.awt.Color(204, 204, 204));
        idTextField.setText("id empleado");
        add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, 30));

        addToDeptButton.setBackground(new java.awt.Color(0, 134, 190));
        addToDeptButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        addToDeptButton.setForeground(new java.awt.Color(255, 255, 255));
        addToDeptButton.setText("Añadir a departamento");
        addToDeptButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(addToDeptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 160, 30));
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
    
    public void setPhoneText(String phone) {
        this.phoneTextField.setText(phone);
    }
    
    public String getPhoneText() {
        return this.phoneTextField.getText();
    }
    
    public JTextField getPhoneTextFieldComponent() {
        return this.phoneTextField;
    }
    
    public void setSearchNameText(String phone) {
        this.searchNameTextField.setText(phone);
    }
    
    public String getSearchNameText() {
        return this.searchNameTextField.getText();
    }
    
    public JTextField getSearchNameTextFieldComponent() {
        return this.searchNameTextField;
    }
    
    public void setIdText(String phone) {
        this.idTextField.setText(phone);
    }
    
    public String getIdText() {
        return this.idTextField.getText();
    }
    
    public JTextField getIdTextFieldComponent() {
        return this.idTextField;
    }
    
    public void addNameTextFieldListener(FocusListener listener) {
        this.nameTextField.addFocusListener(listener);
    }
    
    public void addPhoneTextFieldListener(FocusListener listener) {
        this.phoneTextField.addFocusListener(listener);
    }
    
    public void addNameSearchTextFieldListener(FocusListener listener) {
        this.searchNameTextField.addFocusListener(listener);
    }
    
    public void addIdTextFieldListener(FocusListener listener) {
        this.idTextField.addFocusListener(listener);
    }
    
    public void addAddButtonListener(ActionListener listener) {
        this.AddButton.addActionListener(listener);
    }
    
    public void addSearchButtonListener(ActionListener listener) {
        this.searchButton.addActionListener(listener);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel addDeptLabel;
    private javax.swing.JSeparator addDeptSeparator;
    private javax.swing.JButton addToDeptButton;
    private javax.swing.JScrollPane deptScrollPane;
    private javax.swing.JTable deptTable;
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchDeptLabel;
    private javax.swing.JSeparator searchDeptSeparator;
    private javax.swing.JLabel searchEmployeeLabel;
    private javax.swing.JSeparator searchEmployeeSeparator;
    private javax.swing.JTextField searchNameTextField;
    // End of variables declaration//GEN-END:variables
}
