package javaapplication5.GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication5.Classes.Budget;
import javaapplication5.Classes.Employee;
import javaapplication5.Classes.Operation;
import javaapplication5.Connection.ClientConnection;
import javaapplication5.Dialog.EmployeeEditDialog;
import javaapplication5.Models.BudgetInformationModel;
import javaapplication5.Models.OperationInformationModel;
import javaapplication5.Models.UsersInformationModel;
import javaapplication5.Models.TableColumnAdjuster;
import javaapplication5.Dialog.BudgetEditDialog;
import javaapplication5.Dialog.OperationEditDialog;

public class UserMenu extends javax.swing.JFrame {

    int typeOfUser = 0;

    float currentMoney = 0;

    BigDecimal plan = BigDecimal.ZERO;

    public UserMenu() {
        initComponents();
    }

    ClientConnection clientConnection;

    Employee employee;

    public UserMenu(ClientConnection clientConnection, Employee currentEmployee) {
        this.clientConnection = clientConnection;
        this.employee = currentEmployee;
        if (employee.getRoleName().equals("admin")) {
            typeOfUser = 1;
        } else {
            typeOfUser = 0;
        }
        System.out.println("User menu Constructor");
        initComponents();
        //jLabel12.setVisible(false);
        System.out.println("UserMenu initComponents");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        mainMenuPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        mainMenuLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        mainMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        mainMenuLabel.setBackground(new java.awt.Color(153, 255, 255));
        mainMenuLabel.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        mainMenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/enterprise.png")));
        mainMenuLabel.setText("Статистика расходов");
        mainMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuLabelMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainMenuLabelMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainMenuLabelMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainMenuLabelMousePressed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(mainMenuLabel).addContainerGap(15, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(mainMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel8.setBackground(new java.awt.Color(153, 255, 255));
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/budgeting.png")));
        jLabel8.setText("Бюджеты");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel10.setBackground(new java.awt.Color(153, 255, 255));
        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/teamwork.png")));
        jLabel10.setText("Сотрудники");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(23, 23, 23).addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(23, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel13.setBackground(new java.awt.Color(153, 255, 255));
        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/search.png")));
        jLabel13.setText("Поиск");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(31, Short.MAX_VALUE).addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(14, 14, 14)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel9.setBackground(new java.awt.Color(153, 255, 255));
        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/checklist.png")));
        jLabel9.setText("Транзакции");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel16.setBackground(new java.awt.Color(153, 255, 255));
        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/exit.png")));
        jLabel16.setText("Выйти");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(18, Short.MAX_VALUE)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/shield.png")));
        jLabel1.setText("Личные данные");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jLabel12.setBackground(new java.awt.Color(153, 255, 255));
        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel12.setText("Статистик доходов");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(41, 41, 41).addComponent(jLabel12).addContainerGap(43, Short.MAX_VALUE)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel9MousePressed(evt);
            }
        });
        jLabel17.setBackground(new java.awt.Color(153, 255, 255));
        jLabel17.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel17.setText("Прогресс");
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(74, 74, 74).addComponent(jLabel17).addContainerGap(80, Short.MAX_VALUE)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addContainerGap()));
        jButton1.setText("Сохранит личные данные");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout mainMenuPanelLayout = new javax.swing.GroupLayout(mainMenuPanel);
        mainMenuPanel.setLayout(mainMenuPanelLayout);
        mainMenuPanelLayout.setHorizontalGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainMenuPanelLayout.createSequentialGroup().addGap(35, 35, 35).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(87, 87, 87).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(82, 82, 82).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(48, 48, 48)));
        mainMenuPanelLayout.setVerticalGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainMenuPanelLayout.createSequentialGroup().addGap(45, 45, 45).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(mainMenuPanelLayout.createSequentialGroup().addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(50, 50, 50).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainMenuPanelLayout.createSequentialGroup().addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(50, 50, 50).addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(mainMenuPanelLayout.createSequentialGroup().addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(50, 50, 50).addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(mainMenuPanelLayout.createSequentialGroup().addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(50, 50, 50).addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))).addGap(18, 18, 18).addComponent(jButton1).addContainerGap()));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(mainMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(mainMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        clientConnection.sendMessage("User log out");
        clientConnection.close();
        dispose();
    }

    public float getCurrentMoney() {
        clientConnection.sendMessage("current money");
        float val = Float.parseFloat(clientConnection.readMessage());
        return val;
    }

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        new UserGui(clientConnection).setVisible(true);
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        setVisible(false);
        UserSettingsFrame olf = new UserSettingsFrame(clientConnection, employee);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                olf.dispose();
                setVisible(true);
            }
        });
        olf.setVisible(true);
    }

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {
        UserListFrame olf = new UserListFrame(clientConnection, employee, typeOfUser);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                setVisible(true);
                olf.dispose();
            }
        });
        setVisible(false);
        olf.setVisible(true);
    }

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {
        OperationsListFrame olf = new OperationsListFrame(clientConnection, employee);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                setVisible(true);
                olf.dispose();
            }
        });
        setVisible(false);
        olf.setVisible(true);
    }

    private void mainMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {
        BudgetFrame olf = new BudgetFrame(clientConnection, employee);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                setVisible(true);
                olf.dispose();
            }
        });
        setVisible(false);
        olf.setVisible(true);
    }

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void mainMenuLabelMouseExited(java.awt.event.MouseEvent evt) {
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void mainMenuLabelMouseEntered(java.awt.event.MouseEvent evt) {
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void mainMenuLabelMousePressed(java.awt.event.MouseEvent evt) {
        OperationStatistics olf = new OperationStatistics(clientConnection, employee);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                setVisible(true);
                olf.dispose();
            }
        });
        setVisible(false);
        olf.setVisible(true);
    }

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 0, 102)));
    }

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 102)));
    }

    private void jPanel9MousePressed(java.awt.event.MouseEvent evt) {
        clientConnection.sendMessage("current money");
        float val = Float.parseFloat(clientConnection.readMessage());
        System.out.println(val);
        clientConnection.sendMessage("waiting sum and fact sum");
        BigDecimal pamount = (BigDecimal) clientConnection.readObject();
        BigDecimal famount = (BigDecimal) clientConnection.readObject();
        progress olf = new progress(val, pamount, famount);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                setVisible(true);
                olf.dispose();
            }
        });
        setVisible(false);
        olf.setVisible(true);
    }

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {
        SearchInformation olf = new SearchInformation(clientConnection, employee, typeOfUser);
        olf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                olf.dispose();
                setVisible(true);
            }
        });
        this.setVisible(false);
        olf.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\atadu\\Desktop\\test.txt");
            fileWriter.write(employee.toString());
            fileWriter.close();
            ;
        } catch (IOException ex) {
            Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public ArrayList<Budget> getBudgets() {
        ArrayList<Budget> budgets = new ArrayList();
        System.out.println("getBudget");
        clientConnection.sendMessage("budgets");
        String line = "";
        while (true) {
            line = clientConnection.readMessage();
            if (line.equals("over")) {
                break;
            }
            String[] pala = line.split("XxX");
            System.out.println("pala[] = " + Arrays.toString(pala));
            try {
                Budget budget = new Budget(pala[0], pala[1], new BigDecimal(pala[2]), new BigDecimal(pala[3]), Boolean.parseBoolean(pala[4]), new SimpleDateFormat("yyyy-MM-dd").parse(pala[5]), new SimpleDateFormat("yyyy-MM-dd").parse(pala[6]), Integer.parseInt(pala[7]));
                budgets.add(budget);
            } catch (ParseException ex) {
                Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return budgets;
    }

    public ArrayList<Operation> getOperation() {
        ArrayList<Operation> operations = new ArrayList();
        clientConnection.sendMessage("operations");
        System.out.println("getOperation");
        String line = "";
        String[] pala;
        while (true) {
            line = clientConnection.readMessage();
            if (line.equals("over")) {
                break;
            }
            pala = line.split("XxX");
            System.out.println("pala[] :  " + Arrays.toString(pala));
            Operation operation;
            try {
                operation = new Operation(Integer.parseInt(pala[0]), pala[1], pala[2], new SimpleDateFormat("yyyy-MM-dd").parse(pala[3]), pala[4], pala[5], new BigDecimal(pala[6]));
                operations.add(operation);
                System.out.println("Operation: " + operation);
            } catch (ParseException ex) {
                Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operations;
    }

    private javax.swing.JButton jButton1;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel10;

    private javax.swing.JLabel jLabel12;

    private javax.swing.JLabel jLabel13;

    private javax.swing.JLabel jLabel16;

    private javax.swing.JLabel jLabel17;

    private javax.swing.JLabel jLabel8;

    private javax.swing.JLabel jLabel9;

    private javax.swing.JPanel jPanel1;

    private javax.swing.JPanel jPanel2;

    private javax.swing.JPanel jPanel3;

    private javax.swing.JPanel jPanel4;

    private javax.swing.JPanel jPanel5;

    private javax.swing.JPanel jPanel6;

    private javax.swing.JPanel jPanel7;

    private javax.swing.JPanel jPanel8;

    private javax.swing.JPanel jPanel9;

    private javax.swing.JLabel mainMenuLabel;

    private javax.swing.JPanel mainMenuPanel;

    private TableColumnAdjuster jAdjuster;

    private UsersInformationModel model;

    private EmployeeEditDialog employeeEditDialog;

    private BudgetEditDialog budgetEditDialog;

    private OperationEditDialog operationEditDialog;

    private BudgetInformationModel budgetInformationModel;

    private OperationInformationModel operationInformationModel;

}
