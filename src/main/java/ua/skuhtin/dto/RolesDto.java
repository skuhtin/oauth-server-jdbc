package ua.skuhtin.dto;

import ua.skuhtin.model.Roles;

import java.io.Serializable;

public class RolesDto implements Serializable{

    private Long roleId;

    private String role;

    public RolesDto() {
    }

    public RolesDto(Long roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public RolesDto(Roles roles) {
        this.roleId = roles.getRoleId();
        this.role = roles.getRole();
    }



    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
