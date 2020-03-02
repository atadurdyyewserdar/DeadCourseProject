package javaapplication5.Classes;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Operation implements Serializable {

    private int idOperation;

    private String budgetName;

    private String budgetCurrency;

    private Date operationDate;

    private String operationType;

    private String notes;

    private BigDecimal amount;

    @Override
    public String toString() {
        return "[" + Integer.toString(idOperation) + ",  " + budgetName + ", " + budgetCurrency + ", " + new SimpleDateFormat("yyyy-MM-dd").format(operationDate) + ", " + operationType + ", " + notes + ", " + amount.toString();
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getBudgetCurrency() {
        return budgetCurrency;
    }

    public void setBudgetCurrency(String budgetCurrency) {
        this.budgetCurrency = budgetCurrency;
    }

    public Operation(int idOperation, String budgetName, String budgetCurrency, Date operationDate, String operationType, String notes, BigDecimal amount) {
        this.idOperation = idOperation;
        this.budgetName = budgetName;
        this.budgetCurrency = budgetCurrency;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.notes = notes;
        this.amount = amount;
    }

    public Operation() {
        this.idOperation = 0;
        this.operationDate = Calendar.getInstance().getTime();
        this.operationType = "";
        this.notes = "";
        this.amount = BigDecimal.ZERO;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
