package ua.skuhtin.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.skuhtin.model.Users;
import ua.skuhtin.repository.UserRepository;
import ua.skuhtin.security.SecurityUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) {
        Users foundUser = userRepository.getUserByLogin(login);
        if (Objects.isNull(foundUser)) {
            throw new RuntimeException();
        }

        Collection<GrantedAuthority> auth = new ArrayList<>();
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(foundUser.getRoles().getRole());
        auth.add(grantedAuthority);
        return new SecurityUser(foundUser, auth);
    }
}
