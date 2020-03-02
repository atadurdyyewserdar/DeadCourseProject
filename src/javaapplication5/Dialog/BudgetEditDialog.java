package javaapplication5.Dialog;

import datechooser.beans.DateChooserCombo;
import java.awt.Frame;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import javaapplication5.Classes.Budget;
import javaapplication5.Classes.Convertor;
import javaapplication5.Classes.Employee;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BudgetEditDialog extends JDialog {

    public BudgetEditDialog() {
        initComponents();
    }

    boolean isOk = false;

    Budget budget = null;

    public boolean isIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public BudgetEditDialog(Frame owFrame, boolean modal) {
        super(owFrame, modal);
        initComponents();
    }

    public void setBudget(Budget budget) {
        System.out.println("BudgetEditDialog - setBUdget");
        this.budget = budget;
    }

    public void initBudget() {
        if (budget != null) {
            isOk = false;
            budgetNameField.setText(budget.getBudgetName());
            jComboBox1.setSelectedItem(budget.getCurrencyId());
            factAmountField.setText(budget.getFactAmount().toString());
            budgetPlanAmount.setText(budget.getPlanAmount().toString());
            if (budget.isIsActive()) {
                buttonGroup1.setSelected(jRadioButton1.getModel(), true);
            } else {
                buttonGroup1.setSelected(jRadioButton2.getModel(), true);
            }
            Calendar clCalendar = Calendar.getInstance();
            clCalendar.setTime(budget.getStartDate());
            startBudgetDate.setSelectedDate(clCalendar);
            clCalendar.setTime(budget.getEndDate());
            endBudgetDate.setSelectedDate(clCalendar);
            idClientFieldBudget.setText(Integer.toString(budget.getEmployeeId()));
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        endBudgetDate = new datechooser.beans.DateChooserCombo();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        budgetPlanAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        factAmountField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        budgetNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startBudgetDate = new datechooser.beans.DateChooserCombo();
        jButton1 = new javax.swing.JButton();
        idClientFieldBudget = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel8.setText("ID клиента");
        endBudgetDate.setNothingAllowed(false);
        endBudgetDate.setFieldFont(new java.awt.Font("Malgun Gothic", java.awt.Font.PLAIN, 14));
        jRadioButton1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jRadioButton1.setText("Активнен");
        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel7.setText("Дата окончания");
        budgetPlanAmount.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel4.setText("Бюджетный план");
        jRadioButton2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jRadioButton2.setText("Не активен");
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel1.setText("Наименования бюджета");
        factAmountField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel5.setText("Состояния");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USD", "BYN", "EUR" }));
        budgetNameField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel3.setText("Фактическая сумма");
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel2.setText("Валюты");
        startBudgetDate.setNothingAllowed(false);
        startBudgetDate.setFieldFont(new java.awt.Font("Malgun Gothic", java.awt.Font.PLAIN, 14));
        jButton1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jButton1.setText("Сохранить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        idClientFieldBudget.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jLabel6.setText("Дата началы");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel7).addComponent(jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(factAmountField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(budgetPlanAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jRadioButton1).addGap(18, 18, 18).addComponent(jRadioButton2).addGap(18, 18, 18)).addComponent(startBudgetDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(endBudgetDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(idClientFieldBudget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jButton1)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE).addComponent(budgetNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(budgetNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1)).addGap(8, 8, 8).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(33, 33, 33)).addGroup(layout.createSequentialGroup().addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(factAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel3)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(budgetPlanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jRadioButton1).addComponent(jRadioButton2).addComponent(jLabel5)).addGap(18, 18, 18).addComponent(startBudgetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jLabel6)).addGap(18, 18, 18).addComponent(endBudgetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jLabel7)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(idClientFieldBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel8)).addGap(18, 57, Short.MAX_VALUE).addComponent(jButton1).addGap(24, 24, 24)));
        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (check(budgetNameField, factAmountField, budgetPlanAmount, idClientFieldBudget)) {
            if (Convertor.isDouble(factAmountField.getText().trim()) && Convertor.isDouble(budgetPlanAmount.getText().trim()) && Convertor.isInteger(idClientFieldBudget.getText())) {
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

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JTextField getBudgetNameField() {
        return budgetNameField;
    }

    public void setBudgetNameField(JTextField budgetNameField) {
        this.budgetNameField = budgetNameField;
    }

    public JTextField getBudgetPlanAmount() {
        return budgetPlanAmount;
    }

    public void setBudgetPlanAmount(JTextField budgetPlanAmount) {
        this.budgetPlanAmount = budgetPlanAmount;
    }

    public boolean getIsActiveField() {
        return jRadioButton1.isSelected();
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public DateChooserCombo getEndBudgetDate() {
        return endBudgetDate;
    }

    public void setEndBudgetDate(DateChooserCombo endBudgetDate) {
        this.endBudgetDate = endBudgetDate;
    }

    public JTextField getFactAmountField() {
        return factAmountField;
    }

    public void setFactAmountField(JTextField factAmountField) {
        this.factAmountField = factAmountField;
    }

    public JTextField getIdClientFieldBudget() {
        return idClientFieldBudget;
    }

    public void setIdClientFieldBudget(JTextField idClientFieldBudget) {
        this.idClientFieldBudget = idClientFieldBudget;
    }

    public DateChooserCombo getStartBudgetDate() {
        return startBudgetDate;
    }

    public void setStartBudgetDate(DateChooserCombo startBudgetDate) {
        this.startBudgetDate = startBudgetDate;
    }

    private javax.swing.JTextField budgetNameField;

    private javax.swing.JTextField budgetPlanAmount;

    private javax.swing.ButtonGroup buttonGroup1;

    private datechooser.beans.DateChooserCombo endBudgetDate;

    private javax.swing.JTextField factAmountField;

    private javax.swing.JTextField idClientFieldBudget;

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

    private javax.swing.JRadioButton jRadioButton1;

    private javax.swing.JRadioButton jRadioButton2;

    private datechooser.beans.DateChooserCombo startBudgetDate;

}
