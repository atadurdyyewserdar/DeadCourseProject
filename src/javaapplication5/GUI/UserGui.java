package javaapplication5.GUI;

import java.io.IOException;
import java.net.Socket;
import javaapplication5.Classes.Employee;
import javaapplication5.Connection.ClientConnection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserGui extends javax.swing.JFrame {

    ClientConnection clientConnection;

    public UserGui() {
        initComponents();
    }

    public UserGui(ClientConnection clientConnection) {
        this.clientConnection = clientConnection;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        AuthorizationPanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        loginField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        showPasswordBox = new javax.swing.JCheckBox();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        newUserLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        newUserEmail = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        newUserPassword2 = new javax.swing.JPasswordField();
        newUserPassword = new javax.swing.JPasswordField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        loginField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        loginField.setPreferredSize(new java.awt.Dimension(7, 23));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/man-user.png")));
        jLabel1.setText("Логин");
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/lock.png")));
        jLabel2.setText("Пароль");
        loginButton.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        loginButton.setText("Войти");
        loginButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        showPasswordBox.setText("показать пароль");
        showPasswordBox.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordBoxActionPerformed(evt);
            }
        });
        jPasswordField1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jPasswordField1.setEchoChar('*');
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(70, Short.MAX_VALUE).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addComponent(jLabel2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(loginField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(jPanel2Layout.createSequentialGroup().addComponent(showPasswordBox).addGap(90, 90, 90)).addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(64, 64, 64)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(64, Short.MAX_VALUE).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel2)).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(5, 5, 5).addComponent(showPasswordBox).addGap(3, 3, 3).addComponent(loginButton).addGap(42, 42, 42)));
        AuthorizationPanel.addTab("Вход", null, jPanel2, "");
        newUserLogin.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setText("Логин");
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setText("Пароль");
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setText("Потвердите пароль");
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setText("E-mail");
        newUserEmail.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        registerButton.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        registerButton.setText("Зарегистрироваться");
        registerButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        newUserPassword2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        newUserPassword2.setEchoChar('*');
        newUserPassword.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        newUserPassword.setEchoChar('*');
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(registerButton).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel3).addComponent(jLabel6).addComponent(jLabel4).addComponent(jLabel5)).addGap(41, 41, 41).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(newUserPassword).addComponent(newUserPassword2).addComponent(newUserEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(newUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))).addContainerGap(31, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(36, 36, 36).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(newUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(newUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(newUserPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addGap(6, 6, 6).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(newUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(registerButton).addContainerGap(51, Short.MAX_VALUE)));
        AuthorizationPanel.addTab("Регистрация", jPanel3);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(171, Short.MAX_VALUE).addComponent(AuthorizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(163, 163, 163)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(AuthorizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(102, Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(null);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (loginField.getText().equals("") | jPasswordField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Введите данные!");
        } else {
            clientConnection.sendMessage("auth");
            String loginString = loginField.getText();
            String passString = new String(jPasswordField1.getPassword());
            clientConnection.sendMessage(loginString + "XxX" + passString);
            String line = clientConnection.readMessage();
            switch(line) {
                case "success":
                    Employee employee = (Employee) clientConnection.readObject();
                    System.out.println(employee);
                    UserMenu userMenu = new UserMenu(clientConnection, employee);
                    userMenu.setVisible(true);
                    this.setVisible(false);
                    break;
                case "denied":
                    JOptionPane.showMessageDialog(null, "Доступ запрещен");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Неправильный логин или пароль");
                    break;
            }
            loginField.setText("");
            jPasswordField1.setText("");
        }
    }

    public boolean check(JTextField... jtfs) {
        for (JTextField jtf : jtfs) {
            if (jtf.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String pas1 = new String(newUserPassword.getPassword());
        String pas2 = new String(newUserPassword2.getPassword());
        if ("".equals(newUserEmail.getText()) | "".equals(newUserLogin.getText()) | "".equals(pas1) | "".equals(pas2))
            JOptionPane.showMessageDialog(null, "Заполните все поля!");
        else if (!pas1.equals(pas2))
            JOptionPane.showMessageDialog(null, "Пароли не совпадают");
        else {
            clientConnection.sendMessage("reg");
            Employee employee = new Employee();
            employee.setLogin(newUserLogin.getText().trim());
            employee.setPassword(newUserPassword.getText().trim());
            employee.setRoleName("user");
            employee.setEmail(newUserEmail.getText().trim());
            clientConnection.sendObject(employee);
            if (clientConnection.readMessage().equals("exists")) {
                JOptionPane.showMessageDialog(null, "Пользователь с таким именем логином уже существует");
            } else {
                if (clientConnection.readMessage().equals("success")) {
                    JOptionPane.showMessageDialog(null, "Успешно!");
                    newUserEmail.setText("");
                    newUserLogin.setText("");
                    newUserPassword.setText("");
                    newUserPassword2.setText("");
                    AuthorizationPanel.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Ошибка...");
                }
            }
        }
    }

    private void showPasswordBoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (showPasswordBox.isSelected()) {
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        clientConnection.sendMessage("Exit");
        clientConnection.close();
        dispose();
    }

    public static void main(String[] args) {
        try {
            Socket connSocket = new Socket("localhost", 10998);
            ClientConnection clientConnection = new ClientConnection(connSocket);
            clientConnection.initConnection();
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(UserGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    UserGui userGui = new UserGui(clientConnection);
                    userGui.setVisible(true);
                }
            });
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private javax.swing.JTabbedPane AuthorizationPanel;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JPanel jPanel1;

    private javax.swing.JPanel jPanel2;

    private javax.swing.JPanel jPanel3;

    private javax.swing.JPasswordField jPasswordField1;

    private javax.swing.JButton loginButton;

    private javax.swing.JTextField loginField;

    private javax.swing.JTextField newUserEmail;

    private javax.swing.JTextField newUserLogin;

    private javax.swing.JPasswordField newUserPassword;

    private javax.swing.JPasswordField newUserPassword2;

    private javax.swing.JButton registerButton;

    private javax.swing.JCheckBox showPasswordBox;

}
