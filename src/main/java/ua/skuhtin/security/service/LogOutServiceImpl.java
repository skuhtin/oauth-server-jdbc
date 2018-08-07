package ua.skuhtin.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(rollbackFor = Exception.class)
public class LogOutServiceImpl implements LogOutService {
    private final Logger LOGGER = LoggerFactory.getLogger(LogOutServiceImpl.class);
    private final TokenStore tokenStore;

    @Autowired
    public LogOutServiceImpl(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public HttpStatus logout(String token) {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        OAuth2RefreshToken refresh = accessToken.getRefreshToken();
        if (Objects.isNull(accessToken)) {
            LOGGER.info("access token not found for token, {}", token);
            return HttpStatus.NOT_FOUND;
        }
        tokenStore.removeAccessToken(accessToken);
        if (Objects.nonNull(refresh)) {
            tokenStore.removeRefreshToken(refresh);
        }
        return HttpStatus.OK;
    }
}
