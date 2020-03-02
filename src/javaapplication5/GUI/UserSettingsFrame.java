package javaapplication5.GUI;

import java.util.Arrays;
import javaapplication5.Classes.Convertor;
import javaapplication5.Classes.Employee;
import javaapplication5.Connection.ClientConnection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserSettingsFrame extends javax.swing.JFrame {

    ClientConnection clientConnection;

    Employee employee;

    public UserSettingsFrame(ClientConnection connection, Employee emp) {
        clientConnection = connection;
        employee = emp;
        initComponents();
        initT();
    }

    public void initT() {
        idInformationFirld.setText(Integer.toString(employee.getEmployeeId()));
        fioInformationFirld.setText(employee.getFio());
        addressInformationFirld.setText(employee.getAddress());
        mobileInformationFirld.setText(employee.getMobile());
        loginInformationFirld5.setText(employee.getLogin());
        passwordInformationFirld4.setText(employee.getPassword());
        emailInformationFirld5.setText(employee.getEmail());
    }

    public UserSettingsFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idInformationFirld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mobileInformationFirld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fioInformationFirld = new javax.swing.JTextField();
        emailInformationFirld5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addressInformationFirld = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        loginInformationFirld5 = new javax.swing.JTextField();
        passwordInformationFirld4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/id.png")));
        jLabel2.setText("   ID");
        idInformationFirld.setEditable(false);
        idInformationFirld.setBackground(new java.awt.Color(255, 255, 255));
        idInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        idInformationFirld.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/smartphone.png")));
        jLabel5.setText("Мобильный");
        mobileInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        mobileInformationFirld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/fio.png")));
        jLabel3.setText("Ф�?О");
        fioInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        fioInformationFirld.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        emailInformationFirld5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        emailInformationFirld5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jLabel13.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/mail.png")));
        jLabel13.setText("Почта");
        jLabel4.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/map.png")));
        jLabel4.setText("Адрес");
        addressInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        addressInformationFirld.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jLabel6.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/user.png")));
        jLabel6.setText("    Логин");
        jLabel7.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14));
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/fingerprint.png")));
        jLabel7.setText("    Парол");
        loginInformationFirld5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        loginInformationFirld5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        passwordInformationFirld4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        passwordInformationFirld4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jButton7.setBackground(new java.awt.Color(51, 153, 255));
        jButton7.setFont(new java.awt.Font("Malgun Gothic", 1, 14));
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("Сохранить");
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 153)));
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(60, 60, 60).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2).addGap(36, 36, 36).addComponent(idInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(80, 80, 80).addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30).addComponent(mobileInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3).addGap(30, 30, 30).addComponent(fioInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(80, 80, 80).addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30).addComponent(loginInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel13).addGap(22, 22, 22).addComponent(emailInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(80, 80, 80).addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40).addComponent(passwordInformationFirld4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel4).addGap(23, 23, 23).addComponent(addressInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(170, 170, 170).addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(73, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(50, 50, 50).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(idInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5).addComponent(mobileInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(55, 55, 55).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3).addComponent(fioInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6).addComponent(loginInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(45, 45, 45).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel7).addComponent(passwordInformationFirld4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel13).addComponent(emailInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))).addGap(55, 55, 55).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4).addComponent(addressInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(67, Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);
    }

    public boolean check(JTextField... jTextFields) {
        for (JTextField jTextField : jTextFields) {
            if (jTextField.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(addressInformationFirld, fioInformationFirld, emailInformationFirld5, mobileInformationFirld, loginInformationFirld5, passwordInformationFirld4)) {
            if (Convertor.isLong(mobileInformationFirld.getText())) {
                clientConnection.sendMessage("check user login");
                clientConnection.sendMessage(loginInformationFirld5.getText().trim());
                String answer = clientConnection.readMessage();
                if (employee.getLogin().equals(loginInformationFirld5.getText().trim()) || answer.equals("valid")) {
                    clientConnection.sendMessage("update user information");
                    employee.setAddress(addressInformationFirld.getText().trim());
                    employee.setEmail(emailInformationFirld5.getText().trim());
                    employee.setFio(fioInformationFirld.getText().trim());
                    employee.setLogin(loginInformationFirld5.getText().trim());
                    employee.setPassword(passwordInformationFirld4.getText().trim());
                    employee.setMobile(mobileInformationFirld.getText().trim());
                    clientConnection.sendObject(employee);
                    String line = clientConnection.readMessage();
                    if (line.equals("success")) {
                        JOptionPane.showMessageDialog(null, "Успешно!");
                    } else {
                        JOptionPane.showMessageDialog(null, line);
                    }
                    initT();
                } else {
                    JOptionPane.showMessageDialog(null, "Пользователь с таким именем логином уже существует");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Некоторые поля должны содержат числовые значения");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполните пустые поля");
        }
    }

    private javax.swing.JTextField addressInformationFirld;

    private javax.swing.JTextField emailInformationFirld5;

    private javax.swing.JTextField fioInformationFirld;

    private javax.swing.JTextField idInformationFirld;

    private javax.swing.JButton jButton7;

    private javax.swing.JLabel jLabel13;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JPanel jPanel1;

    private javax.swing.JTextField loginInformationFirld5;

    private javax.swing.JTextField mobileInformationFirld;

    private javax.swing.JTextField passwordInformationFirld4;

}
