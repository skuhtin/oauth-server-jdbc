package ua.skuhtin.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class OauthTokenStoreConfig {

    public static final String DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT =
            "select token_id, token from oauth_access_token where authentication_id = ? for update";
    private final DataSource dataSource;

    @Autowired
    public OauthTokenStoreConfig(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public TokenStore tokenStore() {
        JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
        tokenStore.setSelectAccessTokenFromAuthenticationSql(DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT);
        return tokenStore;
    }
}
