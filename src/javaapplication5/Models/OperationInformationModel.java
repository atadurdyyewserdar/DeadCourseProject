package javaapplication5.Models;

import java.util.ArrayList;
import javaapplication5.Classes.Operation;
import javax.swing.table.AbstractTableModel;

public class OperationInformationModel extends AbstractTableModel {

    ArrayList<Operation> operations;

    public OperationInformationModel(ArrayList<Operation> budgets) {
        super();
        this.operations = budgets;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (operations.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public int getRowCount() {
        return operations.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public Operation getOperation(int index) {
        if (index >= operations.size()) {
            return new Operation();
        }
        return operations.get(index);
    }

    public void deleteOperation(int index) {
        operations.remove(index);
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void setValue(int index, Operation operation) {
        operations.set(index, operation);
    }

    public void setArrayList(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public ArrayList<Operation> getArrayList() {
        return operations;
    }

    public boolean isEmpty() {
        return operations.isEmpty();
    }

    public void clearTable() {
        operations.clear();
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c) {
            case 0:
                return operations.get(r).getIdOperation();
            case 1:
                return operations.get(r).getBudgetName();
            case 2:
                return operations.get(r).getBudgetCurrency();
            case 3:
                return operations.get(r).getOperationDate();
            case 4:
                return operations.get(r).getOperationType();
            case 5:
                return operations.get(r).getAmount();
            case 6:
                return operations.get(r).getNotes();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int c) {
        switch(c) {
            case 0:
                return "ID";
            case 1:
                return "Наименования бюджета";
            case 2:
                return "Валюта";
            case 3:
                return "Дата операции";
            case 4:
                return "Вид операции";
            case 5:
                return "Сумма";
            case 6:
                return "Заметки";
            default:
                return "Other";
        }
    }
}
