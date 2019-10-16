package com.tmanager.module.web;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TManagerModuleWebTests {

    @Autowired
    private JwtTokenStore tokenStore;

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
        System.out.println(tokenValue);
        System.out.println(auth);
        assertTrue(auth.isAuthenticated());
        System.out.println(auth.getDetails());

        Map<String, Object> details = (Map<String, Object>) auth.getDetails();
        assertTrue(details.containsKey("organization"));
        System.out.println(details.get("organization"));
    }

    private String obtainAccessToken() {
    	
    	final Map<String, String> params = new HashMap<String, String>();
    	String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath + "/oauth";
    	
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", "user-open-source");
        params.put("password", "password-open-source");
        final Response response = RestAssured.given()
        		.auth()
        		.preemptive()
        		.basic(clientId, clientSecret)
        		.and()
        		.with()
        		.params(params)
        		.when()
        		.post(AUTH_SERVER + "/token");
        return response.jsonPath().getString("access_token");
    }
}
