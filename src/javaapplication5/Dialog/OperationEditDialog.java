package javaapplication5.Dialog;

import datechooser.beans.DateChooserCombo;
import java.awt.Frame;
import java.util.Calendar;
import javaapplication5.Classes.Convertor;
import javaapplication5.Classes.Operation;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OperationEditDialog extends javax.swing.JDialog {

    public OperationEditDialog() {
        initComponents();
    }

    boolean isOk = false;

    public OperationEditDialog(Frame owFrame, boolean modal) {
        super(owFrame, modal);
        initComponents();
    }

    private Operation operation = null;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public boolean isIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public JTextField getOperationIdField() {
        return operationIdField;
    }

    public void setOperationIdField(JTextField operationIdField) {
        this.operationIdField = operationIdField;
    }

    public JTextField getBudgetNameFieldtOperation() {
        return budgetNameFieldtOperation;
    }

    public void setBudgetNameFieldtOperation(JTextField budgetNameFieldtOperation) {
        this.budgetNameFieldtOperation = budgetNameFieldtOperation;
    }

    public JTextField getOperationAmountField() {
        return operationAmountField;
    }

    public void setOperationAmountField(JTextField operationAmountField) {
        this.operationAmountField = operationAmountField;
    }

    public DateChooserCombo getOperationDateTransaction() {
        return operationDateTransaction;
    }

    public void setOperationDateTransaction(DateChooserCombo operationDateTransaction) {
        this.operationDateTransaction = operationDateTransaction;
    }

    public JTextField getOperationNotesField() {
        return operationNotesField;
    }

    public void setOperationNotesField(JTextField operationNotesField) {
        this.operationNotesField = operationNotesField;
    }

    public JTextField getOperationTypeField() {
        return operationTypeField;
    }

    public void setOperationTypeField(JTextField operationTypeField) {
        this.operationTypeField = operationTypeField;
    }

    public Operation getOperation() {
        if (operation == null) {
            return new Operation();
        }
        return operation;
    }

    public void initOperation() {
        if (operation == null) {
            operation = new Operation();
        }
        isOk = false;
        budgetNameFieldtOperation.setText(operation.getBudgetName());
        jComboBox1.setSelectedItem(operation.getBudgetCurrency());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(operation.getOperationDate());
        operationDateTransaction.setSelectedDate(calendar);
        operationTypeField.setText(operation.getOperationType());
        operationNotesField.setText(operation.getNotes());
        operationAmountField.setText(operation.getAmount().toString());
        operationIdField.setText(Integer.toString(operation.getIdOperation()));
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        budgetNameFieldtOperation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        operationDateTransaction = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        operationTypeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        operationNotesField = new javax.swing.JTextField();
        operationAmountField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        operationIdField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel1.setText("Наименования бюджета");
        budgetNameFieldtOperation.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setText("Валюты");
        operationDateTransaction.setFieldFont(new java.awt.Font("Malgun Gothic", java.awt.Font.PLAIN, 14));
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setText("Дата транзакции");
        operationTypeField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setText("Вид транзакции");
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setText("Заметка");
        operationNotesField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        operationAmountField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel7.setText("Сумма");
        jButton1.setFont(new java.awt.Font("Malgun Gothic", 0, 13));
        jButton1.setText("Сохранить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        operationIdField.setEditable(false);
        operationIdField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel8.setText("ID");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USD", "BYN", "EUR" }));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(jLabel8).addGap(46, 46, 46).addComponent(operationIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(6, 6, 6).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jButton1).addComponent(operationDateTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel6).addComponent(jLabel5).addComponent(jLabel7).addComponent(jLabel4)).addGap(46, 46, 46).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(operationTypeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(operationNotesField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addComponent(jLabel3)).addGap(46, 46, 46).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(operationAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(budgetNameFieldtOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))).addContainerGap(26, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(159, 159, 159).addComponent(jLabel2).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(38, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operationIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(budgetNameFieldtOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel3).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(operationDateTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operationTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(operationNotesField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operationAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addGap(18, 18, 18).addComponent(jButton1).addContainerGap()));
        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(budgetNameFieldtOperation, operationTypeField, operationAmountField)) {
            if (Convertor.isDouble(operationAmountField.getText())) {
                setVisible(false);
                isOk = true;
            } else {
                JOptionPane.showMessageDialog(null, "Некоторые поля должны содержат числовые значения");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполните все поля");
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

    private javax.swing.JTextField budgetNameFieldtOperation;

    private javax.swing.JButton jButton1;

    private javax.swing.JComboBox<String> jComboBox1;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JLabel jLabel8;

    private javax.swing.JTextField operationAmountField;

    private datechooser.beans.DateChooserCombo operationDateTransaction;

    private javax.swing.JTextField operationIdField;

    private javax.swing.JTextField operationNotesField;

    private javax.swing.JTextField operationTypeField;

}
