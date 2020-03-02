package javaapplication5.GUI;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication5.Classes.Budget;
import javaapplication5.Classes.ConvertMoney;
import javaapplication5.Classes.Convertor;
import javaapplication5.Classes.Employee;
import javaapplication5.Classes.Operation;
import javaapplication5.Connection.ClientConnection;
import javaapplication5.Dialog.OperationEditDialog;
import javaapplication5.Models.OperationInformationModel;
import javaapplication5.Models.TableColumnAdjuster;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.transform.sax.SAXSource;

public class OperationsListFrame extends javax.swing.JFrame {

    public OperationsListFrame() {
        initComponents();
    }

    ClientConnection clientConnection;

    Employee employee;

    TableColumnAdjuster jAdjuster;

    OperationInformationModel operationInformationModel;

    OperationEditDialog operationEditDialog;

    float currMoney = 0;

    public OperationsListFrame(ClientConnection clientConnection, Employee employee) {
        this.clientConnection = clientConnection;
        this.employee = employee;
        operationEditDialog = new OperationEditDialog(this, true);
        initComponents();
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

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLayeredPane1 = new javax.swing.JLayeredPane();
        operationListPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        newOperation = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        operationAmountField = new javax.swing.JTextField();
        operationNotesField = new javax.swing.JTextField();
        operationTypeField = new javax.swing.JTextField();
        operationDateTransaction = new datechooser.beans.DateChooserCombo();
        budgetNameFieldtOperation = new javax.swing.JTextField();
        operationIdField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        jLayeredPane1.setLayout(new java.awt.CardLayout());
        operationListPanel.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/delete_inf.png")));
        jLabel18.setText("Удалить");
        jLabel18.setToolTipText("");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        jLabel19.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/sort.png")));
        jLabel19.setText("Сортировать");
        jLabel19.setToolTipText("");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/book.png")));
        jLabel20.setText("Редактировать");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });
        jLabel29.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/add-file.png")));
        jLabel29.setText("Добавить");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel29MousePressed(evt);
            }
        });
        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        ArrayList<Operation> operations = getOperation();
        operationInformationModel = new OperationInformationModel(operations);
        jTable3.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable3.setModel(operationInformationModel);
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable3.setShowHorizontalLines(false);
        jAdjuster = new TableColumnAdjuster(jTable3);
        jAdjuster.adjustColumns();
        jScrollPane3.setViewportView(jTable3);
        jScrollPane3.getViewport().setBackground(new Color(255, 255, 255));
        jButton3.setText("Отображать в USD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setText("Отображать в BYN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton5.setText("Отображать в EUR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout operationListPanelLayout = new javax.swing.GroupLayout(operationListPanel);
        operationListPanel.setLayout(operationListPanelLayout);
        operationListPanelLayout.setHorizontalGroup(operationListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(operationListPanelLayout.createSequentialGroup().addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(operationListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jLabel18).addComponent(jLabel19).addComponent(jLabel20).addComponent(jLabel29).addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE).addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap(25, Short.MAX_VALUE)));
        operationListPanelLayout.setVerticalGroup(operationListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE).addGroup(operationListPanelLayout.createSequentialGroup().addContainerGap().addComponent(jLabel18).addGap(26, 26, 26).addComponent(jLabel19).addGap(18, 18, 18).addComponent(jLabel20).addGap(18, 18, 18).addComponent(jLabel29).addGap(43, 43, 43).addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(29, 29, 29).addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(29, 29, 29).addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jLayeredPane1.add(operationListPanel, "card2");
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel8.setText("ID");
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel1.setText("Наименования бюджета");
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setText("Код валюты");
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setText("Дата транзакции");
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setText("Вид транзакции");
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setText("Заметка");
        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel7.setText("Сумма");
        operationAmountField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        operationNotesField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        operationTypeField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        operationDateTransaction.setFieldFont(new java.awt.Font("Malgun Gothic", java.awt.Font.PLAIN, 14));
        budgetNameFieldtOperation.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        operationIdField.setEditable(false);
        operationIdField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton1.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jButton1.setText("Сохранить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton2.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jButton2.setText("Отменить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USD", "BYN", "EUR" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        javax.swing.GroupLayout newOperationLayout = new javax.swing.GroupLayout(newOperation);
        newOperation.setLayout(newOperationLayout);
        newOperationLayout.setHorizontalGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(newOperationLayout.createSequentialGroup().addGap(156, 156, 156).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(newOperationLayout.createSequentialGroup().addComponent(jLabel8).addGap(46, 46, 46).addComponent(operationIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newOperationLayout.createSequentialGroup().addComponent(jLabel2).addGap(6, 6, 6).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(operationDateTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(newOperationLayout.createSequentialGroup().addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel6).addComponent(jLabel5).addComponent(jLabel7).addComponent(jLabel4)).addGap(46, 46, 46).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(operationTypeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(operationNotesField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(newOperationLayout.createSequentialGroup().addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addComponent(jLabel3)).addGap(46, 46, 46).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(operationAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(budgetNameFieldtOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(newOperationLayout.createSequentialGroup().addComponent(jButton1).addGap(18, 18, 18).addComponent(jButton2))))).addContainerGap(248, Short.MAX_VALUE)));
        newOperationLayout.setVerticalGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(newOperationLayout.createSequentialGroup().addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(newOperationLayout.createSequentialGroup().addGap(94, 94, 94).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operationIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(budgetNameFieldtOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(operationDateTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operationTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(operationNotesField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operationAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addGap(18, 18, 18).addGroup(newOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2))).addGroup(newOperationLayout.createSequentialGroup().addGap(138, 138, 138).addComponent(jLabel2))).addContainerGap(100, Short.MAX_VALUE)));
        jLayeredPane1.add(newOperation, "card3");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING));
        pack();
        setLocationRelativeTo(null);
    }

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {
        TableRowSorter<TableModel> sorter = new TableRowSorter(jTable3.getModel());
        jTable3.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList();
        int columnIndexToSort = 1;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {
        if (jTable3.getSelectedRowCount() == 1) {
            Operation operation = operationInformationModel.getOperation(jTable3.getSelectedRow());
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить?", "Подтвердите действия", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                clientConnection.sendMessage("delete operation");
                clientConnection.sendObject(operation);
                JOptionPane.showMessageDialog(null, clientConnection.readMessage());
                operationInformationModel.deleteOperation(jTable3.getSelectedRow());
                operationInformationModel.fireTableDataChanged();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите элемент!");
        }
    }

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {
        if (jTable3.getSelectedRowCount() == 1) {
            Operation operation = operationInformationModel.getOperation(jTable3.getSelectedRow());
            System.out.println(operation);
            operationEditDialog.setOperation(operation);
            operationEditDialog.initOperation();
            operationEditDialog.setVisible(true);
            if (operationEditDialog.isIsOk()) {
                operation.setIdOperation(Integer.parseInt(operationEditDialog.getOperationIdField().getText()));
                BigDecimal g;
                if (operationEditDialog.getjComboBox1().getSelectedItem().equals("BYN")) {
                    g = ConvertMoney.eur_to_usd(ConvertMoney.byn_to_eur(new BigDecimal(operationEditDialog.getOperationAmountField().getText())));
                } else if (operationEditDialog.getjComboBox1().getSelectedItem().equals("EUR")) {
                    g = ConvertMoney.eur_to_usd(new BigDecimal(operationEditDialog.getOperationAmountField().getText()));
                } else {
                    g = new BigDecimal(operationEditDialog.getOperationAmountField().getText());
                }
                clientConnection.sendMessage("current money");
                BigDecimal currValue = new BigDecimal(clientConnection.readMessage());
                operation.setAmount(g);
                if (operation.getAmount().compareTo(currValue) > 0) {
                    JOptionPane.showMessageDialog(null, "Ощибка не хватает денег xD");
                } else {
                    operation.setAmount(g);
                    operation.setBudgetCurrency((String) operationEditDialog.getjComboBox1().getSelectedItem());
                    operation.setBudgetName(operationEditDialog.getBudgetNameFieldtOperation().getText());
                    operation.setNotes(operationEditDialog.getOperationNotesField().getText());
                    operation.setOperationDate(operationEditDialog.getOperationDateTransaction().getSelectedDate().getTime());
                    operation.setOperationType(operationEditDialog.getOperationTypeField().getText());
                    clientConnection.sendMessage("edit operation");
                    clientConnection.sendObject(operation);
                    String line = clientConnection.readMessage();
                    JOptionPane.showMessageDialog(null, line);
                    if (line.equals("success")) {
                        operationInformationModel.setValue(jTable3.getSelectedRow(), operation);
                        operationInformationModel.fireTableDataChanged();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите элемент!");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(budgetNameFieldtOperation, operationAmountField, operationTypeField)) {
            Operation operation = new Operation();
            BigDecimal bg;
            if (jComboBox1.getSelectedItem().equals("BYN")) {
                bg = ConvertMoney.byn_to_eur(ConvertMoney.eur_to_usd(new BigDecimal(operationAmountField.getText())));
            } else if (jComboBox1.getSelectedItem().equals("EUR")) {
                bg = ConvertMoney.eur_to_usd(new BigDecimal(operationAmountField.getText()));
            } else {
                bg = new BigDecimal(operationAmountField.getText());
            }
            if (operationTypeField.getText().equals("expense")) {
                clientConnection.sendMessage("current budget money");
                BigDecimal currValue = new BigDecimal(clientConnection.readMessage());
                operation.setAmount(bg);
                if (operation.getAmount().compareTo(currValue) > 0) {
                    JOptionPane.showMessageDialog(null, "Ощибка не хватает денег xD");
                } else {
                    operation.setBudgetCurrency("USD");
                    operation.setBudgetName(budgetNameFieldtOperation.getText());
                    operation.setNotes(operationNotesField.getText());
                    operation.setOperationDate(operationDateTransaction.getSelectedDate().getTime());
                    operation.setOperationType(operationTypeField.getText());
                    clientConnection.sendMessage("add operation");
                    clientConnection.sendObject(operation);
                    String line = clientConnection.readMessage();
                    JOptionPane.showMessageDialog(null, line);
                    if (line.equals("success")) {
                        operation.setIdOperation(Integer.parseInt(clientConnection.readMessage()));
                        clientConnection.sendMessage("expense from budget");
                        clientConnection.sendObject(operation);
                        String out = clientConnection.readMessage();
                        System.out.println(out);
                        operationInformationModel.addOperation(operation);
                        operationInformationModel.fireTableDataChanged();
                        newOperation.setVisible(false);
                        operationListPanel.setVisible(true);
                    }
                }
            } else {
                operation.setAmount(bg);
                operation.setBudgetCurrency("USD");
                operation.setBudgetName(budgetNameFieldtOperation.getText());
                operation.setNotes(operationNotesField.getText());
                operation.setOperationDate(operationDateTransaction.getSelectedDate().getTime());
                operation.setOperationType(operationTypeField.getText());
                clientConnection.sendMessage("add operation");
                clientConnection.sendObject(operation);
                String line = clientConnection.readMessage();
                JOptionPane.showMessageDialog(null, line);
                if (line.equals("success")) {
                    operation.setIdOperation(Integer.parseInt(clientConnection.readMessage()));
                    clientConnection.sendMessage("profit to budget");
                    clientConnection.sendObject(operation);
                    System.out.println("profit status: " + clientConnection.readMessage());
                    operationInformationModel.addOperation(operation);
                    operationInformationModel.fireTableDataChanged();
                    newOperation.setVisible(false);
                    operationListPanel.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполните все полья!");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        newOperation.setVisible(false);
        operationListPanel.setVisible(true);
    }

    private void jLabel29MousePressed(java.awt.event.MouseEvent evt) {
        operationListPanel.setVisible(false);
        newOperation.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!operationInformationModel.isEmpty()) {
            operationInformationModel.clearTable();
            ArrayList<Operation> operations = getOperation();
            operationInformationModel.setArrayList(operations);
            operationInformationModel.fireTableDataChanged();
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!operationInformationModel.isEmpty()) {
            operationInformationModel.clearTable();
            ArrayList<Operation> operations = getOperation();
            for (Operation o : operations) {
                o.setBudgetCurrency("BYN");
                o.setAmount(ConvertMoney.usd_to_byn(o.getAmount()));
            }
            operationInformationModel.setArrayList(operations);
            operationInformationModel.fireTableDataChanged();
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!operationInformationModel.isEmpty()) {
            operationInformationModel.clearTable();
            ArrayList<Operation> operations = getOperation();
            for (Operation o : operations) {
                o.setBudgetCurrency("EUR");
                o.setAmount(ConvertMoney.byn_to_eur(ConvertMoney.usd_to_byn(o.getAmount())));
            }
            operationInformationModel.setArrayList(operations);
            operationInformationModel.fireTableDataChanged();
        }
    }

    String currNew = "USD";

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
    }

    public boolean check(JTextField... jtfs) {
        for (JTextField jtf : jtfs) {
            if (jtf.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private javax.swing.JTextField budgetNameFieldtOperation;

    private javax.swing.JButton jButton1;

    private javax.swing.JButton jButton2;

    private javax.swing.JButton jButton3;

    private javax.swing.JButton jButton4;

    private javax.swing.JButton jButton5;

    private javax.swing.JComboBox<String> jComboBox1;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel18;

    private javax.swing.JLabel jLabel19;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel20;

    private javax.swing.JLabel jLabel29;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JLabel jLabel8;

    private javax.swing.JLayeredPane jLayeredPane1;

    private javax.swing.JScrollPane jScrollPane3;

    private javax.swing.JTable jTable3;

    private javax.swing.JPanel newOperation;

    private javax.swing.JTextField operationAmountField;

    private datechooser.beans.DateChooserCombo operationDateTransaction;

    private javax.swing.JTextField operationIdField;

    private javax.swing.JPanel operationListPanel;

    private javax.swing.JTextField operationNotesField;

    private javax.swing.JTextField operationTypeField;

    
}
