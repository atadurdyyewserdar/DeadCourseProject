package javaapplication5.Dialog;

import java.awt.Frame;
import javaapplication5.Classes.Employee;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeeEditDialog extends javax.swing.JDialog {

    public EmployeeEditDialog() {
        initComponents();
    }

    boolean isOk = false;

    public EmployeeEditDialog(Frame owFrame, boolean modal) {
        super(owFrame, modal);
        initComponents();
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(boolean isAccess) {
        if (isAccess) {
            buttonGroup1.setSelected(jRadioButton3.getModel(), true);
        } else {
            buttonGroup1.setSelected(jRadioButton2.getModel(), true);
        }
    }

    public JTextField getAddressInformationFirld() {
        return addressInformationFirld;
    }

    public void setAddressInformationFirld(JTextField addressInformationFirld) {
        this.addressInformationFirld.setText(addressInformationFirld.getText());
    }

    public JTextField getEmailInformationFirld5() {
        return emailInformationFirld5;
    }

    public void setEmailInformationFirld5(JTextField emailInformationFirld5) {
        this.emailInformationFirld5.setText(emailInformationFirld5.getText());
    }

    public JTextField getFioInformationFirld() {
        return fioInformationFirld;
    }

    public void setFioInformationFirld(JTextField fioInformationFirld) {
        this.fioInformationFirld.setText(fioInformationFirld.getText());
    }

    public JTextField getIdInformationFirld() {
        return idInformationFirld;
    }

    public void setIdInformationFirld(JTextField idInformationFirld) {
        this.idInformationFirld.setText(idInformationFirld.getText());
    }

    public JTextField getLoginInformationFirld5() {
        return loginInformationFirld5;
    }

    public void setLoginInformationFirld5(JTextField loginInformationFirld5) {
        this.loginInformationFirld5.setText(loginInformationFirld5.getText());
    }

    public JTextField getMobileInformationFirld() {
        return mobileInformationFirld;
    }

    public void setMobileInformationFirld(JTextField mobileInformationFirld) {
        this.mobileInformationFirld.setText(mobileInformationFirld.getText());
    }

    public JTextField getPasswordInformationFirld4() {
        return passwordInformationFirld4;
    }

    public void setPasswordInformationFirld4(JTextField passwordInformationFirld4) {
        this.passwordInformationFirld4.setText(passwordInformationFirld4.getText());
    }

    public JTextField getRoleInformationFirld6() {
        return roleInformationFirld6;
    }

    public void setRoleInformationFirld6(JTextField roleInformationFirld6) {
        this.roleInformationFirld6.setText(roleInformationFirld6.getText());
    }

    public Employee getEmployee() {
        if (e == null) {
            return new Employee();
        }
        return e;
    }

    public void setIsOk(boolean is) {
        isOk = is;
    }

    public boolean getIsOk() {
        return isOk;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        idInformationFirld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fioInformationFirld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addressInformationFirld = new javax.swing.JTextField();
        mobileInformationFirld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        loginInformationFirld5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passwordInformationFirld4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emailInformationFirld5 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        roleInformationFirld6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        idInformationFirld.setEditable(false);
        idInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel2.setText("ID");
        fioInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel3.setText("Ф�?О");
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel4.setText("Адрес");
        addressInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        mobileInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel5.setText("Мобильный номер");
        loginInformationFirld5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel6.setText("Логин");
        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel7.setText("Парол");
        passwordInformationFirld4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel13.setText("Почта");
        emailInformationFirld5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton7.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jButton7.setText("Сохранить данные");
        jButton7.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        roleInformationFirld6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel14.setText("Должность");
        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel15.setText("Доступ к аккаунту");
        jRadioButton2.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jRadioButton2.setText("Запрещён");
        buttonGroup1.add(jRadioButton2);
        jRadioButton3.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jRadioButton3.setText("Разрешён");
        buttonGroup1.add(jRadioButton3);
        jButton8.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jButton8.setText("Отменить");
        jButton8.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(jLabel13).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(emailInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(passwordInformationFirld4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(loginInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(mobileInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(addressInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(fioInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(127, 127, 127).addComponent(idInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel14).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(roleInformationFirld6, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(jLabel15).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jRadioButton3).addGap(18, 18, 18).addComponent(jRadioButton2))).addGroup(layout.createSequentialGroup().addComponent(jButton7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton8))).addGap(37, 37, 37)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(idInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fioInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(addressInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mobileInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(loginInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(passwordInformationFirld4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(emailInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel13)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(roleInformationFirld6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel14)).addGap(19, 19, 19).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel15).addComponent(jRadioButton2).addComponent(jRadioButton3)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(30, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(null);
    }

    private Employee e;

    public void setUser(Employee employee) {
        e = employee;
    }

    public void initEmployee() {
        if (e == null) {
            e = new Employee();
        }
        idInformationFirld.setText(Integer.toString(e.getEmployeeId()));
        fioInformationFirld.setText(e.getFio());
        addressInformationFirld.setText(e.getAddress());
        emailInformationFirld5.setText(e.getEmail());
        mobileInformationFirld.setText(e.getMobile());
        loginInformationFirld5.setText(e.getLogin());
        passwordInformationFirld4.setText(e.getPassword());
        roleInformationFirld6.setText(e.getRoleName());
        if (e.isAccess()) {
            buttonGroup1.setSelected(jRadioButton3.getModel(), true);
        } else {
            buttonGroup1.setSelected(jRadioButton2.getModel(), true);
        }
    }

    public boolean getAccess() {
        return jRadioButton3.isSelected();
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(addressInformationFirld, emailInformationFirld5, fioInformationFirld, loginInformationFirld5, passwordInformationFirld4, mobileInformationFirld, roleInformationFirld6)) {
            e.setAccess(jRadioButton3.isSelected());
            e.setAddress(addressInformationFirld.getText());
            e.setEmail(emailInformationFirld5.getText());
            e.setFio(fioInformationFirld.getText());
            e.setLogin(loginInformationFirld5.getText());
            e.setPassword(passwordInformationFirld4.getText());
            e.setMobile(mobileInformationFirld.getText());
            e.setRoleName(roleInformationFirld6.getText());
            isOk = true;
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Заполните все поля");
        }
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        isOk = false;
    }

    public boolean check(JTextField... jtfs) {
        for (JTextField jtf : jtfs) {
            if (jtf.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private javax.swing.JTextField addressInformationFirld;

    private javax.swing.ButtonGroup buttonGroup1;

    private javax.swing.JTextField emailInformationFirld5;

    private javax.swing.JTextField fioInformationFirld;

    private javax.swing.JTextField idInformationFirld;

    private javax.swing.JButton jButton7;

    private javax.swing.JButton jButton8;

    private javax.swing.JLabel jLabel13;

    private javax.swing.JLabel jLabel14;

    private javax.swing.JLabel jLabel15;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JRadioButton jRadioButton2;

    private javax.swing.JRadioButton jRadioButton3;

    private javax.swing.JTextField loginInformationFirld5;

    private javax.swing.JTextField mobileInformationFirld;

    private javax.swing.JTextField passwordInformationFirld4;

    private javax.swing.JTextField roleInformationFirld6;

}
