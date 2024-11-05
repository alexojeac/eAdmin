package views;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NavigationView extends javax.swing.JDialog {

    private int xMouse, yMouse;

    public NavigationView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        navPanel = new javax.swing.JPanel();
        exitPanel = new javax.swing.JPanel();
        exitIconLabel = new javax.swing.JLabel();
        exitTitleLabel = new javax.swing.JLabel();
        digitalClock = new clock.Clock();
        personalPanel = new javax.swing.JPanel();
        homeTitleLabel = new javax.swing.JLabel();
        homeIconLabel = new javax.swing.JLabel();
        departmentPanel = new javax.swing.JPanel();
        deptTitleLabel = new javax.swing.JLabel();
        deptIconLabel = new javax.swing.JLabel();
        hrPanel = new javax.swing.JPanel();
        rhIconLabel = new javax.swing.JLabel();
        rhTitleLabel = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        adminIconLabel = new javax.swing.JLabel();
        adminTitleLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        cityLabel2 = new javax.swing.JLabel();
        topBarPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        defaultLogoLabel = new javax.swing.JLabel();
        currentSectionLabel = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        closeLabel = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navPanel.setBackground(new java.awt.Color(0, 134, 190));
        navPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitPanel.setBackground(new java.awt.Color(0, 153, 204));
        exitPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        exitIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit_icon.png"))); // NOI18N

        exitTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exitTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        exitTitleLabel.setText("Salir");

        javax.swing.GroupLayout exitPanelLayout = new javax.swing.GroupLayout(exitPanel);
        exitPanel.setLayout(exitPanelLayout);
        exitPanelLayout.setHorizontalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(exitIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitTitleLabel)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        exitPanelLayout.setVerticalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitTitleLabel)
                    .addComponent(exitIconLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        navPanel.add(exitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, -1));
        navPanel.add(digitalClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        personalPanel.setBackground(new java.awt.Color(0, 134, 190));
        personalPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        homeTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        homeTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeTitleLabel.setText("Área personal");

        homeIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_icon.png"))); // NOI18N

        javax.swing.GroupLayout personalPanelLayout = new javax.swing.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(homeIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        personalPanelLayout.setVerticalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeTitleLabel)
                    .addComponent(homeIconLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        navPanel.add(personalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 70));

        departmentPanel.setBackground(new java.awt.Color(0, 134, 190));
        departmentPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        departmentPanel.setPreferredSize(new java.awt.Dimension(290, 70));

        deptTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deptTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        deptTitleLabel.setText("Departamentos");

        deptIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dept_icon.png"))); // NOI18N

        javax.swing.GroupLayout departmentPanelLayout = new javax.swing.GroupLayout(departmentPanel);
        departmentPanel.setLayout(departmentPanelLayout);
        departmentPanelLayout.setHorizontalGroup(
            departmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, departmentPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(deptIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deptTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        departmentPanelLayout.setVerticalGroup(
            departmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departmentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(departmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deptTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptIconLabel))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        navPanel.add(departmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, -1));

        hrPanel.setBackground(new java.awt.Color(0, 134, 190));
        hrPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hrPanel.setPreferredSize(new java.awt.Dimension(290, 70));

        rhIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rrhh_icon.png"))); // NOI18N

        rhTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rhTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        rhTitleLabel.setText("RRHH");

        javax.swing.GroupLayout hrPanelLayout = new javax.swing.GroupLayout(hrPanel);
        hrPanel.setLayout(hrPanelLayout);
        hrPanelLayout.setHorizontalGroup(
            hrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hrPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(rhIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rhTitleLabel)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        hrPanelLayout.setVerticalGroup(
            hrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hrPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(hrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rhTitleLabel)
                    .addComponent(rhIconLabel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        navPanel.add(hrPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, -1));

        adminPanel.setBackground(new java.awt.Color(0, 134, 190));
        adminPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminPanel.setPreferredSize(new java.awt.Dimension(290, 70));

        adminIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin_icon.png"))); // NOI18N

        adminTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adminTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminTitleLabel.setText("Admin");

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(adminIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminTitleLabel)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminTitleLabel)
                    .addComponent(adminIconLabel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        navPanel.add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 60));

        cityLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/city.png"))); // NOI18N
        cityLabel.setText("navBackgroundLabel");
        navPanel.add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 320));

        cityLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/city.png"))); // NOI18N
        navPanel.add(cityLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 316, 200, 260));

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

        javax.swing.GroupLayout topBarPanelLayout = new javax.swing.GroupLayout(topBarPanel);
        topBarPanel.setLayout(topBarPanelLayout);
        topBarPanelLayout.setHorizontalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        topBarPanelLayout.setVerticalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        navPanel.add(topBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        backgroundPanel.add(navPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 580));

        topPanel.setBackground(new java.awt.Color(0, 134, 190));

        defaultLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        currentSectionLabel.setBackground(new java.awt.Color(255, 255, 255));
        currentSectionLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        currentSectionLabel.setForeground(new java.awt.Color(204, 204, 204));
        currentSectionLabel.setText("Sección");

        closePanel.setBackground(new java.awt.Color(0, 134, 190));

        closeLabel.setBackground(new java.awt.Color(255, 255, 255));
        closeLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        closeLabel.setForeground(new java.awt.Color(255, 255, 255));
        closeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeLabel.setText("X");
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout closePanelLayout = new javax.swing.GroupLayout(closePanel);
        closePanel.setLayout(closePanelLayout);
        closePanelLayout.setHorizontalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        closePanelLayout.setVerticalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentSectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
                .addComponent(defaultLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defaultLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(currentSectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        backgroundPanel.add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 80));

        containerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        backgroundPanel.add(containerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 800, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
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
        return exitIconLabel;
    }
    
    public JPanel getClosePanel() {
        return closePanel;
    }

    public JLabel getCloseLabel() {
        return closeLabel;
    }
    
    public void setsectionLabelText(String section) {
        this.currentSectionLabel.setText(section);
    }

    public void setView(JPanel view) {
        view.setSize(590, 470);
        view.setLocation(0, 0);

        if (!(this.containerPanel.getLayout() instanceof BorderLayout)) {
            this.containerPanel.setLayout(new BorderLayout());
        }

        this.containerPanel.removeAll();
        this.containerPanel.add(view, BorderLayout.CENTER);
        this.containerPanel.revalidate();
        this.containerPanel.repaint();
    }

    public void setAccountLabelVisible(boolean visible) {
        this.homeTitleLabel.setVisible(visible);
    }
    
    public void setAccountIconLabelVisible(boolean visible) {
        this.homeIconLabel.setVisible(visible);
    }
    
    public void setPersonalPanelVisible(boolean visible) {
        this.personalPanel.setVisible(visible);
    }

    public void setRRHHLabelVisible(boolean visible) {
        this.rhTitleLabel.setVisible(visible);
    }
    
    public void setRRHHIconLabelVisible(boolean visible) {
        this.rhIconLabel.setVisible(visible);
    }
    
    public void setRRHHPanelVisible(boolean visible) {
        this.hrPanel.setVisible(visible);
    }

    public void setDepartmentLabelVisible(boolean visible) {
        this.deptTitleLabel.setVisible(visible);
    }
    
    public void setDepartmentIConLabelVisible(boolean visible) {
        this.deptIconLabel.setVisible(visible);
    }
    
    public void setDepartmentPanelVisible(boolean visible) {
        this.departmentPanel.setVisible(visible);
    }

    public void setAdminLabelVisible(boolean visible) {
        this.adminTitleLabel.setVisible(visible);
    }
    
    public void setAdminIconLabelVisible(boolean visible) {
        this.adminIconLabel.setVisible(visible);
    }
    
    public void setAdminPanelVisible(boolean visible) {
        this.adminPanel.setVisible(visible);
    }

    public void addTopBarPanelListener(MouseAdapter listener) {
        this.topPanel.addMouseListener(listener);
    }

    public void addExitLabelListener(MouseAdapter listener) {
        this.exitTitleLabel.addMouseListener(listener);
    }
    
    public void addExitPanelListener(MouseAdapter listener) {
        this.exitPanel.addMouseListener(listener);
    }
    
    public void addCloseLabelListener(MouseAdapter listener) {
        this.closeLabel.addMouseListener(listener);
    }

    public void addHomeLabelListener(MouseAdapter listener) {
        this.homeTitleLabel.addMouseListener(listener);
    }

    public void addRRHHLabelListener(MouseAdapter listener) {
        this.rhTitleLabel.addMouseListener(listener);
    }

    public void addDeptosLabelListener(MouseAdapter listener) {
        this.deptTitleLabel.addMouseListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminIconLabel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel adminTitleLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel cityLabel2;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel closePanel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel currentSectionLabel;
    private javax.swing.JLabel defaultLogoLabel;
    private javax.swing.JPanel departmentPanel;
    private javax.swing.JLabel deptIconLabel;
    private javax.swing.JLabel deptTitleLabel;
    private clock.Clock digitalClock;
    private javax.swing.JLabel exitIconLabel;
    private javax.swing.JPanel exitPanel;
    private javax.swing.JLabel exitTitleLabel;
    private javax.swing.JLabel homeIconLabel;
    private javax.swing.JLabel homeTitleLabel;
    private javax.swing.JPanel hrPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JLabel rhIconLabel;
    private javax.swing.JLabel rhTitleLabel;
    private javax.swing.JPanel topBarPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
