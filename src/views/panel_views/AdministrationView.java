package views.panel_views;

import java.awt.event.ActionListener;

/**
 *
 * @author Alejandro Ojea
 */
public class AdministrationView extends javax.swing.JPanel {

    public AdministrationView() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        mailLabel = new javax.swing.JLabel();
        mailTextField = new javax.swing.JTextField();
        empNumberTitleLabel = new javax.swing.JLabel();
        empNumberLabel = new javax.swing.JLabel();
        deptNumberTitleLabel = new javax.swing.JLabel();
        deptNumberLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        nameLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nameLabel.setText("Nombre de la empresa:");

        addressLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        addressLabel.setText("Dirección:");

        idLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        idLabel.setText("NIF:");

        mailLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        mailLabel.setText("Correo:");

        empNumberTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        empNumberTitleLabel.setText("Número de empleados:");

        empNumberLabel.setText("0");

        deptNumberTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        deptNumberTitleLabel.setText("Número de departamentos:");

        deptNumberLabel.setText("0");

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_new.png"))); // NOI18N

        saveButton.setBackground(new java.awt.Color(0, 134, 190));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deptNumberTitleLabel)
                                .addGap(18, 18, 18)
                                .addComponent(deptNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(empNumberTitleLabel)
                                .addGap(18, 18, 18)
                                .addComponent(empNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoLabel)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(empNumberTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(empNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptNumberTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(logoLabel)
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getNameText() {
        return this.nameTextField.getText();
    }
    
    public void setNameText(String name) {
        this.nameTextField.setText(name);
    }
    
    public String getAddressText() {
        return this.addressTextField.getText();
    }
    
    public void setAddressText(String address) {
        this.addressTextField.setText(address);
    }
    
    public String getIdText() {
        return this.idTextField.getText();
    }
    
    public void setIdText(String id) {
        this.idTextField.setText(id);
    }
    
    public String getMailText() {
        return this.mailTextField.getText();
    }
    
    public void setMailText(String mail) {
        this.mailTextField.setText(mail);
    }
    
    public void setEmpNumber(String number) {
        this.empNumberLabel.setText(number);
    }
    
    public void setDeptNumber(String number) {
        this.deptNumberLabel.setText(number);
    }
    
    public void addSaveButtonListener(ActionListener listener) {
        this.saveButton.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel deptNumberLabel;
    private javax.swing.JLabel deptNumberTitleLabel;
    private javax.swing.JLabel empNumberLabel;
    private javax.swing.JLabel empNumberTitleLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
