
package view.panelViews;

import java.awt.event.ActionListener;
import java.util.Date;

public class HomeView extends javax.swing.JPanel {

    public HomeView() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameAccountLabel = new javax.swing.JLabel();
        lastName1AccountLabel = new javax.swing.JLabel();
        lastName2AccountLabel = new javax.swing.JLabel();
        departmentAccountLabel = new javax.swing.JLabel();
        onTimeButton = new javax.swing.JButton();
        inputDateChooser = new com.toedter.calendar.JDateChooser();
        inputLabel = new javax.swing.JLabel();
        outputDateChooser = new com.toedter.calendar.JDateChooser();
        outputLabel = new javax.swing.JLabel();
        onTimesScrollPane = new javax.swing.JScrollPane();
        onTimesTable = new javax.swing.JTable();
        dataSeparator = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(590, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameAccountLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        nameAccountLabel.setText("Nombre");
        add(nameAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        lastName1AccountLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lastName1AccountLabel.setText("Apellido1");
        add(lastName1AccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));

        lastName2AccountLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lastName2AccountLabel.setText("Apellido2");
        add(lastName2AccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        departmentAccountLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        departmentAccountLabel.setText("Departamento: ");
        add(departmentAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 130, 30));

        onTimeButton.setBackground(new java.awt.Color(0, 134, 190));
        onTimeButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        onTimeButton.setForeground(new java.awt.Color(255, 255, 255));
        onTimeButton.setText("Fichar");
        onTimeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(onTimeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 100, 30));

        inputDateChooser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(inputDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 110, 30));

        inputLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputLabel.setText("Entrada:");
        add(inputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 30));

        outputDateChooser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(outputDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 110, 30));

        outputLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("Salida:");
        add(outputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 60, 30));

        onTimesTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        onTimesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Entrada", "Salida", "Horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        onTimesScrollPane.setViewportView(onTimesTable);

        add(onTimesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 490, 230));

        dataSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(dataSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 520, 10));
    }// </editor-fold>//GEN-END:initComponents

    public void setUserName(String name) {
        this.nameAccountLabel.setText(name);
    }
    
    public void setUserLastName1(String name) {
        this.lastName1AccountLabel.setText(name);
    }
    
    public void setUserLastName2(String name) {
        this.lastName2AccountLabel.setText(name);
    }
    
    public void setDepartment(String dept) {
        this.departmentAccountLabel.setText(this.departmentAccountLabel.getText().concat(dept));
    }
    
    public Date getInputDate() {
        return this.inputDateChooser.getDate();
    }
    
    public Date getOutputDate() {
        return this.outputDateChooser.getDate();
    }
    
    public void addOnTimeButtonListenner(ActionListener listener) {
        this.onTimeButton.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator dataSeparator;
    private javax.swing.JLabel departmentAccountLabel;
    private com.toedter.calendar.JDateChooser inputDateChooser;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel lastName1AccountLabel;
    private javax.swing.JLabel lastName2AccountLabel;
    private javax.swing.JLabel nameAccountLabel;
    private javax.swing.JButton onTimeButton;
    private javax.swing.JScrollPane onTimesScrollPane;
    private javax.swing.JTable onTimesTable;
    private com.toedter.calendar.JDateChooser outputDateChooser;
    private javax.swing.JLabel outputLabel;
    // End of variables declaration//GEN-END:variables
}
