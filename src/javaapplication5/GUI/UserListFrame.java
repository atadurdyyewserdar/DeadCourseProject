package javaapplication5.GUI;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication5.Classes.Employee;
import javaapplication5.Connection.ClientConnection;
import javaapplication5.Dialog.EmployeeEditDialog;
import javaapplication5.Models.TableColumnAdjuster;
import javaapplication5.Models.UsersInformationModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class UserListFrame extends javax.swing.JFrame {

    ClientConnection clientConnection;

    Employee employee;

    UsersInformationModel usersInformationModel;

    TableColumnAdjuster tableColumnAdjuster;

    int typeOfUser;

    EmployeeEditDialog eed;

    public UserListFrame(ClientConnection clientConnection, Employee employee, int typeOfUser) {
        this.clientConnection = clientConnection;
        this.employee = employee;
        this.typeOfUser = typeOfUser;
        eed = new EmployeeEditDialog(this, true);
        initComponents();
        if (typeOfUser == 1) {
            jLabel1.setEnabled(true);
            jLabel4.setEnabled(true);
            jLabel2.setEnabled(true);
        } else {
            jLabel1.setEnabled(false);
            jLabel4.setEnabled(false);
            jLabel2.setEnabled(false);
        }
    }

    public UserListFrame() {
        initComponents();
    }

    ArrayList<Employee> getEmployees() {
        System.out.println("UserMenu getEmployyes ");
        ArrayList<Employee> employees = new ArrayList();
        while (true) {
            String readString = clientConnection.readMessage();
            if (readString.equals("over")) {
                break;
            }
            String[] lines = readString.split(" ");
            Employee employee = new Employee(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7], Boolean.parseBoolean(lines[8]));
            employees.add(employee);
        }
        System.out.println("UserMenu getEmployees return value");
        return employees;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        usersList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        newUser = new javax.swing.JPanel();
        idInformationFirld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fioInformationFirld = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addressInformationFirld = new javax.swing.JTextField();
        mobileInformationFirld = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        loginInformationFirld5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        jLayeredPane1.setLayout(new java.awt.CardLayout());
        usersList.setBackground(new java.awt.Color(255, 255, 255));
        ArrayList<Employee> employe = getE();
        usersInformationModel = new UsersInformationModel(typeOfUser, employe);
        jTable1.setModel(usersInformationModel);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable1.setShowHorizontalLines(false);
        tableColumnAdjuster = new TableColumnAdjuster(jTable1);
        tableColumnAdjuster.adjustColumns();
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/add-user.png")));
        jLabel1.setText("Добавит");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/user_delete.png")));
        jLabel2.setText("Удалить");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/sort.png")));
        jLabel3.setText("Сортировать");
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/book.png")));
        jLabel4.setText("Редактировать");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jButton1.setText("�?мпорт");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("Экспорт");
        jButton2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout usersListLayout = new javax.swing.GroupLayout(usersList);
        usersList.setLayout(usersListLayout);
        usersListLayout.setHorizontalGroup(usersListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(usersListLayout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(usersListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(0, 18, Short.MAX_VALUE)));
        usersListLayout.setVerticalGroup(usersListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE).addGroup(usersListLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(53, 53, 53).addComponent(jLabel3).addGap(42, 42, 42).addComponent(jLabel4).addGap(45, 45, 45).addComponent(jLabel2).addGap(29, 29, 29).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jLayeredPane1.add(usersList, "card2");
        idInformationFirld.setEditable(false);
        idInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 12));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel5.setText("ID");
        fioInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel6.setText("Ф�?О");
        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel7.setText("Адрес");
        addressInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        mobileInformationFirld.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel8.setText("Мобильный номер");
        loginInformationFirld5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel9.setText("Логин");
        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel10.setText("Парол");
        passwordInformationFirld4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel13.setText("Почта");
        emailInformationFirld5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton7.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jButton7.setText("Сохранить данные");
        jButton7.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        roleInformationFirld6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel14.setText("Должность");
        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jLabel15.setText("Доступ к аккаунту");
        jRadioButton2.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jRadioButton2.setText("Запрещён");
        buttonGroup1.add(jRadioButton2);
        jRadioButton3.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jRadioButton3.setText("Разрешён");
        buttonGroup1.add(jRadioButton3);
        jButton8.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jButton8.setText("Отменить");
        jButton8.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout newUserLayout = new javax.swing.GroupLayout(newUser);
        newUser.setLayout(newUserLayout);
        newUserLayout.setHorizontalGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUserLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel13).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(emailInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, newUserLayout.createSequentialGroup().addComponent(jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(passwordInformationFirld4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(loginInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(mobileInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(addressInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(fioInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel5).addGap(127, 127, 127).addComponent(idInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newUserLayout.createSequentialGroup().addComponent(jLabel14).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(roleInformationFirld6, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, newUserLayout.createSequentialGroup().addComponent(jLabel15).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jRadioButton3).addGap(18, 18, 18).addComponent(jRadioButton2))).addGroup(newUserLayout.createSequentialGroup().addComponent(jButton7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton8))).addGap(207, 207, 207)));
        newUserLayout.setVerticalGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(newUserLayout.createSequentialGroup().addGap(54, 54, 54).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(idInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fioInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(addressInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mobileInformationFirld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(loginInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel9)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(passwordInformationFirld4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel10)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(emailInformationFirld5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel13)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(roleInformationFirld6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel14)).addGap(19, 19, 19).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel15).addComponent(jRadioButton2).addComponent(jRadioButton3)).addGap(18, 18, 18).addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jLayeredPane1.add(newUser, "card3");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(null);
    }

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {
        if (jLabel1.isEnabled()) {
            usersList.setVisible(false);
            newUser.setVisible(true);
        }
    }

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {
        if (jLabel4.isEnabled()) {
            if (jTable1.getSelectedRowCount() == 1) {
                Employee em = usersInformationModel.getEmployee(jTable1.getSelectedRow());
                boolean cur = false;
                if (em.getLogin().equals(employee.getLogin()) && em.getEmployeeId() == employee.getEmployeeId() && em.getPassword().equals(employee.getPassword())) {
                    cur = true;
                }
                eed.setUser(em);
                eed.initEmployee();
                eed.setVisible(true);
                if (eed.getIsOk()) {
                    clientConnection.sendMessage("update user information");
                    clientConnection.sendObject(em);
                    String line = clientConnection.readMessage();
                    if (line.equals("success")) {
                        employee.setEmployee(em);
                        usersInformationModel.setEmployee(jTable1.getSelectedRow(), em);
                        usersInformationModel.fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, line);
                        eed.setVisible(false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Выберите элемент!");
            }
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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(fioInformationFirld, roleInformationFirld6, addressInformationFirld, mobileInformationFirld, loginInformationFirld5, passwordInformationFirld4, emailInformationFirld5) && (jRadioButton2.isSelected() || jRadioButton3.isSelected())) {
            Employee em = new Employee(roleInformationFirld6.getText(), fioInformationFirld.getText(), addressInformationFirld.getText(), mobileInformationFirld.getText(), loginInformationFirld5.getText(), passwordInformationFirld4.getText(), emailInformationFirld5.getText(), jRadioButton3.isSelected());
            clientConnection.sendMessage("add user");
            clientConnection.sendObject(em);
            String line = clientConnection.readMessage();
            JOptionPane.showMessageDialog(null, line);
            if (line.equals("success")) {
                em.setEmployeeId(Integer.parseInt(clientConnection.readMessage()));
                usersInformationModel.addEmployee(em);
                usersInformationModel.fireTableDataChanged();
                newUser.setVisible(false);
                usersList.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполните все полья!");
        }
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        newUser.setVisible(false);
        usersList.setVisible(true);
    }

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {
        if (jLabel2.isEnabled()) {
            if (jTable1.getSelectedRowCount() == 1) {
                Employee em = usersInformationModel.getEmployee(jTable1.getSelectedRow());
                clientConnection.sendMessage("delete user");
                clientConnection.sendObject(em);
                String line = clientConnection.readMessage();
                if (line.equals("success")) {
                    usersInformationModel.deleteEmployee(jTable1.getSelectedRow());
                    usersInformationModel.fireTableDataChanged();
                }
                JOptionPane.showMessageDialog(null, line);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите элемент!");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Employee> empl = new ArrayList();
        File file = new File("C:\\Users\\atadu\\Desktop\\test1.xls");
        Workbook wb;
        try {
            wb = Workbook.getWorkbook(file);
            Sheet s = wb.getSheet(0);
            int rows = s.getRows();
            int columns = s.getColumns();
            for (int i = 0; i < rows; i++) {
                String[] data = new String[9];
                int counter = 0;
                for (int j = 0; j < columns; j++) {
                    Cell c = s.getCell(j, i);
                    data[counter++] = c.getContents();
                }
                System.out.println(Arrays.toString(data));
                Employee emp = new Employee(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], false);
                if (Boolean.parseBoolean(data[8])) {
                    emp.setAccess(true);
                }
                empl.add(emp);
                System.out.println("");
            }
        } catch (IOException | BiffException ex) {
            Logger.getLogger(UserListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!empl.isEmpty()) {
            usersInformationModel.clearTable();
            usersInformationModel.setArrayList(empl);
            usersInformationModel.fireTableDataChanged();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ArrayList<Employee> empl = usersInformationModel.getArrayList();
            File file = new File("C:\\Users\\atadu\\Desktop\\test.xls");
            WritableWorkbook wb = Workbook.createWorkbook(file);
            System.out.println("Created");
            WritableSheet writableSheet = wb.createSheet("sh1", 0);
            System.out.println("writebla shit");
            int i = 0;
            for (Employee em : empl) {
                System.out.println("first");
                writableSheet.addCell(new Label(0, i, em.getFio()));
                writableSheet.addCell(new Label(1, i, em.getAddress()));
                writableSheet.addCell(new Label(2, i, em.getMobile()));
                writableSheet.addCell(new Label(3, i, em.getLogin()));
                writableSheet.addCell(new Label(4, i, em.getPassword()));
                writableSheet.addCell(new Label(5, i, em.getEmail()));
                System.out.println(em);
                i++;
                wb.write();
            }
        } catch (IOException | WriteException ex) {
            Logger.getLogger(UserListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Employee> getE() {
        System.out.println("getE");
        ArrayList<Employee> employees = new ArrayList();
        clientConnection.sendMessage("users");
        clientConnection.sendMessage(employee.getRoleName());
        while (true) {
            String line = clientConnection.readMessage();
            if (line.equals("over")) {
                break;
            }
            Employee emp;
            String lines[] = line.split("XxX");
            System.out.println(Arrays.toString(lines));
            if (employee.getRoleName().equals("admin")) {
                emp = new Employee(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7], Boolean.parseBoolean(lines[8]));
            } else {
                emp = new Employee();
                emp.setEmployeeId(Integer.parseInt(lines[0]));
                emp.setFio(lines[1]);
                emp.setRoleName(lines[2]);
                emp.setAddress(lines[3]);
                emp.setMobile(lines[4]);
                emp.setEmail(lines[5]);
            }
            employees.add(emp);
        }
        return employees;
    }

    private javax.swing.JTextField addressInformationFirld;

    private javax.swing.ButtonGroup buttonGroup1;

    private javax.swing.JTextField emailInformationFirld5;

    private javax.swing.JTextField fioInformationFirld;

    private javax.swing.JTextField idInformationFirld;

    private javax.swing.JButton jButton1;

    private javax.swing.JButton jButton2;

    private javax.swing.JButton jButton7;

    private javax.swing.JButton jButton8;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel10;

    private javax.swing.JLabel jLabel13;

    private javax.swing.JLabel jLabel14;

    private javax.swing.JLabel jLabel15;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JLabel jLabel8;

    private javax.swing.JLabel jLabel9;

    private javax.swing.JLayeredPane jLayeredPane1;

    private javax.swing.JRadioButton jRadioButton2;

    private javax.swing.JRadioButton jRadioButton3;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JTable jTable1;

    private javax.swing.JTextField loginInformationFirld5;

    private javax.swing.JTextField mobileInformationFirld;

    private javax.swing.JPanel newUser;

    private javax.swing.JTextField passwordInformationFirld4;

    private javax.swing.JTextField roleInformationFirld6;

    private javax.swing.JPanel usersList;

}
