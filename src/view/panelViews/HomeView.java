
package view.panelViews;

import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class HomeView extends javax.swing.JPanel {

    public HomeView() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameAccountLabel = new javax.swing.JLabel();
        departmentAccountLabel = new javax.swing.JLabel();
        onTimeButtonOut = new javax.swing.JButton();
        inputLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        onTimesScrollPane = new javax.swing.JScrollPane();
        onTimesTable = new javax.swing.JTable();
        dataSeparator = new javax.swing.JSeparator();
        onTimeButtonIn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(590, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameAccountLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        nameAccountLabel.setText("Nombre");
        add(nameAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 30));

        departmentAccountLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        departmentAccountLabel.setText("Departamento: ");
        add(departmentAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 320, 30));

        onTimeButtonOut.setBackground(new java.awt.Color(0, 134, 190));
        onTimeButtonOut.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        onTimeButtonOut.setForeground(new java.awt.Color(255, 255, 255));
        onTimeButtonOut.setText("Fichar");
        onTimeButtonOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(onTimeButtonOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 100, 30));

        inputLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        inputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputLabel.setText("Entrada:");
        add(inputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 60, 30));

        outputLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("Salida:");
        add(outputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 60, 30));

        onTimesTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        onTimesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Entrada", "Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        onTimesScrollPane.setViewportView(onTimesTable);

        add(onTimesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 490, 140));

        dataSeparator.setForeground(new java.awt.Color(0, 134, 190));
        add(dataSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 520, 10));

        onTimeButtonIn.setBackground(new java.awt.Color(0, 134, 190));
        onTimeButtonIn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        onTimeButtonIn.setForeground(new java.awt.Color(255, 255, 255));
        onTimeButtonIn.setText("Fichar");
        onTimeButtonIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(onTimeButtonIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    public void setUserName(String name) {
        this.nameAccountLabel.setText(name);
    }
    
    public void setDepartment(String dept) {
        this.departmentAccountLabel.setText(this.departmentAccountLabel.getText().concat(dept));
    }
    
    public void removeDataTable() {
        DefaultTableModel model = (DefaultTableModel) onTimesTable.getModel();
        model.setRowCount(0);
        onTimesTable.clearSelection();
        onTimesTable.revalidate();
        onTimesTable.repaint();
    }

    public void addRowTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) onTimesTable.getModel();
        model.addRow(row);
    }
    
    public void addOnTimeButtonInListenner(ActionListener listener) {
        this.onTimeButtonIn.addActionListener(listener);
    }
    
    public void addOnTimeButtonOutListenner(ActionListener listener) {
        this.onTimeButtonOut.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator dataSeparator;
    private javax.swing.JLabel departmentAccountLabel;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel nameAccountLabel;
    private javax.swing.JButton onTimeButtonIn;
    private javax.swing.JButton onTimeButtonOut;
    private javax.swing.JScrollPane onTimesScrollPane;
    private javax.swing.JTable onTimesTable;
    private javax.swing.JLabel outputLabel;
    // End of variables declaration//GEN-END:variables
}
