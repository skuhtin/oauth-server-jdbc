package ua.skuhtin.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skuhtin.dto.UserDto;
import ua.skuhtin.model.Users;
import ua.skuhtin.repository.UserRepository;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Users saveUser(UserDto dto) throws Exception {
        Users user = usersRepository.save(modelMapper.map(dto, Users.class));
        if (Objects.nonNull(user)) throw new RuntimeException();
        return user;
    }
}
