package ua.skuhtin.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups", schema = "access")
@DynamicUpdate
public class Groups {
    @Id
    @SequenceGenerator(name = "groups_seq", schema = "public", sequenceName = "groups_seq_pk", allocationSize = 1)
    @GeneratedValue(generator = "groups_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "role_groups", schema = "access",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Roles> roles;


    public Groups() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
