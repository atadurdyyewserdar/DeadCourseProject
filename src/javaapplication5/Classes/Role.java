package javaapplication5.Classes;

import java.io.Serializable;

public class Role implements Serializable {

    protected int idRole;

    private String roleName;

    private String roleDescription;

    public Role() {
        idRole = 0;
        roleName = "";
        roleDescription = "";
    }

    public Role(int idRole) {
        this.idRole = idRole;
        roleName = "";
        roleDescription = "";
    }

    public Role(int idRole, String roleName, String roleDescription) {
        this.idRole = idRole;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
