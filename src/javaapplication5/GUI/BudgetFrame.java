package javaapplication5.GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.datatransfer.DataFlavor;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication5.Classes.Budget;
import javaapplication5.Classes.ConvertMoney;
import javaapplication5.Classes.Currency;
import javaapplication5.Classes.Employee;
import javaapplication5.Connection.ClientConnection;
import javaapplication5.Dialog.BudgetEditDialog;
import javaapplication5.Models.BudgetInformationModel;
import javaapplication5.Models.TableColumnAdjuster;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

public class BudgetFrame extends javax.swing.JFrame {

    ClientConnection clientConnection;

    Employee employee;

    BudgetEditDialog budgetEditDialog;

    public BudgetFrame(ClientConnection clientConnection, Employee employee) {
        this.clientConnection = clientConnection;
        this.employee = employee;
        System.out.println("role name is +" + employee.getRoleName());
        budgetEditDialog = new BudgetEditDialog(this, true);
        initComponents();
    }

    public BudgetFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        budgetListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        newBudgetPanel = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        endBudgetDate = new datechooser.beans.DateChooserCombo();
        startBudgetDate = new datechooser.beans.DateChooserCombo();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        budgetPlanAmount = new javax.swing.JTextField();
        factAmountField = new javax.swing.JTextField();
        budgetNameField = new javax.swing.JTextField();
        idClientFieldBudget = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        jLayeredPane1.setLayout(new java.awt.CardLayout());
        budgetListPanel.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Malgun Gothic", 0, 18));
        ArrayList<Budget> budgets = getBudgets();
        budgetInformationModel = new BudgetInformationModel(budgets);
        jTable1.getTableHeader().setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable1.setModel(budgetInformationModel);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable1.setShowGrid(false);
        jTable1.setShowVerticalLines(true);
        jAdjuster = new TableColumnAdjuster(jTable1);
        jAdjuster.adjustColumns();
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/delete_inf.png")));
        jLabel21.setText("Удалить");
        jLabel21.setToolTipText("");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });
        jLabel23.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/book.png")));
        jLabel23.setText("Редактировать");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });
        jLabel22.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/sort.png")));
        jLabel22.setText("Сортировать");
        jLabel22.setToolTipText("");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jLabel30.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/add-file.png")));
        jLabel30.setText("Добавить");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel30MousePressed(evt);
            }
        });
        jButton1.setText("Отображать в USD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton3.setText("Отображать в BYN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setText("Отображать в EUR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLabel9.setText("Валюта:");
        javax.swing.GroupLayout budgetListPanelLayout = new javax.swing.GroupLayout(budgetListPanel);
        budgetListPanel.setLayout(budgetListPanelLayout);
        budgetListPanelLayout.setHorizontalGroup(budgetListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(budgetListPanelLayout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(budgetListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel21).addComponent(jLabel23).addComponent(jLabel30).addComponent(jLabel9).addGroup(budgetListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addContainerGap(17, Short.MAX_VALUE)));
        budgetListPanelLayout.setVerticalGroup(budgetListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(budgetListPanelLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(jLabel21).addGap(29, 29, 29).addComponent(jLabel23).addGap(51, 51, 51).addComponent(jLabel22).addGap(46, 46, 46).addComponent(jLabel30).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE));
        jLayeredPane1.add(budgetListPanel, "card3");
        newBudgetPanel.setBackground(new java.awt.Color(255, 255, 255));
        newBudgetPanel.setVisible(false);
        cancel.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        cancel.setText("Отменить");
        cancel.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel8.setText("ID клиента");
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel1.setText("Наименования бюджета");
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel2.setText("Валюта");
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setText("Фактическая сумма");
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setText("Бюджетный план");
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setText("Состояния");
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setText("Дата началы");
        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel7.setText("Дата окончания");
        endBudgetDate.setNothingAllowed(false);
        endBudgetDate.setFieldFont(new java.awt.Font("Malgun Gothic", java.awt.Font.PLAIN, 14));
        startBudgetDate.setNothingAllowed(false);
        startBudgetDate.setFieldFont(new java.awt.Font("Malgun Gothic", java.awt.Font.PLAIN, 14));
        jRadioButton1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jRadioButton1.setText("Активнен");
        if (employee.getRoleName().equals("admin"))
            jRadioButton1.setEnabled(true);
        else {
            jRadioButton1.setEnabled(false);
        }
        jRadioButton2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jRadioButton2.setText("Не активен");
        if (employee.getRoleName().equals("admin"))
            jRadioButton2.setEnabled(true);
        else
            jRadioButton2.setEnabled(false);
        budgetPlanAmount.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        factAmountField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        budgetNameField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        idClientFieldBudget.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton2.setText("Сохранить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USD", "BYN", "EUR" }));
        javax.swing.GroupLayout newBudgetPanelLayout = new javax.swing.GroupLayout(newBudgetPanel);
        newBudgetPanel.setLayout(newBudgetPanelLayout);
        newBudgetPanelLayout.setHorizontalGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBudgetPanelLayout.createSequentialGroup().addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(newBudgetPanelLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton2).addGap(26, 26, 26).addComponent(cancel)).addGroup(newBudgetPanelLayout.createSequentialGroup().addGap(213, 213, 213).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBudgetPanelLayout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE).addComponent(budgetNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newBudgetPanelLayout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newBudgetPanelLayout.createSequentialGroup().addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jRadioButton1).addGap(37, 37, 37).addComponent(jRadioButton2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBudgetPanelLayout.createSequentialGroup().addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4).addComponent(jLabel6).addComponent(jLabel7).addComponent(jLabel3).addComponent(jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(idClientFieldBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(factAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(budgetPlanAmount).addComponent(startBudgetDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(endBudgetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))))).addGap(201, 201, 201)));
        newBudgetPanelLayout.setVerticalGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(newBudgetPanelLayout.createSequentialGroup().addGap(76, 76, 76).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(budgetNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1)).addGap(18, 18, 18).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(factAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel3)).addGap(18, 18, 18).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(budgetPlanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addGap(18, 18, 18).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jRadioButton1).addComponent(jRadioButton2).addComponent(jLabel5)).addGap(18, 18, 18).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(startBudgetDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(endBudgetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addGap(18, 18, 18).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8).addComponent(idClientFieldBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(47, 47, 47).addGroup(newBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(cancel).addComponent(jButton2)).addGap(60, 60, 60)));
        jLayeredPane1.add(newBudgetPanel, "card2");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLayeredPane1));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLayeredPane1));
        pack();
        setLocationRelativeTo(null);
    }

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {
        budgetListPanel.setVisible(false);
        newBudgetPanel.setVisible(true);
    }

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {
        newBudgetPanel.setVisible(false);
        budgetListPanel.setVisible(true);
    }

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {
        if (jTable1.getSelectedRowCount() == 1) {
            Budget budget = budgetInformationModel.getBudget(jTable1.getSelectedRow());
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить?", "Подтвердите действия", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                clientConnection.sendMessage("delete budget");
                clientConnection.sendObject(budget);
                JOptionPane.showMessageDialog(null, clientConnection.readMessage());
                budgetInformationModel.deleteBudget(jTable1.getSelectedRow());
                budgetInformationModel.fireTableDataChanged();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите элемент!");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(budgetNameField, budgetPlanAmount, factAmountField, idClientFieldBudget)) {
            clientConnection.sendMessage("add new budget");
            clientConnection.sendMessage(budgetNameField.getText());
            String isExists = clientConnection.readMessage();
            if (isExists.equals("exists")) {
                JOptionPane.showMessageDialog(null, "Бюджет с таким именем уже существует");
            } else {
                BigDecimal factAmout;
                BigDecimal planAmount;
                System.out.println("init fact and plan");
                if (jComboBox1.getSelectedItem().equals("EUR")) {
                    System.out.println("if euro");
                    factAmout = ConvertMoney.eur_to_usd(new BigDecimal(factAmountField.getText()));
                    planAmount = ConvertMoney.eur_to_usd(new BigDecimal(budgetPlanAmount.getText()));
                } else if (jComboBox1.getSelectedItem().equals("BYN")) {
                    System.out.println("if BYN");
                    factAmout = ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(new BigDecimal(factAmountField.getText())));
                    planAmount = ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(new BigDecimal(budgetPlanAmount.getText())));
                } else {
                    System.out.println("if USD");
                    factAmout = new BigDecimal(factAmountField.getText());
                    planAmount = new BigDecimal(budgetPlanAmount.getText());
                }
                System.out.println("before new budget");
                Budget e = new Budget(budgetNameField.getText(), (String) jComboBox1.getSelectedItem(), factAmout, planAmount, jRadioButton1.isSelected(), startBudgetDate.getSelectedDate().getTime(), endBudgetDate.getSelectedDate().getTime(), Integer.parseInt(idClientFieldBudget.getText()));
                System.out.println("after new budget");
                System.out.println(startBudgetDate.getSelectedDate().getTime().toString());
                if (jComboBox1.getSelectedItem().equals("BYN")) {
                    e.setCurrencyId("USD");
                    e.setFactAmount(ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(e.getFactAmount())));
                    e.setPlanAmount(ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(e.getPlanAmount())));
                } else if (jComboBox1.getSelectedItem().equals("EUR")) {
                    e.setCurrencyId("USD");
                    e.setFactAmount(ConvertMoney.eur_to_usd(e.getFactAmount()));
                    e.setPlanAmount(ConvertMoney.eur_to_usd(e.getPlanAmount()));
                }
                System.out.println(e);
                clientConnection.sendObject(e);
                String answer = clientConnection.readMessage();
                JOptionPane.showMessageDialog(null, answer);
                if (answer.equals("success")) {
                    budgetInformationModel.addBudget(e);
                    budgetInformationModel.fireTableDataChanged();
                    jAdjuster.adjustColumns();
                    newBudgetPanel.setVisible(false);
                    budgetListPanel.setVisible(true);
                    budgetNameField.setText("");
                    factAmountField.setText("");
                    budgetPlanAmount.setText("");
                    buttonGroup1.clearSelection();
                    startBudgetDate.setSelectedDate(Calendar.getInstance());
                    endBudgetDate.setSelectedDate(Calendar.getInstance());
                    idClientFieldBudget.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполните все полья!");
        }
    }

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {
        if (jTable1.getSelectedRowCount() == 1) {
            Budget budget = budgetInformationModel.getBudget(jTable1.getSelectedRow());
            System.out.println(budget);
            budgetEditDialog.setBudget(budget);
            budgetEditDialog.initBudget();
            budgetEditDialog.setVisible(true);
            if (budgetEditDialog.isIsOk()) {
                clientConnection.sendMessage("edit budget information");
                BigDecimal factAmout;
                BigDecimal planAmount;
                if (budgetEditDialog.getjComboBox1().getSelectedItem().equals("EUR")) {
                    factAmout = ConvertMoney.eur_to_usd(new BigDecimal(budgetEditDialog.getFactAmountField().getText()));
                    planAmount = ConvertMoney.eur_to_usd(new BigDecimal(budgetEditDialog.getBudgetPlanAmount().getText()));
                } else if (budgetEditDialog.getjComboBox1().getSelectedItem().equals("BYN")) {
                    factAmout = ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(new BigDecimal(budgetEditDialog.getFactAmountField().getText())));
                    planAmount = ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(new BigDecimal(budgetEditDialog.getBudgetPlanAmount().getText())));
                } else {
                    factAmout = new BigDecimal(budgetEditDialog.getFactAmountField().getText());
                    planAmount = new BigDecimal(budgetEditDialog.getBudgetPlanAmount().getText());
                }
                String send = budgetEditDialog.getBudgetNameField().getText() + "XxX" + (String) budgetEditDialog.getjComboBox1().getSelectedItem() + "XxX" + factAmout.toString() + "XxX" + planAmount.toString() + "XxX" + Boolean.toString(budgetEditDialog.getIsActiveField()) + "XxX" + new SimpleDateFormat("yyyy-MM-dd").format(budgetEditDialog.getStartBudgetDate().getSelectedDate().getTime()) + "XxX" + new SimpleDateFormat("yyyy-MM-dd").format(budgetEditDialog.getEndBudgetDate().getSelectedDate().getTime()) + "XxX" + budgetEditDialog.getIdClientFieldBudget().getText() + "XxX" + budget.getBudgetName();
                System.out.println("Client sending: " + send);
                clientConnection.sendMessage(send);
                send = clientConnection.readMessage();
                JOptionPane.showMessageDialog(null, send);
                if (send.equals("success")) {
                    budgetInformationModel.setBudget(jTable1.getSelectedRow(), EditBudgetFieldConvertorToBudget(budgetEditDialog));
                    budgetInformationModel.fireTableDataChanged();
                    jAdjuster.adjustColumns();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите элемент!");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!budgetInformationModel.isEmpty()) {
            budgetInformationModel.clearTable();
            ArrayList<Budget> budgets = getBudgets();
            budgetInformationModel.setArrayList(budgets);
            budgetInformationModel.fireTableDataChanged();
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!budgetInformationModel.isEmpty()) {
            budgetInformationModel.clearTable();
            ArrayList<Budget> budgets = getBudgets();
            for (Budget b : budgets) {
                b.setCurrencyId("BYN");
                b.setFactAmount(ConvertMoney.usd_to_byn(b.getFactAmount()));
                b.setPlanAmount(ConvertMoney.usd_to_byn(b.getPlanAmount()));
            }
            budgetInformationModel.setArrayList(budgets);
            budgetInformationModel.fireTableDataChanged();
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!budgetInformationModel.isEmpty()) {
            budgetInformationModel.clearTable();
            ArrayList<Budget> budgets = getBudgets();
            for (Budget b : budgets) {
                b.setCurrencyId("EUR");
                b.setFactAmount(ConvertMoney.usd_to_eur(b.getFactAmount()));
                b.setPlanAmount(ConvertMoney.usd_to_eur(b.getPlanAmount()));
            }
            budgetInformationModel.setArrayList(budgets);
            budgetInformationModel.fireTableDataChanged();
        }
    }

    String currencyType = "USD";

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
                System.out.println(budget.getStartDate().toString());
                System.err.println(budget.getEndDate().toString());
            } catch (ParseException ex) {
                Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return budgets;
    }

    public void changeValues(String to) {
        currencyType = to;
    }

    private Budget EditBudgetFieldConvertorToBudget(BudgetEditDialog budgetEditDialog) {
        return new Budget(budgetEditDialog.getBudgetNameField().getText(), (String) budgetEditDialog.getjComboBox1().getSelectedItem(), new BigDecimal(budgetEditDialog.getFactAmountField().getText()), new BigDecimal(budgetEditDialog.getBudgetPlanAmount().getText()), budgetEditDialog.getIsActiveField(), budgetEditDialog.getStartBudgetDate().getSelectedDate().getTime(), budgetEditDialog.getEndBudgetDate().getSelectedDate().getTime(), Integer.parseInt(budgetEditDialog.getIdClientFieldBudget().getText()));
    }

    TableColumnAdjuster jAdjuster;

    BudgetInformationModel budgetInformationModel;

    private javax.swing.JPanel budgetListPanel;

    private javax.swing.JTextField budgetNameField;

    private javax.swing.JTextField budgetPlanAmount;

    private javax.swing.ButtonGroup buttonGroup1;

    private javax.swing.JButton cancel;

    private datechooser.beans.DateChooserCombo endBudgetDate;

    private javax.swing.JTextField factAmountField;

    private javax.swing.JTextField idClientFieldBudget;

    private javax.swing.JButton jButton1;

    private javax.swing.JButton jButton2;

    private javax.swing.JButton jButton3;

    private javax.swing.JButton jButton4;

    private javax.swing.JComboBox<String> jComboBox1;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel21;

    private javax.swing.JLabel jLabel22;

    private javax.swing.JLabel jLabel23;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel30;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JLabel jLabel8;

    private javax.swing.JLabel jLabel9;

    private javax.swing.JLayeredPane jLayeredPane1;

    private javax.swing.JRadioButton jRadioButton1;

    private javax.swing.JRadioButton jRadioButton2;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JTable jTable1;

    private javax.swing.JPanel newBudgetPanel;

    private datechooser.beans.DateChooserCombo startBudgetDate;

}
