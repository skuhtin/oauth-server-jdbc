package ua.skuhtin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import ua.skuhtin.model.Users;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto implements Serializable {

    @ApiModelProperty(required = true)
    private String login;
    @ApiModelProperty(required = true)
    private String password;
    @ApiModelProperty(required = true)
    private boolean enabled;

    private Set<RolesDto> roles;

    public UserDto() {
    }

    public UserDto(String login, String password, boolean enabled) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    public UserDto(Users users) {
        this.login = users.getLogin();
        this.password = users.getPassword();
        this.enabled = users.getEnabled();
        this.roles = users.getGroups().stream()
                .flatMap(group -> group.getRoles().stream())
                .map(RolesDto::new)
                .collect(Collectors.toSet());
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @JsonIgnore
    public Set<RolesDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesDto> roles) {
        this.roles = roles;
    }
}
