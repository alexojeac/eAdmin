package views;

public class NavigationView extends javax.swing.JDialog {

    public NavigationView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        navPanel = new javax.swing.JPanel();
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
        topPanel = new javax.swing.JPanel();
        defaultLogoLabel = new javax.swing.JLabel();
        currentSectionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navPanel.setBackground(new java.awt.Color(0, 134, 190));
        navPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
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
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addContainerGap(28, Short.MAX_VALUE))
        );

        navPanel.add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, -1));

        cityLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/city.png"))); // NOI18N
        cityLabel.setText("navBackgroundLabel");
        navPanel.add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 320));

        cityLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/city.png"))); // NOI18N
        navPanel.add(cityLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 316, 200, 260));

        backgroundPanel.add(navPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 580));

        topPanel.setBackground(new java.awt.Color(0, 134, 190));

        defaultLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        currentSectionLabel.setBackground(new java.awt.Color(255, 255, 255));
        currentSectionLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        currentSectionLabel.setForeground(new java.awt.Color(204, 204, 204));
        currentSectionLabel.setText("Sección");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(currentSectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                .addComponent(defaultLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(currentSectionLabel))
                    .addComponent(defaultLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        backgroundPanel.add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1020, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminIconLabel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel adminTitleLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel cityLabel2;
    private javax.swing.JLabel currentSectionLabel;
    private javax.swing.JLabel defaultLogoLabel;
    private javax.swing.JPanel departmentPanel;
    private javax.swing.JLabel deptIconLabel;
    private javax.swing.JLabel deptTitleLabel;
    private clock.Clock digitalClock;
    private javax.swing.JLabel homeIconLabel;
    private javax.swing.JLabel homeTitleLabel;
    private javax.swing.JPanel hrPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JLabel rhIconLabel;
    private javax.swing.JLabel rhTitleLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
