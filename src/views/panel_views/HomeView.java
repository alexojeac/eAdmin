package views.panel_views;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class HomeView extends javax.swing.JPanel {

    public HomeView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listTitleLabel = new javax.swing.JLabel();
        onTimeScrollPane = new javax.swing.JScrollPane();
        onTimeTable = new javax.swing.JTable();
        notesScrollPane = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        noteTitleLabel = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        untilDateChooser = new com.toedter.calendar.JDateChooser();
        fromLabel = new javax.swing.JLabel();
        untilLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        saveNoteButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        requestVacationsLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        requestFromDateChooser = new com.toedter.calendar.JDateChooser();
        requestUntilDateChooser = new com.toedter.calendar.JDateChooser();
        requestFromLabel = new javax.swing.JLabel();
        requestUntilLabel = new javax.swing.JLabel();
        requestButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        signButton = new javax.swing.JButton();
        inOutComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        listTitleLabel.setText("Listado Entradas/Salidas");
        add(listTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        onTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fecha", "Hora entrada", "Hora salida", "Horas día"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        onTimeScrollPane.setViewportView(onTimeTable);

        add(onTimeScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 540, 240));

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        notesScrollPane.setViewportView(notesTextArea);

        add(notesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 220, 240));

        noteTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        noteTitleLabel.setText("Notas");
        add(noteTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, 40));
        add(fromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 110, 30));
        add(untilDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 120, 30));

        fromLabel.setText("Desde");
        add(fromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 30));

        untilLabel.setText("Hasta");
        add(untilLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 30));

        refreshButton.setBackground(new java.awt.Color(0, 134, 190));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh_icon.png"))); // NOI18N
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 40, 30));

        saveNoteButton.setBackground(new java.awt.Color(0, 134, 190));
        saveNoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_icon.png"))); // NOI18N
        add(saveNoteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 25, 51, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 306, 788, 10));

        requestVacationsLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        requestVacationsLabel.setText("Solicitar vacaciones");
        add(requestVacationsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 320, -1, 164));
        add(requestFromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 110, 30));
        add(requestUntilDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 110, 30));

        requestFromLabel.setText("Desde");
        add(requestFromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 30));

        requestUntilLabel.setText("Hasta");
        add(requestUntilLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 30));

        requestButton.setBackground(new java.awt.Color(0, 134, 190));
        requestButton.setForeground(new java.awt.Color(255, 255, 255));
        requestButton.setText("Solicitar");
        add(requestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 456, -1, 30));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 320, -1, 164));

        signButton.setBackground(new java.awt.Color(0, 134, 190));
        signButton.setForeground(new java.awt.Color(255, 255, 255));
        signButton.setText("Fichar entrada");
        add(signButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 120, 40));

        inOutComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Salida" }));
        add(inOutComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 160, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setText("Vacaciones");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Inicio", "Fin", "Aceptadas"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 320, 140));
    }// </editor-fold>//GEN-END:initComponents

    public void removeDataTable() {
        DefaultTableModel model = (DefaultTableModel) onTimeTable.getModel();
        model.setRowCount(0);
        onTimeTable.clearSelection();
        onTimeTable.revalidate();
        onTimeTable.repaint();
    }

    public void addRowTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) onTimeTable.getModel();
        model.addRow(row);
    }
    
    public LocalDate getDateFrom() {
        return this.fromDateChooser.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
    }
    
    public LocalDate getDateUntil() {
        return this.untilDateChooser.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
    }
    
    public String getNotes() {
        return notesTextArea.getText();
    }
    
    public void setNotes(String notes) {
        this.notesTextArea.setText(notes);
    }
    
    public void setSignButtonText(String text) {
        this.signButton.setText(text);
    }
    
    public String getStringInOutCombo() {
        return this.inOutComboBox.getSelectedItem().toString();
    }
    
    public void addRefreshButtonListener(ActionListener listener){
        this.refreshButton.addActionListener(listener);
    }
    
    public void addSaveNotesButtonListener(ActionListener listener) {
        this.saveNoteButton.addActionListener(listener);
    }
    
    public void addSignButtonListener(ActionListener listener) {
        this.signButton.addActionListener(listener);
    }
    
    public void addInOutComboListener(ActionListener listener) {
        this.inOutComboBox.addActionListener(listener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JComboBox<String> inOutComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel listTitleLabel;
    private javax.swing.JLabel noteTitleLabel;
    private javax.swing.JScrollPane notesScrollPane;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JScrollPane onTimeScrollPane;
    private javax.swing.JTable onTimeTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton requestButton;
    private com.toedter.calendar.JDateChooser requestFromDateChooser;
    private javax.swing.JLabel requestFromLabel;
    private com.toedter.calendar.JDateChooser requestUntilDateChooser;
    private javax.swing.JLabel requestUntilLabel;
    private javax.swing.JLabel requestVacationsLabel;
    private javax.swing.JButton saveNoteButton;
    private javax.swing.JButton signButton;
    private com.toedter.calendar.JDateChooser untilDateChooser;
    private javax.swing.JLabel untilLabel;
    // End of variables declaration//GEN-END:variables
}
