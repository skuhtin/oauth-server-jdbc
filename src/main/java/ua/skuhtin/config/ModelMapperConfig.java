package ua.skuhtin.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.skuhtin.config.converter.UserDtoToUserConverter;


@Configuration
public class ModelMapperConfig {

    private final PasswordEncoder encoder;

    @Autowired
    public ModelMapperConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new UserDtoToUserConverter(encoder));
        return mapper;
    }
}
