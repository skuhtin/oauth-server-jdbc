package ua.skuhtin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class AuthInDbExampleApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInDbExampleApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Auth server example in DB started");

        SpringApplication.run(AuthInDbExampleApplication.class, args);
    }
}
