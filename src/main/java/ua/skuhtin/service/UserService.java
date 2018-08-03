package ua.skuhtin.service;

import ua.skuhtin.dto.UserDto;
import ua.skuhtin.model.Users;

public interface UserService {
    public Users saveUser(UserDto dto) throws Exception;
}
