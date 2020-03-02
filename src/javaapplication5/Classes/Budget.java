package javaapplication5.Classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Budget implements Serializable {

    private String budgetName;

    private String currencyId;

    private BigDecimal factAmount;

    private BigDecimal planAmount;

    private boolean isActive;

    private Date startDate;

    private Date endDate;

    private int employeeId;

    @Override
    public String toString() {
        return budgetName + "  " + currencyId + "  " + factAmount.toString() + "  " + planAmount.toString() + "  " + Boolean.toString(isActive) + "  " + new SimpleDateFormat("yyyy-MM-dd").format(startDate) + "  " + new SimpleDateFormat("yyyy-MM-dd").format(endDate) + "  " + Integer.toString(employeeId);
    }

    public Budget() {
        budgetName = "";
        currencyId = "";
        factAmount = BigDecimal.ZERO;
        planAmount = BigDecimal.ZERO;
        isActive = false;
        startDate = null;
        endDate = null;
    }

    public Budget(String budgetName, String currencyId, BigDecimal factAmount, BigDecimal planAmount, boolean isActive, Date startDate, Date endDate, int employeeId) {
        this.budgetName = budgetName;
        this.currencyId = currencyId;
        this.factAmount = factAmount;
        this.planAmount = planAmount;
        this.isActive = isActive;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getFactAmount() {
        return factAmount;
    }

    public void setFactAmount(BigDecimal factAmount) {
        this.factAmount = factAmount;
    }

    public BigDecimal getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(BigDecimal planAmount) {
        this.planAmount = planAmount;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
