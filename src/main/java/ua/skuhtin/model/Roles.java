package ua.skuhtin.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "access")
@DynamicUpdate
public class Roles {
    @Id
    @SequenceGenerator(name = "roles_seq", schema = "public", catalog = "sequences", sequenceName = "roles_seq_pk", allocationSize = 1)
    @GeneratedValue(generator = "roles_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    public Roles() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        return roleId.equals(roles.roleId);
    }

    @Override
    public int hashCode() {
        return roleId.hashCode();
    }
}
