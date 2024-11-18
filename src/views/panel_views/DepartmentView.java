package views.panel_views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DepartmentView extends javax.swing.JPanel {

    public DepartmentView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empListLabel = new javax.swing.JLabel();
        empScrollPane = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        deptsComboBox = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();
        separator1 = new javax.swing.JSeparator();
        newDeptLabel = new javax.swing.JLabel();
        newDeptTextField = new javax.swing.JTextField();
        rightsComboBox = new javax.swing.JComboBox<>();
        addDeptButton = new javax.swing.JButton();
        separator2 = new javax.swing.JSeparator();
        updateDeptLabel = new javax.swing.JLabel();
        updateDeptComboBox = new javax.swing.JComboBox<>();
        updateNameTextField = new javax.swing.JTextField();
        updateRightComboBox = new javax.swing.JComboBox<>();
        updateDeptButton = new javax.swing.JButton();
        deleteDeptLabel = new javax.swing.JLabel();
        deleteDeptComboBox = new javax.swing.JComboBox<>();
        deleteDeptButton = new javax.swing.JButton();
        separator4 = new javax.swing.JSeparator();
        newRightsLabel = new javax.swing.JLabel();
        updateRightsLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empListLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        empListLabel.setText("Listado empleados");
        add(empListLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 17, -1, -1));

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Fecha contrato", "Dirección", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empScrollPane.setViewportView(empTable);

        add(empScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 80, 780, 229));

        deptsComboBox.setToolTipText("Lista de departamentos");
        add(deptsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 214, 28));

        refreshButton.setBackground(new java.awt.Color(0, 134, 190));
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh_icon.png"))); // NOI18N
        refreshButton.setToolTipText("Cargar datos en la tabla");
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 50, 28));
        add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 324, 920, 10));

        newDeptLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        newDeptLabel.setText("Nuevo departamento");
        add(newDeptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        newDeptTextField.setForeground(new java.awt.Color(204, 204, 204));
        newDeptTextField.setText("Nombre");
        add(newDeptTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 175, 30));

        rightsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Recursos Humanos", "Administrador" }));
        rightsComboBox.setToolTipText("Permisos para los empleados del departamento");
        add(rightsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 140, 30));

        addDeptButton.setBackground(new java.awt.Color(0, 134, 190));
        addDeptButton.setForeground(new java.awt.Color(255, 255, 255));
        addDeptButton.setText("Añadir departamento");
        add(addDeptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 180, 31));

        separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, 145));

        updateDeptLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        updateDeptLabel.setText("Modificar departamento");
        add(updateDeptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 159, -1));

        updateDeptComboBox.setToolTipText("Lista de departamentos");
        add(updateDeptComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 175, 30));

        updateNameTextField.setForeground(new java.awt.Color(204, 204, 204));
        updateNameTextField.setText("Nuevo nombre");
        add(updateNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 170, 30));

        updateRightComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Recursos Humanos", "Administrador" }));
        updateRightComboBox.setToolTipText("Permisos para el empleado del departamento");
        add(updateRightComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 175, 30));

        updateDeptButton.setBackground(new java.awt.Color(0, 134, 190));
        updateDeptButton.setForeground(new java.awt.Color(255, 255, 255));
        updateDeptButton.setText("Modificar departamento");
        add(updateDeptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, -1, 31));

        deleteDeptLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        deleteDeptLabel.setText("Eliminar departamento");
        add(deleteDeptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, -1, -1));

        deleteDeptComboBox.setToolTipText("Lista de departamentos");
        add(deleteDeptComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 175, 30));

        deleteDeptButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteDeptButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteDeptButton.setText("Eliminar departamento");
        add(deleteDeptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, 175, 31));

        separator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(separator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 10, 150));

        newRightsLabel.setText("Permisos de usuario: ");
        add(newRightsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, 30));

        updateRightsLabel.setText("Permisos de usuario: ");
        add(updateRightsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 30));
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
    
    public void setValidNewDept(boolean valid) {
        if (valid) {
            this.newDeptTextField.setForeground(Color.BLACK);
        } else {
            this.newDeptTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public void setValidUpdateDept(boolean valid) {
        if (valid) {
            this.updateNameTextField.setForeground(Color.BLACK);
        } else {
            this.updateNameTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getNewDeptText() {
        return this.newDeptTextField.getText();
    }
    
    public void setNewDeptText(String dept) {
        this.newDeptTextField.setText(dept);
    }
    
    public String getUpdateNametext() {
        return this.updateNameTextField.getText();
    }
    
    public void setUpdateNameText(String dept) {
        this.updateNameTextField.setText(dept);
    }
    
    public String getNewRightsCombo() {
        return this.rightsComboBox.getSelectedItem().toString();
    }
    
    public void setNewRightCombo(String right) {
        this.rightsComboBox.addItem(right);
    }
    
    public String getSelectedDept() {
        return this.deptsComboBox.getSelectedItem().toString();
    }
    
    public void setDeptsCombo(String dept) {
        this.deptsComboBox.addItem(dept);
    }
    
    public void removeAllItemsDeptCombo() {
        this.deptsComboBox.removeAllItems();
    }
    
    public String getUpdateDeptCombo() {
        return this.updateDeptComboBox.getSelectedItem().toString();
    }
    
    public void setUpdateDeptCombo(String dept) {
        this.updateDeptComboBox.addItem(dept);
    }
    
    public void removeAllItemsUpdateDeptCombo() {
        this.updateDeptComboBox.removeAllItems();
    }
    
    public String getUpdateRightCombo() {
        return this.updateDeptComboBox.getSelectedItem().toString();
    }
    
    public void setUpdateRightCombo(String right) {
        this.updateRightComboBox.addItem(right);
    }
    
    public String getDeleteDeptCombo() {
        return this.deleteDeptComboBox.getSelectedItem().toString();
    }
    
    public void setDeleteDeptCombo(String dept) {
        this.deleteDeptComboBox.addItem(dept);
    }
    
    public void removeAllItemsDeleteDeptCombo() {
        this.deleteDeptComboBox.removeAllItems();
    }
    
    public void addRefreshButtonListener(ActionListener listener){
        this.refreshButton.addActionListener(listener);
    }
    
    public void addAddDeptButtonListener(ActionListener listener) {
        this.addDeptButton.addActionListener(listener);
    }
    
    public void addUpdateDeptButtonListener(ActionListener listener) {
        this.updateDeptButton.addActionListener(listener);
    }
    
    public void addDeleteDeptButtonListener(ActionListener listener) {
        this.deleteDeptButton.addActionListener(listener);
    }
    
    public void addNewDeptTextFieldListener(FocusListener listener) {
        this.newDeptTextField.addFocusListener(listener);
    }
    
    public void addUpdateNameTextField(FocusListener listener) {
        this.updateNameTextField.addFocusListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeptButton;
    private javax.swing.JButton deleteDeptButton;
    private javax.swing.JComboBox<String> deleteDeptComboBox;
    private javax.swing.JLabel deleteDeptLabel;
    private javax.swing.JComboBox<String> deptsComboBox;
    private javax.swing.JLabel empListLabel;
    private javax.swing.JScrollPane empScrollPane;
    private javax.swing.JTable empTable;
    private javax.swing.JLabel newDeptLabel;
    private javax.swing.JTextField newDeptTextField;
    private javax.swing.JLabel newRightsLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JComboBox<String> rightsComboBox;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator4;
    private javax.swing.JButton updateDeptButton;
    private javax.swing.JComboBox<String> updateDeptComboBox;
    private javax.swing.JLabel updateDeptLabel;
    private javax.swing.JTextField updateNameTextField;
    private javax.swing.JComboBox<String> updateRightComboBox;
    private javax.swing.JLabel updateRightsLabel;
    // End of variables declaration//GEN-END:variables
}
