package ua.skuhtin.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    private final TokenStore tokenStore;
    private final DataSource dataSource;
    private final ClientDetailsService clientDetailsService;
    private final AuthenticationManager authenticationManager;
    private Boolean reuseRefreshToken = false;

    @Autowired
    public AuthServerConfig(@Qualifier("tokenStore") TokenStore tokenStore,
                            @Qualifier("dataSource") DataSource dataSource,
                            @Qualifier("clientDetailsService") ClientDetailsService clientDetailsService,
                            @Qualifier("authenticationManager") AuthenticationManager authenticationManager) {
        this.tokenStore = tokenStore;
        this.dataSource = dataSource;
        this.clientDetailsService = clientDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Value("${reuse.refresh.token}")
    public void setReuseRefreshToken(Boolean reuseRefreshToken) {
        this.reuseRefreshToken = reuseRefreshToken;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
    }

    @Bean
    @Primary
    public AuthorizationServerTokenServices authorizationServerTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(reuseRefreshToken);
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setTokenEnhancer(new CustomTokenEnhancer());
        return tokenServices;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenServices(authorizationServerTokenServices())
                .accessTokenConverter(new DefaultAccessTokenConverter())
                .tokenStore(this.tokenStore).authenticationManager(authenticationManager);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource);
    }

}
