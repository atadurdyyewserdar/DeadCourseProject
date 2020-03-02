package javaapplication5.Classes;

import java.io.Serializable;

public class Employee implements Serializable {

    private int employeeId;

    private String roleName;

    private String fio;

    private String address;

    private String mobile;

    private String login;

    private String password;

    private String email;

    private boolean access;

    public void setEmployee(Employee em) {
        employeeId = em.getEmployeeId();
        roleName = em.getRoleName();
        fio = em.getFio();
        address = em.getAddress();
        mobile = em.getMobile();
        login = em.getLogin();
        password = em.getPassword();
        email = em.getEmail();
        access = em.isAccess();
    }

    public Employee(int employeeId, String roleName, String fio, String address, String mobile, String email) {
        this.employeeId = employeeId;
        this.roleName = roleName;
        this.fio = fio;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public Employee(int employeeId, String roleName, String fio, String address, String mobile, String login, String password, String email, boolean access) {
        this.employeeId = employeeId;
        this.roleName = roleName;
        this.fio = fio;
        this.address = address;
        this.mobile = mobile;
        this.login = login;
        this.password = password;
        this.email = email;
        this.access = access;
    }

    public Employee(String roleName, String fio, String address, String mobile, String login, String password, String email, boolean access) {
        this.roleName = roleName;
        this.fio = fio;
        this.address = address;
        this.mobile = mobile;
        this.login = login;
        this.password = password;
        this.email = email;
        this.access = access;
        this.employeeId = -1;
    }

    public Employee() {
        this.employeeId = 0;
        this.roleName = "";
        this.fio = "";
        this.address = "";
        this.mobile = "";
        this.login = "";
        this.password = "";
        this.email = "";
        this.access = false;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return Integer.toString(employeeId) + " " + roleName + " " + fio + " " + address + " " + mobile + " " + email + " " + login + " " + password + " " + Boolean.toString(access);
    }
}
