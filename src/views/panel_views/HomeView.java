package views.panel_views;

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
        signInButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        listTitleLabel.setText("Listado Entradas/Salidas");
        add(listTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, 30));

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

        add(onTimeScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 54, 622, 240));

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        notesScrollPane.setViewportView(notesTextArea);

        add(notesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 351, 300, 133));

        noteTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        noteTitleLabel.setText("Notas");
        add(noteTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 320, -1, 25));
        add(fromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 12, 110, 30));
        add(untilDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 12, 120, 30));

        fromLabel.setText("Desde");
        add(fromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 12, -1, 30));

        untilLabel.setText("Hasta");
        add(untilLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 12, -1, 30));

        refreshButton.setBackground(new java.awt.Color(0, 134, 190));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh_icon.png"))); // NOI18N
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 12, 52, 30));

        saveNoteButton.setBackground(new java.awt.Color(0, 134, 190));
        saveNoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_icon.png"))); // NOI18N
        add(saveNoteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 320, 51, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 306, 788, 10));

        requestVacationsLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        requestVacationsLabel.setText("Solicitar vacaciones");
        add(requestVacationsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 320, -1, 164));
        add(requestFromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 376, 110, 30));
        add(requestUntilDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 416, 112, 30));

        requestFromLabel.setText("Desde");
        add(requestFromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 376, -1, 22));

        requestUntilLabel.setText("Hasta");
        add(requestUntilLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 416, -1, 22));

        requestButton.setBackground(new java.awt.Color(0, 134, 190));
        requestButton.setForeground(new java.awt.Color(255, 255, 255));
        requestButton.setText("Solicitar");
        add(requestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 456, -1, 30));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 320, -1, 164));

        signInButton.setBackground(new java.awt.Color(0, 134, 190));
        signInButton.setForeground(new java.awt.Color(255, 255, 255));
        signInButton.setText("Fichar entrada");
        add(signInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 320, -1, 40));

        signOutButton.setBackground(new java.awt.Color(0, 134, 190));
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setText("Fichar salida");
        add(signOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 444, 105, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
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
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signOutButton;
    private com.toedter.calendar.JDateChooser untilDateChooser;
    private javax.swing.JLabel untilLabel;
    // End of variables declaration//GEN-END:variables
}
