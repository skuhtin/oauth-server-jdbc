package ua.skuhtin.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public interface OAuth2Service {
    OAuth2AccessToken login(String login, String password);
    OAuth2AccessToken refresh(String refreshToken);
    ResponseEntity<HttpStatus> logOut(String token);
}
