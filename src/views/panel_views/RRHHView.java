/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.panel_views;

/**
 *
 * @author alexo
 */
public class RRHHView extends javax.swing.JPanel {

    /**
     * Creates new form RRHHView
     */
    public RRHHView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        deleteEmpButton1 = new javax.swing.JButton();
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
        add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 760, 10));

        updateLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        updateLabel.setText("Modificar empleado:");
        add(updateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 30));

        add(deptUpdateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 140, 30));

        add(empUpdateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 140, 30));

        add(newDeptComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 180, 30));

        newMailTextField.setText("Nuevo email");
        add(newMailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 180, 30));

        addEmpButton.setBackground(new java.awt.Color(0, 134, 190));
        addEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        addEmpButton.setText("Añadir empleado");
        add(addEmpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 140, 30));
        add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 760, 10));

        addEmpLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        addEmpLabel.setText("Añadir empleado");
        add(addEmpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 30));

        nameTextField.setText("Nombre");
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 100, 30));

        lastname1TextField.setText("Apellido 1");
        add(lastname1TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 100, 30));

        add(deptNewEmpComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 140, 30));

        emailTextField.setText("email");
        add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 320, 30));

        deleteEmpButton1.setBackground(new java.awt.Color(255, 0, 0));
        deleteEmpButton1.setForeground(new java.awt.Color(255, 255, 255));
        deleteEmpButton1.setText("Eliminar empleado");
        add(deleteEmpButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 130, 30));

        separator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(separator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 10, 110));

        add(deptDeleteEmpComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 150, 30));

        add(deleteEmpComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 270, 30));

        deleteTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        deleteTitleLabel.setText("Eliminar empleado");
        add(deleteTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, 30));

        refreshButton.setBackground(new java.awt.Color(0, 134, 190));
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh_icon.png"))); // NOI18N
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 80, 30));

        lastName2TextField.setText("Apellido 2");
        add(lastName2TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 100, 30));

        phoneTextField.setText("tlf");
        add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 100, 30));

        addressTextField.setText("Dirección");
        add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 140, 30));

        salaryTextField.setText("Salario");
        add(salaryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 140, 30));

        newSalaryTextField.setText("Nuevo salario");
        add(newSalaryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 90, 30));

        updateButton.setBackground(new java.awt.Color(0, 134, 190));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Modificar");
        add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, 30));

        newAddressTextField.setText("Nueva dirección");
        add(newAddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 140, 30));

        newPhoneTextField.setText("Nuevo tlf");
        add(newPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 90, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmpButton;
    private javax.swing.JLabel addEmpLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton deleteEmpButton1;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastName2TextField;
    private javax.swing.JTextField lastname1TextField;
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
    private javax.swing.JLabel titleLabel;
    private com.toedter.calendar.JDateChooser untilDateChooser;
    private javax.swing.JLabel untilLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
