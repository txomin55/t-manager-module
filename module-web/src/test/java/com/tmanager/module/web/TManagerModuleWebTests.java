package com.tmanager.module.web;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.tmanager.module.web.configuration.CustomAccessTokenConverter;
import com.tmanager.module.web.configuration.OAuth2ResourceServerConfigJwt;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Ignore
@EnableWebSecurity
@RunWith(SpringRunner.class)
@TestPropertySource(locations={"classpath:application.yml", "classpath:application-develop-in-memory.yml"})
@ContextConfiguration(initializers={ConfigFileApplicationContextInitializer.class}, classes= {CustomAccessTokenConverter.class, OAuth2ResourceServerConfigJwt.class})
@SpringBootTest
public class TManagerModuleWebTests {
 
    @Autowired
	private TokenStore tokenStore;

	@Value("${module.oauth.clientId}")
	private String clientId;

	@Value("${module.oauth.clientSecret}")
	private String clientSecret;

	@Value("${module.oauth.server.path}")
	private String serverPath;

	@Value("${module.oauth.server.port}")
	private String serverPort;

	@Value("${module.oauth.server.address}")
	private String serverAddress;

	@Value("${module.oauth.clientRedirectUrl}")
	private String clientRedirectUrl;
	
    @Test
    public void whenTokenDontContainIssuer() {
        final String tokenValue = obtainAccessToken();
		final OAuth2Authentication auth = tokenStore.readAuthentication(tokenValue);
        assertTrue(auth.isAuthenticated());

        Map<String, Object> details = (Map<String, Object>) auth.getDetails();
        assertTrue(details.containsKey("organization"));
    }

    private String obtainAccessToken() {
    	
    	final Map<String, String> params = new HashMap<String, String>();
    	String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath + "/oauth";
    	
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("username", "user-open-source");
        params.put("password", "password-open-source");
        final Response response = RestAssured.given()
        		.with()
        		.params(params)
        		.when()
        		.post(AUTH_SERVER + "/token");
        return response.jsonPath().getString("access_token");
    }
}
