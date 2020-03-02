package javaapplication5.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication5.Classes.Employee;
import javaapplication5.Connection.DatabaseConnection;
import javaapplication5.Tables.Bud;
import javaapplication5.Tables.ConstEmployeeTable;
import javaapplication5.Tables.Oper;
import java.util.Date;
import javaapplication5.Classes.Budget;
import javaapplication5.Classes.Operation;
import org.jfree.data.general.DefaultPieDataset;

public class ClientHandler implements Runnable {

    private ObjectInputStream objectInputStream;

    private ObjectOutputStream objectOutputStream;

    protected Socket clientSocket = null;

    protected String serverText = null;

    public ClientHandler(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    public void initConnection() {
        try {
            objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("ClientHandler inputStream created");
            System.out.println("ClientHandler outputStream created");
            objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void handle() throws ClassNotFoundException {
        String string = "";
        initConnection();
        boolean work = true;
        do {
            string = readMessage();
            System.out.println("Client sent: " + string);
            switch(string) {
                case "Enter":
                    {
                        sendMessage("success");
                        break;
                    }
                case "waiting sum and fact sum":
                    {
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            BigDecimal progress = BigDecimal.ZERO;
                            BigDecimal famount = BigDecimal.ZERO;
                            String select2 = "SELECT " + quote(Bud.PAMOUNT) + "," + quote(Bud.FAMOUNT) + " FROM abcde.budget WHERE (end_date BETWEEN ? AND ?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(select2);
                            preparedStatement.setString(1, "2019-01-01");
                            preparedStatement.setString(2, "2019-12-21");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                while (rs.next()) {
                                    progress = progress.add(rs.getBigDecimal(Bud.PAMOUNT));
                                    famount = famount.add(rs.getBigDecimal(Bud.FAMOUNT));
                                    System.out.println("exists ...");
                                }
                                sendObject(progress);
                                sendObject(famount);
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "expense from budget":
                    {
                        try {
                            System.out.println("editBudgetInformatio");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Operation operation = (Operation) readObject();
                            String ss = "UPDATE " + "abcde.budget " + " SET " + quote(Bud.FAMOUNT) + " = " + quote(Bud.FAMOUNT) + " - ? " + "WHERE (" + quote(Bud.BNAME) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setBigDecimal(1, operation.getAmount());
                            preparedStatement.setString(2, operation.getBudgetName());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "profit to budget":
                    {
                        try {
                            System.out.println("editBudgetInformatio");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Operation operation = (Operation) readObject();
                            String ss = "UPDATE " + "abcde.budget " + " SET " + quote(Bud.FAMOUNT) + " = " + quote(Bud.FAMOUNT) + " + ? " + "WHERE (" + quote(Bud.BNAME) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setBigDecimal(1, operation.getAmount());
                            preparedStatement.setString(2, operation.getBudgetName());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "progress":
                    {
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            BigDecimal progress = BigDecimal.ZERO;
                            String select2 = "SELECT " + Oper.O_G_AMOUNT + " FROM abcde.operation WHERE operation_type=? AND operation_date >=?";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(select2);
                            preparedStatement.setString(1, "expense");
                            preparedStatement.setString(2, "2019-01-01");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                while (rs.next()) {
                                    progress.add(rs.getBigDecimal(Oper.O_G_AMOUNT));
                                }
                                sendObject(progress);
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "current money":
                    {
                        String select = "SELECT " + quote(Bud.FAMOUNT) + " FROM abcde.budget";
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(select);
                            System.out.println("Budgets selected");
                            BigDecimal decimal1 = BigDecimal.ZERO;
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                while (rs.next()) {
                                    decimal1 = decimal1.add(rs.getBigDecimal(Bud.FAMOUNT));
                                }
                                sendMessage(decimal1.toString());
                                System.out.println(decimal1.toString() + " was sent");
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "current budget money":
                    {
                        String select = "SELECT " + quote(Bud.FAMOUNT) + " FROM abcde.budget";
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(select);
                            System.out.println("Budgets selected");
                            BigDecimal decimal1 = BigDecimal.ZERO;
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                while (rs.next()) {
                                    decimal1 = decimal1.add(rs.getBigDecimal(Bud.FAMOUNT));
                                }
                                sendMessage(decimal1.toString());
                                System.out.println(decimal1.toString() + " was sent");
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "operations":
                    {
                        String select = "SELECT * FROM abcde.operation";
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(select);
                            System.out.println("Operations Selected");
                            int idOperation;
                            String budgetName, send, operationType, notes, currenc;
                            Date date1;
                            BigDecimal decimal;
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                while (rs.next()) {
                                    idOperation = rs.getInt(Oper.O_A_ID);
                                    budgetName = rs.getString(Oper.O_B_BUDGETNAME);
                                    currenc = rs.getString(Oper.O_C_CURRENCY);
                                    date1 = rs.getDate(Oper.O_D_DATE);
                                    operationType = rs.getString(Oper.O_E_TYPE);
                                    notes = rs.getString(Oper.O_F_NOTES);
                                    decimal = rs.getBigDecimal(Oper.O_G_AMOUNT);
                                    send = Integer.toString(idOperation) + "XxX" + budgetName + "XxX" + currenc + "XxX" + new SimpleDateFormat("yyyy-MM-dd").format(date1) + "XxX" + operationType + "XxX" + notes + "XxX" + decimal.toString();
                                    sendMessage(send);
                                    System.out.println("send: " + send);
                                }
                                sendMessage("over");
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "searching budget":
                    {
                        String search = readMessage();
                        System.out.println(search);
                        String ss = "SELECT * FROM abcde.budget WHERE " + quote(Bud.BNAME) + " LIKE ?";
                        System.out.println("SQL command : " + ss);
                        try {
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, "%" + search + "%");
                            System.out.println("budget search");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                ArrayList<Budget> budgets = new ArrayList();
                                while (rs.next()) {
                                    budgets.add(new Budget(rs.getString(Bud.BNAME), rs.getString(Bud.CURRENCY), rs.getBigDecimal(Bud.FAMOUNT), rs.getBigDecimal(Bud.PAMOUNT), rs.getBoolean(Bud.ISACTIVE), rs.getDate(Bud.SDATE), rs.getDate(Bud.EDATE), rs.getInt(Bud.EMPLOYEE)));
                                }
                                sendObject(budgets);
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "searching operation":
                    {
                        String search = readMessage();
                        System.out.println(search);
                        String ss = "SELECT * FROM abcde.operation WHERE " + quote(Oper.O_B_BUDGETNAME) + " LIKE ?";
                        System.out.println("SQL command : " + ss);
                        try {
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, "%" + search + "%");
                            System.out.println("operation search");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                ArrayList<Operation> operations = new ArrayList();
                                while (rs.next()) {
                                    operations.add(new Operation(rs.getInt(Oper.O_A_ID), rs.getString(Oper.O_B_BUDGETNAME), rs.getString(Oper.O_C_CURRENCY), rs.getDate(Oper.O_D_DATE), rs.getString(Oper.O_E_TYPE), rs.getString(Oper.O_F_NOTES), rs.getBigDecimal(Oper.O_G_AMOUNT)));
                                }
                                sendObject(operations);
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "searching user":
                    {
                        String search = readMessage();
                        System.out.println(search);
                        String type = readMessage();
                        String ss;
                        if (type.equals("admin")) {
                            ss = "SELECT * FROM abcde.employee WHERE " + quote(ConstEmployeeTable.EMPLOYEE_FIO) + " LIKE ?";
                        } else {
                            ss = "SELECT " + quote(ConstEmployeeTable.EMPLOYEE_ID) + ", " + quote(ConstEmployeeTable.EMPLOYEE_ROLE_NAME) + ", " + quote(ConstEmployeeTable.EMPLOYEE_FIO) + ", " + quote(ConstEmployeeTable.EMPLOYEE_ADDRESS) + ", " + quote(ConstEmployeeTable.EMPLOYEE_MOBILE) + ", " + quote(ConstEmployeeTable.EMPLOYEE_EMAIL) + " FROM " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME + " WHERE " + quote(ConstEmployeeTable.EMPLOYEE_FIO) + " LIKE ?";
                        }
                        System.out.println("SQL command : " + ss);
                        try {
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, "%" + search + "%");
                            System.out.println("users search");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                ArrayList<Employee> employees = new ArrayList();
                                while (rs.next()) {
                                    if (type.equals("admin")) {
                                        employees.add(new Employee(rs.getInt(ConstEmployeeTable.EMPLOYEE_ID), rs.getString(ConstEmployeeTable.EMPLOYEE_FIO), rs.getString(ConstEmployeeTable.EMPLOYEE_FIO), rs.getString(ConstEmployeeTable.EMPLOYEE_ADDRESS), rs.getString(ConstEmployeeTable.EMPLOYEE_MOBILE), rs.getString(ConstEmployeeTable.EMPLOYEE_LOGIN), rs.getString(ConstEmployeeTable.EMPLOYEE_PASSWORD), rs.getString(ConstEmployeeTable.EMPLOYEE_EMAIL), rs.getBoolean(ConstEmployeeTable.EMPLOYEE_ACCESS)));
                                    } else {
                                        employees.add(new Employee(rs.getInt(ConstEmployeeTable.EMPLOYEE_ID), rs.getString(ConstEmployeeTable.EMPLOYEE_FIO), rs.getString(ConstEmployeeTable.EMPLOYEE_FIO), rs.getString(ConstEmployeeTable.EMPLOYEE_ADDRESS), rs.getString(ConstEmployeeTable.EMPLOYEE_MOBILE), rs.getString(ConstEmployeeTable.EMPLOYEE_EMAIL)));
                                    }
                                }
                                sendObject(employees);
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "budgets":
                    {
                        String select = "SELECT * FROM abcde.budget";
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(select);
                            System.out.println("Budgets selected");
                            String budgetName, send, currencyId;
                            Date date1, date2;
                            BigDecimal decimal1, decimal2;
                            boolean isActive;
                            int id;
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                while (rs.next()) {
                                    budgetName = rs.getString(Bud.BNAME);
                                    currencyId = rs.getString(Bud.CURRENCY);
                                    decimal1 = rs.getBigDecimal(Bud.FAMOUNT);
                                    decimal2 = rs.getBigDecimal(Bud.PAMOUNT);
                                    isActive = rs.getBoolean(Bud.ISACTIVE);
                                    date1 = rs.getDate(Bud.SDATE);
                                    date2 = rs.getDate(Bud.EDATE);
                                    System.out.println(date1.toString());
                                    System.out.println(date2.toString());
                                    id = rs.getInt(Bud.EMPLOYEE);
                                    send = budgetName + "XxX" + currencyId + "XxX" + decimal1.toString() + "XxX" + decimal2.toString() + "XxX" + Boolean.toString(isActive) + "XxX" + simpleDateFormat.format(date1) + "XxX" + simpleDateFormat.format(date2) + "XxX" + Integer.toString(id);
                                    System.out.println("send");
                                    sendMessage(send);
                                }
                                sendMessage("over");
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case "auth":
                    {
                        String ss = "SELECT * FROM " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME + " WHERE " + ConstEmployeeTable.EMPLOYEE_LOGIN + "=? AND " + ConstEmployeeTable.EMPLOYEE_PASSWORD + "=?";
                        String[] line = readMessage().split("XxX");
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        System.out.println("Connection auth");
                        try {
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, line[0]);
                            preparedStatement.setString(2, line[1]);
                            System.out.println("Statement auth");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                Employee employee = new Employee();
                                int c = 0;
                                while (rs.next()) {
                                    employee.setEmployeeId(rs.getInt(ConstEmployeeTable.EMPLOYEE_ID));
                                    employee.setRoleName(rs.getString(ConstEmployeeTable.EMPLOYEE_ROLE_NAME));
                                    employee.setFio(rs.getString(ConstEmployeeTable.EMPLOYEE_FIO));
                                    employee.setAddress(rs.getString(ConstEmployeeTable.EMPLOYEE_ADDRESS));
                                    employee.setMobile(rs.getString(ConstEmployeeTable.EMPLOYEE_MOBILE));
                                    employee.setLogin(line[0]);
                                    employee.setPassword(line[1]);
                                    employee.setEmail(rs.getString(ConstEmployeeTable.EMPLOYEE_EMAIL));
                                    employee.setAccess(rs.getBoolean(ConstEmployeeTable.EMPLOYEE_ACCESS));
                                    c++;
                                }
                                if (c > 0 && employee.isAccess() == true) {
                                    System.out.println("Client validated");
                                    sendMessage("success");
                                    System.out.println("sending employee" + employee);
                                    sendObject(employee);
                                } else if (c > 0 && employee.isAccess() == false) {
                                    System.out.println("Client not validated");
                                    sendMessage("denied");
                                } else {
                                    System.out.println("Client not validated");
                                    sendMessage("wrong");
                                }
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                        }
                        break;
                    }
                case "delete operation":
                    {
                        try {
                            System.out.println("delete budget");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Operation operation = (Operation) readObject();
                            System.out.println("deleting:" + operation);
                            String ss = "DELETE FROM abcde.operation WHERE (" + quote(Oper.O_A_ID) + " =?) " + "and (" + quote(Oper.O_B_BUDGETNAME) + " =?)" + "and (" + quote(Oper.O_C_CURRENCY) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setInt(1, operation.getIdOperation());
                            preparedStatement.setString(2, operation.getBudgetName());
                            preparedStatement.setString(3, operation.getBudgetCurrency());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was deleted");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "add operation":
                    {
                        try {
                            System.out.println("add operation");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Operation op = (Operation) readObject();
                            System.out.println("inserting:" + op);
                            String ss = "INSERT INTO abcde.operation (" + quote(Oper.O_B_BUDGETNAME) + "," + quote(Oper.O_C_CURRENCY) + "," + quote(Oper.O_D_DATE) + "," + quote(Oper.O_E_TYPE) + "," + quote(Oper.O_F_NOTES) + "," + quote(Oper.O_G_AMOUNT) + ") VALUES (?,?,?,?,?,?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss, Statement.RETURN_GENERATED_KEYS);
                            System.out.println("prepared  ");
                            preparedStatement.setString(1, op.getBudgetName());
                            preparedStatement.setString(2, op.getBudgetCurrency());
                            preparedStatement.setDate(3, new java.sql.Date(op.getOperationDate().getTime()));
                            preparedStatement.setString(4, op.getOperationType());
                            preparedStatement.setString(5, op.getNotes());
                            preparedStatement.setBigDecimal(6, op.getAmount());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                                    if (rs.next()) {
                                        op.setIdOperation((int) rs.getLong(1));
                                    }
                                    sendMessage("success");
                                    sendMessage(Integer.toString(op.getIdOperation()));
                                }
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "edit operation":
                    {
                        try {
                            System.out.println("edit operation ");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Operation operation = (Operation) readObject();
                            System.out.println("updating:" + operation);
                            String ss = "UPDATE " + "abcde.operation " + " SET " + quote(Oper.O_B_BUDGETNAME) + " =?, " + quote(Oper.O_C_CURRENCY) + " =?, " + quote(Oper.O_D_DATE) + " =?, " + quote(Oper.O_E_TYPE) + " =?, " + quote(Oper.O_F_NOTES) + " =?, " + quote(Oper.O_G_AMOUNT) + " =? " + "WHERE (" + quote(Oper.O_A_ID) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setString(1, operation.getBudgetName());
                            preparedStatement.setString(2, operation.getBudgetCurrency());
                            preparedStatement.setDate(3, new java.sql.Date(operation.getOperationDate().getTime()));
                            preparedStatement.setString(4, operation.getOperationType());
                            preparedStatement.setString(5, operation.getNotes());
                            preparedStatement.setBigDecimal(6, operation.getAmount());
                            preparedStatement.setInt(7, operation.getIdOperation());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "delete budget":
                    {
                        try {
                            System.out.println("delete budget");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Budget budget = (Budget) readObject();
                            System.out.println("deleting:" + budget);
                            String ss = "DELETE FROM abcde.budget WHERE (" + quote(Bud.BNAME) + " =?) " + "and (" + quote(Bud.CURRENCY) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setString(1, budget.getBudgetName());
                            preparedStatement.setString(2, budget.getCurrencyId());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was deleted");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "check user login":
                    {
                        try {
                            PreparedStatement preparedStatement;
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.out.println("checking user login");
                            String tempBudName = readMessage();
                            String check = "SELECT " + ConstEmployeeTable.EMPLOYEE_LOGIN + " FROM abcde.employee WHERE " + ConstEmployeeTable.EMPLOYEE_LOGIN + " =?";
                            preparedStatement = databaseConnection.getconnection().prepareStatement(check);
                            preparedStatement.setString(1, tempBudName);
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                int counter = 0;
                                while (rs.next()) {
                                    counter++;
                                }
                                if (counter > 0) {
                                    sendMessage("exists");
                                } else {
                                    sendMessage("valid");
                                }
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "check budget name":
                    {
                        try {
                            PreparedStatement preparedStatement;
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.out.println("checking budget name");
                            String tempBudName = readMessage();
                            String check = "SELECT " + Bud.BNAME + " FROM abcde.budget WHERE " + Bud.BNAME + " =?";
                            preparedStatement = databaseConnection.getconnection().prepareStatement(check);
                            preparedStatement.setString(1, tempBudName);
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                int counter = 0;
                                while (rs.next()) {
                                    counter++;
                                }
                                if (counter > 0) {
                                    sendMessage("exists");
                                } else {
                                    sendMessage("valid");
                                }
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "add new budget":
                    {
                        try {
                            PreparedStatement preparedStatement;
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.out.println("checking budget name");
                            String tempBudName = readMessage();
                            String check = "SELECT " + Bud.BNAME + " FROM abcde.budget WHERE " + Bud.BNAME + " =?";
                            preparedStatement = databaseConnection.getconnection().prepareStatement(check);
                            preparedStatement.setString(1, tempBudName);
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                int counter = 0;
                                while (rs.next()) {
                                    counter++;
                                }
                                if (counter > 0) {
                                    sendMessage("exists");
                                } else {
                                    sendMessage("valid");
                                    System.out.println("add budget");
                                    Budget budget = (Budget) readObject();
                                    System.out.println("inserting:" + budget);
                                    String ss = "INSERT INTO abcde.budget " + " VALUES (?,?,?,?,?,?,?,?)";
                                    preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                                    System.out.println("prepared  ");
                                    preparedStatement.setString(1, budget.getBudgetName());
                                    preparedStatement.setString(2, budget.getCurrencyId());
                                    preparedStatement.setBigDecimal(3, budget.getFactAmount());
                                    preparedStatement.setBigDecimal(4, budget.getPlanAmount());
                                    preparedStatement.setBoolean(5, budget.isIsActive());
                                    preparedStatement.setDate(6, new java.sql.Date(budget.getStartDate().getTime()));
                                    preparedStatement.setDate(7, new java.sql.Date(budget.getEndDate().getTime()));
                                    preparedStatement.setInt(8, budget.getEmployeeId());
                                    int rows = preparedStatement.executeUpdate();
                                    System.out.println(rows + " was updated");
                                    if (rows > 0) {
                                        sendMessage("success");
                                    } else {
                                        sendMessage("error");
                                    }
                                }
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "edit budget information":
                    {
                        try {
                            System.out.println("editBudgetInformatio");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            String[] line = readMessage().split("XxX");
                            System.out.println("inserting:" + Arrays.toString(line));
                            String ss = "UPDATE " + "abcde.budget " + " SET " + quote(Bud.BNAME) + " =?, " + quote(Bud.CURRENCY) + " =?, " + quote(Bud.FAMOUNT) + " =?, " + quote(Bud.PAMOUNT) + " =?, " + quote(Bud.ISACTIVE) + " =?, " + quote(Bud.SDATE) + " =?, " + quote(Bud.EDATE) + " =?, " + quote(Bud.EMPLOYEE) + " =? " + "WHERE (" + quote(Bud.BNAME) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setString(1, line[0]);
                            preparedStatement.setString(2, line[1]);
                            preparedStatement.setBigDecimal(3, new BigDecimal(line[2]));
                            preparedStatement.setBigDecimal(4, new BigDecimal(line[3]));
                            preparedStatement.setBoolean(5, Boolean.parseBoolean(line[4]));
                            preparedStatement.setDate(6, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(line[5]).getTime()));
                            preparedStatement.setDate(7, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(line[6]).getTime()));
                            preparedStatement.setInt(8, Integer.parseInt(line[7]));
                            preparedStatement.setString(9, line[8].trim());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException | ParseException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "update user information":
                    {
                        try {
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            Employee employee = (Employee) readObject();
                            System.out.println("inserting:" + employee);
                            String ss = "UPDATE " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME + " SET " + quote(ConstEmployeeTable.EMPLOYEE_FIO) + " =?, " + quote(ConstEmployeeTable.EMPLOYEE_ADDRESS) + " =?, " + quote(ConstEmployeeTable.EMPLOYEE_MOBILE) + " =?, " + quote(ConstEmployeeTable.EMPLOYEE_LOGIN) + " =?, " + quote(ConstEmployeeTable.EMPLOYEE_PASSWORD) + " =?, " + quote(ConstEmployeeTable.EMPLOYEE_EMAIL) + " =? " + "WHERE (" + quote(ConstEmployeeTable.EMPLOYEE_ID) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, employee.getFio());
                            preparedStatement.setString(2, employee.getAddress());
                            preparedStatement.setString(3, employee.getMobile());
                            preparedStatement.setString(4, employee.getLogin());
                            preparedStatement.setString(5, employee.getPassword());
                            preparedStatement.setString(6, employee.getEmail());
                            preparedStatement.setInt(7, employee.getEmployeeId());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "close":
                    {
                        work = false;
                        break;
                    }
                case "add user":
                    {
                        try {
                            System.out.println("add user");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Employee em = (Employee) readObject();
                            System.out.println("inserting:" + em);
                            String ss = "INSERT INTO abcde.employee (" + quote(ConstEmployeeTable.EMPLOYEE_ROLE_NAME) + "," + quote(ConstEmployeeTable.EMPLOYEE_FIO) + "," + quote(ConstEmployeeTable.EMPLOYEE_ADDRESS) + "," + quote(ConstEmployeeTable.EMPLOYEE_MOBILE) + "," + quote(ConstEmployeeTable.EMPLOYEE_LOGIN) + "," + quote(ConstEmployeeTable.EMPLOYEE_PASSWORD) + "," + quote(ConstEmployeeTable.EMPLOYEE_EMAIL) + "," + quote(ConstEmployeeTable.EMPLOYEE_ACCESS) + ") VALUES (?,?,?,?,?,?,?,?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss, Statement.RETURN_GENERATED_KEYS);
                            System.out.println("prepared  ");
                            preparedStatement.setString(1, em.getRoleName());
                            preparedStatement.setString(2, em.getFio());
                            preparedStatement.setString(3, em.getAddress());
                            preparedStatement.setString(4, em.getMobile());
                            preparedStatement.setString(5, em.getLogin());
                            preparedStatement.setString(6, em.getPassword());
                            preparedStatement.setString(7, em.getEmail());
                            preparedStatement.setBoolean(8, em.isAccess());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was updated");
                            if (rows > 0) {
                                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                                    if (rs.next()) {
                                        em.setEmployeeId((int) rs.getLong(1));
                                    }
                                    sendMessage("success");
                                    sendMessage(Integer.toString(em.getEmployeeId()));
                                }
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "delete user":
                    {
                        try {
                            System.out.println("delete user");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            System.err.println("Connection");
                            Employee em = (Employee) readObject();
                            System.out.println("deleting:" + em);
                            String ss = "DELETE FROM abcde.employee WHERE (" + quote(ConstEmployeeTable.EMPLOYEE_ID) + " =?) " + "and (" + quote(ConstEmployeeTable.EMPLOYEE_ROLE_NAME) + " =?)";
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            System.out.println("prepared  ");
                            preparedStatement.setInt(1, em.getEmployeeId());
                            preparedStatement.setString(2, em.getRoleName());
                            int rows = preparedStatement.executeUpdate();
                            System.out.println(rows + " was deleted");
                            if (rows > 0) {
                                sendMessage("success");
                            } else {
                                sendMessage("error");
                            }
                            break;
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                case "profile":
                    {
                        System.out.println("Client: profile");
                        String ss = "SELECT * FROM " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME + " WHERE " + ConstEmployeeTable.EMPLOYEE_LOGIN + "=? AND " + ConstEmployeeTable.EMPLOYEE_PASSWORD + "=?";
                        String[] employee = readMessage().split(" ");
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        try {
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, employee[0]);
                            preparedStatement.setString(2, employee[1]);
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                String emp = null;
                                String fio = null, address = null, email = null, role = null, mobile = null;
                                int id = -1, c = 0;
                                boolean access = false;
                                while (rs.next()) {
                                    id = rs.getInt(ConstEmployeeTable.EMPLOYEE_ID);
                                    role = rs.getString(ConstEmployeeTable.EMPLOYEE_ROLE_NAME);
                                    fio = rs.getString(ConstEmployeeTable.EMPLOYEE_FIO);
                                    address = rs.getString(ConstEmployeeTable.EMPLOYEE_ADDRESS);
                                    mobile = rs.getString(ConstEmployeeTable.EMPLOYEE_MOBILE);
                                    email = rs.getString(ConstEmployeeTable.EMPLOYEE_EMAIL);
                                    access = rs.getBoolean(ConstEmployeeTable.EMPLOYEE_ACCESS);
                                    c++;
                                }
                                if (c > 0) {
                                    emp = Integer.toString(id) + "XxX" + role + "XxX" + fio + "XxX" + address + "XxX" + mobile + "XxX" + email + "XxX" + Boolean.toString(access);
                                    System.out.println(emp);
                                    sendMessage(emp);
                                } else {
                                    System.out.println("Client not validated");
                                    sendMessage("wrong");
                                }
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                        }
                        break;
                    }
                case "reg":
                    {
                        Employee employee = (Employee) readObject();
                        System.out.println(employee);
                        PreparedStatement preparedStatement;
                        DatabaseConnection databaseConnection = new DatabaseConnection();
                        String check = "SELECT * FROM " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME + " WHERE " + ConstEmployeeTable.EMPLOYEE_LOGIN + "=? ";
                        try {
                            preparedStatement = databaseConnection.getconnection().prepareStatement(check);
                            preparedStatement.setString(1, employee.getLogin());
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                int counter = 0;
                                while (rs.next()) {
                                    counter++;
                                }
                                if (counter > 0) {
                                    System.out.println("user login exists");
                                    sendMessage("exists");
                                } else {
                                    sendMessage("valid login");
                                    String ss = "INSERT INTO " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME + "(" + ConstEmployeeTable.EMPLOYEE_LOGIN + "," + ConstEmployeeTable.EMPLOYEE_PASSWORD + "," + ConstEmployeeTable.EMPLOYEE_EMAIL + "," + ConstEmployeeTable.EMPLOYEE_ROLE_NAME + ") VALUES (?, ?, ?, ?)";
                                    try {
                                        preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                                        preparedStatement.setString(1, employee.getLogin());
                                        preparedStatement.setString(2, employee.getPassword());
                                        preparedStatement.setString(3, employee.getEmail());
                                        preparedStatement.setString(4, employee.getRoleName());
                                        int k = preparedStatement.executeUpdate();
                                        System.out.println("executed");
                                        if (k > 0) {
                                            System.out.println("1 row inserted");
                                            sendMessage("success");
                                        } else {
                                            sendMessage("abort");
                                        }
                                    } catch (ClassNotFoundException | SQLException ex) {
                                        System.out.println(ex.toString());
                                    }
                                }
                            }
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "users":
                    {
                        try {
                            String currUser = readMessage();
                            String command;
                            if (currUser.equals("admin")) {
                                command = "SELECT * FROM " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME;
                            } else {
                                command = "SELECT " + quote(ConstEmployeeTable.EMPLOYEE_ID) + ", " + quote(ConstEmployeeTable.EMPLOYEE_ROLE_NAME) + ", " + quote(ConstEmployeeTable.EMPLOYEE_FIO) + ", " + quote(ConstEmployeeTable.EMPLOYEE_ADDRESS) + ", " + quote(ConstEmployeeTable.EMPLOYEE_MOBILE) + ", " + quote(ConstEmployeeTable.EMPLOYEE_EMAIL) + " FROM " + ConstEmployeeTable.EMPLOYEE_TABLE_NAME;
                            }
                            System.out.println("SQL command: " + command);
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(command);
                            if (currUser.equals("admin")) {
                                try (ResultSet rs = preparedStatement.executeQuery()) {
                                    while (rs.next()) {
                                        String fio, address, email, role, mobile, login, password;
                                        int id;
                                        boolean access;
                                        id = rs.getInt(ConstEmployeeTable.EMPLOYEE_ID);
                                        role = rs.getString(ConstEmployeeTable.EMPLOYEE_ROLE_NAME);
                                        fio = rs.getString(ConstEmployeeTable.EMPLOYEE_FIO);
                                        address = rs.getString(ConstEmployeeTable.EMPLOYEE_ADDRESS);
                                        mobile = rs.getString(ConstEmployeeTable.EMPLOYEE_MOBILE);
                                        login = rs.getString(ConstEmployeeTable.EMPLOYEE_LOGIN);
                                        password = rs.getString(ConstEmployeeTable.EMPLOYEE_PASSWORD);
                                        email = rs.getString(ConstEmployeeTable.EMPLOYEE_EMAIL);
                                        access = rs.getBoolean(ConstEmployeeTable.EMPLOYEE_ACCESS);
                                        String emp = Integer.toString(id) + "XxX" + role + "XxX" + fio + "XxX" + address + "XxX" + mobile + "XxX" + login + "XxX" + password + "XxX" + email + "XxX" + Boolean.toString(access);
                                        sendMessage(emp);
                                    }
                                    sendMessage("over");
                                }
                            } else {
                                try (ResultSet rs = preparedStatement.executeQuery()) {
                                    while (rs.next()) {
                                        String fio, address, email, role, mobile, login, password;
                                        int id;
                                        boolean access;
                                        id = rs.getInt(ConstEmployeeTable.EMPLOYEE_ID);
                                        role = rs.getString(ConstEmployeeTable.EMPLOYEE_ROLE_NAME);
                                        fio = rs.getString(ConstEmployeeTable.EMPLOYEE_FIO);
                                        address = rs.getString(ConstEmployeeTable.EMPLOYEE_ADDRESS);
                                        mobile = rs.getString(ConstEmployeeTable.EMPLOYEE_MOBILE);
                                        email = rs.getString(ConstEmployeeTable.EMPLOYEE_EMAIL);
                                        String emp = Integer.toString(id) + "XxX" + role + "XxX" + fio + "XxX" + address + "XxX" + mobile + "XxX" + email;
                                        sendMessage(emp);
                                    }
                                    sendMessage("over");
                                }
                            }
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case "get operation statistics":
                    {
                        try {
                            String ss = "SELECT amount, operation_date FROM abcde.operation WHERE operation_date >= ?";
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            PreparedStatement preparedStatement = databaseConnection.getconnection().prepareStatement(ss);
                            preparedStatement.setString(1, "2017-01-01");
                            try (ResultSet rs = preparedStatement.executeQuery()) {
                                double sum2017 = 0, sum2018 = 0, sum12019 = 0;
                                Date date;
                                Calendar calendar = Calendar.getInstance();
                                while (rs.next()) {
                                    date = rs.getDate(Oper.O_D_DATE);
                                    calendar.setTime(date);
                                    System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
                                    switch(calendar.get(Calendar.YEAR)) {
                                        case 2017:
                                            sum2017 += Double.parseDouble(rs.getBigDecimal(Oper.O_G_AMOUNT).toString());
                                            System.out.println("Sum2017 += " + sum2017);
                                            break;
                                        case 2018:
                                            sum2018 += Double.parseDouble(rs.getBigDecimal(Oper.O_G_AMOUNT).toString());
                                            System.out.println("Sum2018 += " + sum2017);
                                            break;
                                        default:
                                            sum12019 += Double.parseDouble(rs.getBigDecimal(Oper.O_G_AMOUNT).toString());
                                            System.out.println("Sum2019 += " + sum2017);
                                            break;
                                    }
                                }
                                DefaultPieDataset pieSet = new DefaultPieDataset();
                                pieSet.setValue("2017", sum2017);
                                pieSet.setValue("2018", sum2018);
                                pieSet.setValue("2019", sum12019);
                                sendObject(pieSet);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                default:
                    {
                        System.out.println(string);
                    }
            }
        } while (work);
        close();
    }

    @Override
    public void run() {
        try {
            handle();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage(String message) {
        try {
            objectOutputStream.writeUTF(message);
            objectOutputStream.flush();
        } catch (IOException e) {
            System.out.println("ClientHandler -> sendMessage()      " + e);
            this.close();
        }
    }

    public void sendObject(Object obj) {
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (IOException ex) {
            System.out.println("WorkerRunnable -> sendObject()   " + ex);
            this.close();
        }
    }

    public Object readObject() {
        Object object = new Object();
        try {
            object = objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
            this.close();
        }
        return object;
    }

    public String readMessage() {
        String str = "";
        try {
            str = objectInputStream.readUTF();
        } catch (IOException ex) {
            System.out.println("WorkerRunnable -> readMessage()      " + ex);
            close();
        }
        return str;
    }

    public void close() {
        try {
            objectInputStream.close();
            System.out.println("objectInputStream closed");
            objectOutputStream.close();
            System.out.println("objectOutputStream closed");
            clientSocket.close();
            System.out.println("client socket closed");
        } catch (IOException e) {
            System.out.println("close()   " + e.getMessage());
        }
    }

    public String quote(String str) {
        return "`" + str + "`";
    }

    public String quote2(String str) {
        return "'" + str + "'";
    }
}
