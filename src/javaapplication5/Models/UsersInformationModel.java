package javaapplication5.Models;

import java.util.ArrayList;
import javaapplication5.Classes.Employee;
import javax.swing.table.AbstractTableModel;

public class UsersInformationModel extends AbstractTableModel {

    int designType;

    ArrayList<Employee> employees;

    public UsersInformationModel(int type, ArrayList<Employee> employees) {
        super();
        this.employees = employees;
        designType = type;
    }

    public boolean isEmpty() {
        return employees.isEmpty();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (employees.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    public int getDesignType() {
        return designType;
    }

    public void setDesignType(int designType) {
        this.designType = designType;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        if (designType == 1) {
            return 9;
        } else {
            return 6;
        }
    }

    public Employee getEmployee(int index) {
        if (index >= employees.size()) {
            return new Employee();
        }
        return employees.get(index);
    }

    public void setEmployee(int index, Employee emp) {
        if (index > employees.size()) {
            return;
        }
        employees.set(index, emp);
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void deleteEmployee(int index) {
        if (index > employees.size()) {
            return;
        }
        employees.remove(index);
    }

    public ArrayList<Employee> getArrayList() {
        return this.employees;
    }

    public void clearTable() {
        employees.clear();
    }

    public void setArrayList(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (designType == 1) {
            switch(c) {
                case 0:
                    return employees.get(r).getEmployeeId();
                case 1:
                    return employees.get(r).getRoleName();
                case 2:
                    return employees.get(r).getFio();
                case 3:
                    return employees.get(r).getAddress();
                case 4:
                    return employees.get(r).getMobile();
                case 5:
                    return employees.get(r).getLogin();
                case 6:
                    return employees.get(r).getPassword();
                case 7:
                    return employees.get(r).getEmail();
                case 8:
                    return employees.get(r).isAccess();
                default:
                    return "";
            }
        } else {
            switch(c) {
                case 0:
                    return employees.get(r).getEmployeeId();
                case 1:
                    return employees.get(r).getRoleName();
                case 2:
                    return employees.get(r).getFio();
                case 3:
                    return employees.get(r).getAddress();
                case 4:
                    return employees.get(r).getMobile();
                case 5:
                    return employees.get(r).getEmail();
                default:
                    return "";
            }
        }
    }

    @Override
    public String getColumnName(int c) {
        if (designType == 1) {
            switch(c) {
                case 0:
                    return "ID";
                case 1:
                    return "Должность";
                case 2:
                    return "Ф�?О";
                case 3:
                    return "Адрес";
                case 4:
                    return "Мобильный";
                case 5:
                    return "Логин";
                case 6:
                    return "Пароль";
                case 7:
                    return "Почта";
                case 8:
                    return "Доступ";
                default:
                    return "Other";
            }
        } else {
            switch(c) {
                case 0:
                    return "ID";
                case 1:
                    return "Должность";
                case 2:
                    return "Ф�?О";
                case 3:
                    return "Адрес";
                case 4:
                    return "Мобильный";
                case 5:
                    return "Почта";
                default:
                    return "Other";
            }
        }
    }
}
