package ua.skuhtin.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public interface OAuth2Service {
    OAuth2AccessToken login(String login, String password);

    OAuth2AccessToken refresh(String refreshToken);

    /**
     * next generation service to use logOut service from separate oauth server
     */
    //ResponseEntity<HttpStatus> logOut(String token);
}
