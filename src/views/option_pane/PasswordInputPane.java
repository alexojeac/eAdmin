package view.panelViews;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class PasswordInputPane extends javax.swing.JDialog {

    public PasswordInputPane(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        passLabel = new javax.swing.JLabel();
        passSeparator = new javax.swing.JSeparator();
        passwordField = new javax.swing.JPasswordField();
        repeatPassSeparator = new javax.swing.JSeparator();
        repeatPasswordField = new javax.swing.JPasswordField();
        repeatPassLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        flagPanel = new javax.swing.JPanel();
        passNewLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passLabel.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        passLabel.setText("Contraseña");
        backgroundPanel.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 30));

        passSeparator.setBackground(new java.awt.Color(0, 102, 204));
        passSeparator.setForeground(new java.awt.Color(0, 134, 190));
        backgroundPanel.add(passSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 400, 10));

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("jPasswordField1");
        passwordField.setBorder(null);
        backgroundPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 400, 40));

        repeatPassSeparator.setBackground(new java.awt.Color(0, 102, 204));
        repeatPassSeparator.setForeground(new java.awt.Color(0, 134, 190));
        backgroundPanel.add(repeatPassSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 400, 10));

        repeatPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        repeatPasswordField.setForeground(new java.awt.Color(204, 204, 204));
        repeatPasswordField.setText("jPasswordField1");
        repeatPasswordField.setBorder(null);
        backgroundPanel.add(repeatPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 400, 40));

        repeatPassLabel.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        repeatPassLabel.setText("Repite contraseña");
        backgroundPanel.add(repeatPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, 30));

        acceptButton.setBackground(new java.awt.Color(0, 134, 190));
        acceptButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(255, 255, 255));
        acceptButton.setText("Aceptar");
        backgroundPanel.add(acceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 110, 40));

        flagPanel.setBackground(new java.awt.Color(0, 134, 190));

        passNewLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        passNewLabel.setForeground(new java.awt.Color(255, 255, 255));
        passNewLabel.setText("Introduzca su nueva contraseña");

        javax.swing.GroupLayout flagPanelLayout = new javax.swing.GroupLayout(flagPanel);
        flagPanel.setLayout(flagPanelLayout);
        flagPanelLayout.setHorizontalGroup(
            flagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flagPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(passNewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        flagPanelLayout.setVerticalGroup(
            flagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passNewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        backgroundPanel.add(flagPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setValidPass(boolean valid) {
        if (valid) {
            this.passwordField.setForeground(Color.BLACK);
        } else {
            this.passwordField.setForeground(new Color(204, 204, 204));
        }
    }

    public void setValidRepeatPass(boolean valid) {
        if (valid) {
            this.repeatPasswordField.setForeground(Color.BLACK);
        } else {
            this.repeatPasswordField.setForeground(new Color(204, 204, 204));
        }
    }

    public String getPassText() {
        return passwordField.getText();
    }

    public void setPassText(String text) {
        this.passwordField.setText(text);
    }

    public String getRepeatPassText() {
        return repeatPasswordField.getText();
    }

    public void setRepeatPassText(String text) {
        this.repeatPasswordField.setText(text);
    }

    public void addAcceptButtonListener(ActionListener listener) {
        this.acceptButton.addActionListener(listener);
    }

    public void addPasswordTextFieldListener(FocusListener listener) {
        this.passwordField.addFocusListener(listener);
    }

    public void addRepeatPasswordTextFieldListener(FocusListener listener) {
        this.repeatPasswordField.addFocusListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel flagPanel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel passNewLabel;
    private javax.swing.JSeparator passSeparator;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel repeatPassLabel;
    private javax.swing.JSeparator repeatPassSeparator;
    private javax.swing.JPasswordField repeatPasswordField;
    // End of variables declaration//GEN-END:variables
}
