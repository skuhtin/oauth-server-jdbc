package ua.skuhtin.security.service;

import org.springframework.http.HttpStatus;

public interface LogOutService {
    HttpStatus logout(String accessToken);
}
