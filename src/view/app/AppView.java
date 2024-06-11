package view.app;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppView extends javax.swing.JDialog {

    private int xMouse, yMouse;

    public AppView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        navPanel = new javax.swing.JPanel();
        imageLogoLabel = new javax.swing.JLabel();
        adminLabel = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        rrhhLabel = new javax.swing.JLabel();
        departmentsLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        topBarPanel = new javax.swing.JPanel();
        exitPanel = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navPanel.setBackground(new java.awt.Color(0, 134, 190));
        navPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageLogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        navPanel.add(imageLogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 170));

        adminLabel.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        adminLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminLabel.setText("Administración");
        adminLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navPanel.add(adminLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 210, 40));

        userIdLabel.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        userIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        userIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userIdLabel.setText("id empleado");
        userIdLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        navPanel.add(userIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 40));

        rrhhLabel.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        rrhhLabel.setForeground(new java.awt.Color(255, 255, 255));
        rrhhLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rrhhLabel.setText("RRHH");
        rrhhLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navPanel.add(rrhhLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 40));

        departmentsLabel.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        departmentsLabel.setForeground(new java.awt.Color(255, 255, 255));
        departmentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        departmentsLabel.setText("Departamentos");
        departmentsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navPanel.add(departmentsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 40));

        accountLabel.setBackground(new java.awt.Color(0, 51, 255));
        accountLabel.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        accountLabel.setForeground(new java.awt.Color(255, 255, 255));
        accountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountLabel.setText("Área personal");
        accountLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navPanel.add(accountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, 40));

        backgroundPanel.add(navPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 500));

        topBarPanel.setBackground(new java.awt.Color(255, 255, 255));
        topBarPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topBarPanelMouseDragged(evt);
            }
        });
        topBarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topBarPanelMousePressed(evt);
            }
        });

        exitPanel.setBackground(new java.awt.Color(255, 255, 255));

        exitLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        exitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel.setText("X");
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout exitPanelLayout = new javax.swing.GroupLayout(exitPanel);
        exitPanel.setLayout(exitPanelLayout);
        exitPanelLayout.setHorizontalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitPanelLayout.setVerticalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout topBarPanelLayout = new javax.swing.GroupLayout(topBarPanel);
        topBarPanel.setLayout(topBarPanelLayout);
        topBarPanelLayout.setHorizontalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarPanelLayout.createSequentialGroup()
                .addContainerGap(765, Short.MAX_VALUE)
                .addComponent(exitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topBarPanelLayout.setVerticalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        backgroundPanel.add(topBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        backgroundPanel.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 590, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topBarPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_topBarPanelMouseDragged

    private void topBarPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_topBarPanelMousePressed

    public JPanel getExitPanel() {
        return exitPanel;
    }

    public JLabel getExitLabel() {
        return exitLabel;
    }

    public void setView(JPanel view) {
        view.setSize(590, 470);
        view.setLocation(0, 0);

        this.contentPanel.removeAll();
        this.contentPanel.add(view, BorderLayout.CENTER);
        this.contentPanel.revalidate();
        this.contentPanel.repaint();
    }
    
    public void setAccountLabelVisible(boolean visible) {
        this.accountLabel.setVisible(visible);
    }
    
    public void setRRHHLabelVisible(boolean visible) {
        this.rrhhLabel.setVisible(visible);
    }
    
    public void setDepartmentLabelVisible(boolean visible) {
        this.departmentsLabel.setVisible(visible);
    }
    
    public void setAdminLabelVisible(boolean visible) {
        this.adminLabel.setVisible(visible);
    }
    
    public void setUserIdLabel(String id) {
        this.userIdLabel.setText(id);
    }
    
    public void addTopBarPanelListener(MouseAdapter listener) {
        this.topBarPanel.addMouseListener(listener);
    }

    public void addExitLabelListener(MouseAdapter listener) {
        this.exitLabel.addMouseListener(listener);
    }

    public void addHomeLabelListener(MouseAdapter listener) {
        this.accountLabel.addMouseListener(listener);
    }

    public void addRRHHLabelListener(MouseAdapter listener) {
        this.rrhhLabel.addMouseListener(listener);
    }
    
    public void addDeptosLabelListener(MouseAdapter listener) {
        this.departmentsLabel.addMouseListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel departmentsLabel;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel exitPanel;
    private javax.swing.JLabel imageLogoLabel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JLabel rrhhLabel;
    private javax.swing.JPanel topBarPanel;
    private javax.swing.JLabel userIdLabel;
    // End of variables declaration//GEN-END:variables
}
