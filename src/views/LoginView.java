package views;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Ojea
 */
public class LoginView extends javax.swing.JFrame {
    
    private int xMouse, yMouse;
    
    public LoginView() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        bannerLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        userSeparator = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passSeparator = new javax.swing.JSeparator();
        passwordField = new javax.swing.JPasswordField();
        loginButtonPanel = new javax.swing.JPanel();
        loginButtonLabel = new javax.swing.JLabel();
        topBarPanel = new javax.swing.JPanel();
        exitPanel = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_new.png"))); // NOI18N
        background.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 290, -1));

        bannerLabel.setBackground(new java.awt.Color(255, 255, 255));
        bannerLabel.setForeground(new java.awt.Color(255, 255, 255));
        bannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/city.png"))); // NOI18N
        background.add(bannerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 290, 460));

        titleLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        titleLabel.setText("INICIAR SESIÓN");
        background.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 250, 80));

        userLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userLabel.setText("Usuario");
        background.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 30));

        userTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTextField.setForeground(new java.awt.Color(204, 204, 204));
        userTextField.setText("Ingrese su nombre");
        userTextField.setBorder(null);
        background.add(userTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 380, 40));

        userSeparator.setBackground(new java.awt.Color(0, 102, 204));
        userSeparator.setForeground(new java.awt.Color(0, 134, 190));
        background.add(userSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 400, 10));

        passLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        passLabel.setText("Contraseña");
        background.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, 30));

        passSeparator.setBackground(new java.awt.Color(0, 102, 204));
        passSeparator.setForeground(new java.awt.Color(0, 134, 190));
        background.add(passSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 400, 10));

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("jPasswordField1");
        passwordField.setBorder(null);
        background.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 400, 40));

        loginButtonPanel.setBackground(new java.awt.Color(0, 134, 190));

        loginButtonLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButtonLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginButtonLabel.setText("ENTRA");
        loginButtonLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout loginButtonPanelLayout = new javax.swing.GroupLayout(loginButtonPanel);
        loginButtonPanel.setLayout(loginButtonPanelLayout);
        loginButtonPanelLayout.setHorizontalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loginButtonPanelLayout.setVerticalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(loginButtonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 120, 50));

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
            .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exitPanelLayout.setVerticalGroup(
            exitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout topBarPanelLayout = new javax.swing.GroupLayout(topBarPanel);
        topBarPanel.setLayout(topBarPanelLayout);
        topBarPanelLayout.setHorizontalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarPanelLayout.createSequentialGroup()
                .addComponent(exitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(755, Short.MAX_VALUE))
        );
        topBarPanelLayout.setVerticalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarPanelLayout.createSequentialGroup()
                .addComponent(exitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431))
        );

        background.add(topBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topBarPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_topBarPanelMousePressed

    private void topBarPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_topBarPanelMouseDragged
    
    public JPanel getExitPanel() {
        return exitPanel;
    }
    
    public JLabel getExitLabel() {
        return exitLabel;
    }
    
    public String getUserText() {
        return userTextField.getText();
    }
    
    public void setUserText(String text) {
        this.userTextField.setText(text);
    }
    
    public void setValidUser(boolean valid) {
        if (valid) {
            this.userTextField.setForeground(Color.BLACK);
        } else {
            this.userTextField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public String getPassText() {
        return passwordField.getText();
    }
    
    public void setPassText(String text) {
        this.passwordField.setText(text);
    }
    
    public void setValidPass(boolean valid) {
        if (valid) {
            this.passwordField.setForeground(Color.BLACK);
        } else {
            this.passwordField.setForeground(new Color(204, 204, 204));
        }
    }
    
    public void addTopBarPanelListener(MouseAdapter listener) {
        this.topBarPanel.addMouseListener(listener);
    }
    
    public void addExitLabelListener(MouseAdapter listener) {
        this.exitLabel.addMouseListener(listener);
    }
    
    public void addLoginButtonLabelListener(MouseAdapter listener) {
        this.loginButtonLabel.addMouseListener(listener);
    }
    
    public void addUserTextFieldListener(FocusListener listener) {
        this.userTextField.addFocusListener(listener);
    }
    
    public void addPasswordTextFieldListener(FocusListener listener) {
        this.passwordField.addFocusListener(listener);
    }
    
    public void addPasswordTextFieldEnterListener (KeyAdapter listener) {
        this.passwordField.addKeyListener(listener);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel bannerLabel;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel exitPanel;
    private javax.swing.JLabel loginButtonLabel;
    private javax.swing.JPanel loginButtonPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JSeparator passSeparator;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topBarPanel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JSeparator userSeparator;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
