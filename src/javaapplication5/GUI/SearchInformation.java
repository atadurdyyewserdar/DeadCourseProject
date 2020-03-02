package javaapplication5.GUI;

import java.awt.Color;
import java.math.BigDecimal;
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
import javaapplication5.Models.BudgetInformationModel;
import javaapplication5.Models.OperationInformationModel;
import javaapplication5.Models.TableColumnAdjuster;
import javaapplication5.Models.UsersInformationModel;
import javax.swing.JTextField;

public class SearchInformation extends javax.swing.JFrame {

    ClientConnection clientConnection;

    Employee employee;

    int typeOfUser;

    UsersInformationModel usersInformationModel;

    BudgetInformationModel budgetInformationModel;

    OperationInformationModel operationInformationModel;

    TableColumnAdjuster tableColumnAdjuster, tableColumnAdjuster2, tableColumnAdjuster3;

    public SearchInformation(ClientConnection clientConnection, Employee employee, int typeOfUser) {
        this.clientConnection = clientConnection;
        this.employee = employee;
        this.typeOfUser = typeOfUser;
        initComponents();
    }

    public SearchInformation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLayeredPane1 = new javax.swing.JLayeredPane();
        mainSearch = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        operationSearch = new javax.swing.JPanel();
        operationSearchField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        budgetSearch = new javax.swing.JPanel();
        budgetSearchField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userSearch = new javax.swing.JPanel();
        userSearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        jLayeredPane1.setLayout(new java.awt.CardLayout());
        mainSearch.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/search.png")));
        jLabel25.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/transaction.png")));
        jLabel25.setText("   Поиск транзакции");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel25MousePressed(evt);
            }
        });
        jLabel24.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/search_user.png")));
        jLabel24.setText("     Поиск сотрудника");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
        });
        jLabel28.setFont(new java.awt.Font("Malgun Gothic", 0, 16));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/seo.png")));
        jLabel28.setText("  Поиск бюджета");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel28MousePressed(evt);
            }
        });
        javax.swing.GroupLayout mainSearchLayout = new javax.swing.GroupLayout(mainSearch);
        mainSearch.setLayout(mainSearchLayout);
        mainSearchLayout.setHorizontalGroup(mainSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainSearchLayout.createSequentialGroup().addGap(90, 90, 90).addComponent(jLabel24).addGap(47, 47, 47).addComponent(jLabel26).addGap(0, 0, 0).addComponent(jLabel25)).addGroup(mainSearchLayout.createSequentialGroup().addGap(290, 290, 290).addComponent(jLabel28)));
        mainSearchLayout.setVerticalGroup(mainSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainSearchLayout.createSequentialGroup().addGap(90, 90, 90).addGroup(mainSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel24).addComponent(jLabel26).addComponent(jLabel25)).addGap(80, 80, 80).addComponent(jLabel28)));
        jLayeredPane1.add(mainSearch, "card2");
        operationSearch.setBackground(new java.awt.Color(255, 255, 255));
        operationSearchField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        operationSearchField.addFocusListener(new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent evt) {
                operationSearchFieldFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                operationSearchFieldFocusLost(evt);
            }
        });
        operationSearchField.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                operationSearchFieldKeyReleased(evt);
            }
        });
        ArrayList<Operation> operations = getOperation();
        operationInformationModel = new OperationInformationModel(operations);
        jTable2.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable2.getTableHeader().setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable2.setModel(operationInformationModel);
        jTable2.setGridColor(new java.awt.Color(51, 51, 51));
        jTable2.setRowHeight(20);
        jTable2.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable2.setShowHorizontalLines(false);
        tableColumnAdjuster2 = new TableColumnAdjuster(jTable2);
        tableColumnAdjuster2.adjustColumns();
        jScrollPane2.setViewportView(jTable2);
        jScrollPane2.getViewport().setBackground(new Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/back-button.png")));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 24));
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Поиск транзакции");
        javax.swing.GroupLayout operationSearchLayout = new javax.swing.GroupLayout(operationSearch);
        operationSearch.setLayout(operationSearchLayout);
        operationSearchLayout.setHorizontalGroup(operationSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, operationSearchLayout.createSequentialGroup().addComponent(jLabel3).addGap(234, 234, 234).addComponent(jLabel4).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, operationSearchLayout.createSequentialGroup().addContainerGap(256, Short.MAX_VALUE).addComponent(operationSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(182, 182, 182)).addGroup(operationSearchLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane2).addContainerGap()));
        operationSearchLayout.setVerticalGroup(operationSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(operationSearchLayout.createSequentialGroup().addGroup(operationSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(operationSearchLayout.createSequentialGroup().addComponent(jLabel3).addGap(0, 0, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, operationSearchLayout.createSequentialGroup().addGap(0, 18, Short.MAX_VALUE).addComponent(jLabel4))).addGap(18, 18, 18).addComponent(operationSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        jLayeredPane1.add(operationSearch, "card3");
        budgetSearch.setBackground(new java.awt.Color(255, 255, 255));
        budgetSearchField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        budgetSearchField.addFocusListener(new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent evt) {
                budgetSearchFieldFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                budgetSearchFieldFocusLost(evt);
            }
        });
        budgetSearchField.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                budgetSearchFieldKeyReleased(evt);
            }
        });
        ArrayList<Budget> budgets = getBudgets();
        budgetInformationModel = new BudgetInformationModel(budgets);
        jTable3.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable3.getTableHeader().setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable3.setModel(budgetInformationModel);
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setRowHeight(20);
        jTable3.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable3.setShowHorizontalLines(false);
        tableColumnAdjuster3 = new TableColumnAdjuster(jTable3);
        tableColumnAdjuster3.adjustColumns();
        jScrollPane3.setViewportView(jTable3);
        jScrollPane3.getViewport().setBackground(new Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/back-button.png")));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 24));
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Поиск бюджета");
        javax.swing.GroupLayout budgetSearchLayout = new javax.swing.GroupLayout(budgetSearch);
        budgetSearch.setLayout(budgetSearchLayout);
        budgetSearchLayout.setHorizontalGroup(budgetSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(budgetSearchLayout.createSequentialGroup().addContainerGap(248, Short.MAX_VALUE).addComponent(budgetSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(190, 190, 190)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, budgetSearchLayout.createSequentialGroup().addComponent(jLabel5).addGap(270, 270, 270).addComponent(jLabel6).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(budgetSearchLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3).addContainerGap()));
        budgetSearchLayout.setVerticalGroup(budgetSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(budgetSearchLayout.createSequentialGroup().addGroup(budgetSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(budgetSearchLayout.createSequentialGroup().addComponent(jLabel5).addGap(0, 0, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, budgetSearchLayout.createSequentialGroup().addGap(0, 18, Short.MAX_VALUE).addComponent(jLabel6))).addGap(18, 18, 18).addComponent(budgetSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jLayeredPane1.add(budgetSearch, "card3");
        userSearch.setBackground(new java.awt.Color(255, 255, 255));
        userSearchField.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        userSearchField.addFocusListener(new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent evt) {
                userSearchFieldFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                userSearchFieldFocusLost(evt);
            }
        });
        userSearchField.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                userSearchFieldKeyReleased(evt);
            }
        });
        ArrayList<Employee> employe = getE();
        usersInformationModel = new UsersInformationModel(typeOfUser, employe);
        jTable1.setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable1.getTableHeader().setFont(new java.awt.Font("Malgun Gothic", 0, 14));
        jTable1.setModel(usersInformationModel);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jTable1.setShowHorizontalLines(false);
        tableColumnAdjuster = new TableColumnAdjuster(jTable1);
        tableColumnAdjuster.adjustColumns();
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/icons/back-button.png")));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Поиск сотрудников");
        javax.swing.GroupLayout userSearchLayout = new javax.swing.GroupLayout(userSearch);
        userSearch.setLayout(userSearchLayout);
        userSearchLayout.setHorizontalGroup(userSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSearchLayout.createSequentialGroup().addComponent(jLabel1).addGap(255, 255, 255).addComponent(jLabel2).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSearchLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSearchLayout.createSequentialGroup().addContainerGap(224, Short.MAX_VALUE).addComponent(userSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(214, 214, 214)));
        userSearchLayout.setVerticalGroup(userSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(userSearchLayout.createSequentialGroup().addGroup(userSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(userSearchLayout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSearchLayout.createSequentialGroup().addGap(0, 18, Short.MAX_VALUE).addComponent(jLabel2))).addGap(18, 18, 18).addComponent(userSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jLayeredPane1.add(userSearch, "card3");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLayeredPane1));
        pack();
        setLocationRelativeTo(null);
    }

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {
        mainSearch.setVisible(false);
        userSearch.setVisible(true);
    }

    private void userSearchFieldFocusGained(java.awt.event.FocusEvent evt) {
        if (userSearchField.getText().equals("начните вводит..."))
            userSearchField.setText("");
    }

    private void userSearchFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (userSearchField.getText().equals(""))
            userSearchField.setText("начните вводит...");
    }

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {
        userSearchField.setText("начните вводит...");
        usersInformationModel.clearTable();
        usersInformationModel.setArrayList(getE());
        tableColumnAdjuster.adjustColumns();
        usersInformationModel.fireTableDataChanged();
        userSearch.setVisible(false);
        mainSearch.setVisible(true);
    }

    private void userSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {
        if (!userSearchField.getText().equals("") && !userSearchField.getText().equals("начните вводит...")) {
            clientConnection.sendMessage("searching user");
            clientConnection.sendMessage(userSearchField.getText());
            clientConnection.sendMessage(employee.getRoleName());
            ArrayList<Employee> employees = (ArrayList<Employee>) clientConnection.readObject();
            System.out.println(employees);
            usersInformationModel.clearTable();
            usersInformationModel.setArrayList(employees);
            tableColumnAdjuster.adjustColumns();
            usersInformationModel.fireTableDataChanged();
        }
    }

    private void operationSearchFieldFocusGained(java.awt.event.FocusEvent evt) {
        if (operationSearchField.getText().equals("начните вводит..."))
            operationSearchField.setText("");
    }

    private void operationSearchFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (operationSearchField.getText().equals(""))
            operationSearchField.setText("начните вводит...");
    }

    private void operationSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {
        if (!operationSearchField.getText().equals("") && !operationSearchField.getText().equals("начните вводит...")) {
            clientConnection.sendMessage("searching operation");
            clientConnection.sendMessage(operationSearchField.getText());
            ArrayList<Operation> operations = (ArrayList<Operation>) clientConnection.readObject();
            System.out.println(operations);
            operationInformationModel.clearTable();
            operationInformationModel.setArrayList(operations);
            tableColumnAdjuster2.adjustColumns();
            operationInformationModel.fireTableDataChanged();
        }
    }

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {
        operationSearch.setVisible(false);
        operationSearchField.setText("начните вводит...");
        operationInformationModel.clearTable();
        operationInformationModel.setArrayList(getOperation());
        tableColumnAdjuster2.adjustColumns();
        operationInformationModel.fireTableDataChanged();
        mainSearch.setVisible(true);
    }

    private void budgetSearchFieldFocusGained(java.awt.event.FocusEvent evt) {
        if (budgetSearchField.getText().equals("начните вводит..."))
            budgetSearchField.setText("");
    }

    private void budgetSearchFieldFocusLost(java.awt.event.FocusEvent evt) {
        if (budgetSearchField.getText().equals(""))
            budgetSearchField.setText("начните вводит...");
    }

    private void budgetSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {
        if (!budgetSearchField.getText().equals("") && !budgetSearchField.getText().equals("начните вводит...")) {
            clientConnection.sendMessage("searching budget");
            clientConnection.sendMessage(budgetSearchField.getText());
            ArrayList<Budget> budgets = (ArrayList<Budget>) clientConnection.readObject();
            System.out.println(budgets);
            budgetInformationModel.clearTable();
            budgetInformationModel.setArrayList(budgets);
            tableColumnAdjuster3.adjustColumns();
            budgetInformationModel.fireTableDataChanged();
        }
    }

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {
        budgetSearch.setVisible(false);
        budgetSearchField.setText("начните вводит...");
        budgetInformationModel.clearTable();
        budgetInformationModel.setArrayList(getBudgets());
        tableColumnAdjuster3.adjustColumns();
        budgetInformationModel.fireTableDataChanged();
        mainSearch.setVisible(true);
    }

    private void jLabel25MousePressed(java.awt.event.MouseEvent evt) {
        mainSearch.setVisible(false);
        operationSearch.setVisible(true);
    }

    private void jLabel28MousePressed(java.awt.event.MouseEvent evt) {
        mainSearch.setVisible(false);
        budgetSearch.setVisible(true);
    }

    public boolean check(JTextField... jtfs) {
        for (JTextField jtf : jtfs) {
            if (jtf.getText().equals("")) {
                return false;
            }
        }
        return true;
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

    private javax.swing.JPanel budgetSearch;

    private javax.swing.JTextField budgetSearchField;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel24;

    private javax.swing.JLabel jLabel25;

    private javax.swing.JLabel jLabel26;

    private javax.swing.JLabel jLabel28;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLayeredPane jLayeredPane1;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JScrollPane jScrollPane2;

    private javax.swing.JScrollPane jScrollPane3;

    private javax.swing.JTable jTable1;

    private javax.swing.JTable jTable2;

    private javax.swing.JTable jTable3;

    private javax.swing.JPanel mainSearch;

    private javax.swing.JPanel operationSearch;

    private javax.swing.JTextField operationSearchField;

    private javax.swing.JPanel userSearch;

    private javax.swing.JTextField userSearchField;

}
