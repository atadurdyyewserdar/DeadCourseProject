package javaapplication5.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import javaapplication5.Classes.Budget;
import javax.swing.table.AbstractTableModel;

public class BudgetInformationModel extends AbstractTableModel {

    ArrayList<Budget> budList;

    public BudgetInformationModel(ArrayList<Budget> budgets) {
        super();
        this.budList = budgets;
    }

    @Override
    public int getRowCount() {
        return budList.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (budList.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    public void setBudget(int row, Budget budget) {
        budList.set(row, budget);
    }

    public Budget getBudget(int index) {
        if (index >= budList.size()) {
            return new Budget();
        }
        return budList.get(index);
    }

    public void addBudget(Budget budget) {
        budList.add(budget);
    }

    public void deleteBudget(int index) {
        budList.remove(index);
    }

    public ArrayList<Budget> getBudList() {
        return budList;
    }

    public boolean isEmpty() {
        return budList.isEmpty();
    }

    public void setBudList(ArrayList<Budget> budList) {
        this.budList = budList;
    }

    public void setCurrency(String from, String to) {
        if (from.equals("USD") && to.equals("BYN")) {
            for (Budget budget : budList) {
                budget.setCurrencyId("BYN");
                budget.setFactAmount(budget.getFactAmount().multiply(new BigDecimal("2.09")));
                budget.setPlanAmount(budget.getPlanAmount().multiply(new BigDecimal("2.09")));
            }
        } else if (from.equals("BYN") && to.equals("USD")) {
            for (Budget budget : budList) {
                budget.setCurrencyId("USD");
                budget.setFactAmount(budget.getFactAmount().divide(new BigDecimal("2.09")));
                budget.setPlanAmount(budget.getPlanAmount().divide(new BigDecimal("2.09")));
            }
        } else if (from.equals("EUR") && to.equals("USD")) {
            for (Budget budget : budList) {
                budget.setCurrencyId("USD");
                budget.setFactAmount(budget.getFactAmount().divide(new BigDecimal("2.09")));
                budget.setPlanAmount(budget.getPlanAmount().divide(new BigDecimal("2.09")));
            }
        }
    }

    public void clearTable() {
        budList.clear();
    }

    public void setArrayList(ArrayList<Budget> budgets) {
        budList = budgets;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c) {
            case 0:
                return budList.get(r).getBudgetName();
            case 1:
                return budList.get(r).getCurrencyId();
            case 2:
                return budList.get(r).getFactAmount();
            case 3:
                return budList.get(r).getPlanAmount();
            case 4:
                return budList.get(r).isIsActive();
            case 5:
                return budList.get(r).getStartDate();
            case 6:
                return budList.get(r).getEndDate();
            case 7:
                return budList.get(r).getEmployeeId();
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
                return "Валюта";
            case 2:
                return "Фактическая сумма";
            case 3:
                return "План";
            case 4:
                return "Активен";
            case 5:
                return "Дата начало";
            case 6:
                return "Дата окончания";
            case 7:
                return "ID сотрудника";
            default:
                return "Other";
        }
    }
}
