package ua.skuhtin.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", schema = "access")
@DynamicUpdate
public class Roles implements Serializable {
    @Id
    @SequenceGenerator(name = "roles_seq", schema = "public", catalog = "sequences", sequenceName = "roles_seq_pk", allocationSize = 1)
    @GeneratedValue(generator = "roles_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
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
