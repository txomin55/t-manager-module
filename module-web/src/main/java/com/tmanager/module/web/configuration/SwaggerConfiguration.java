package com.tmanager.module.web.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {                                    

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
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2).select()
	        .apis(RequestHandlerSelectors.any())
	        .paths(PathSelectors.regex("\\/api\\/.*"))
	        .build()
	        .securitySchemes(Arrays.asList(securityScheme()))
	        .securityContexts(Arrays.asList(securityContext()));
	}

    private SecurityScheme securityScheme() {
    	String AUTH_SERVER = serverAddress + ":" + serverPort + "/" + serverPath + "/oauth";

        List<GrantType> grantTypes = new ArrayList<GrantType>();

        GrantType grantTypeCode = new AuthorizationCodeGrantBuilder()
            .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
            .tokenRequestEndpoint(
              new TokenRequestEndpoint(AUTH_SERVER + "/authorize", clientId, clientSecret))
            .build();
        
        GrantType grantTypePassword = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER + "/token?grant_type=password&username=user-open-source&password=password-open-source");

        grantTypes.add(grantTypeCode);
        grantTypes.add(grantTypePassword);
     
        SecurityScheme oauth = new OAuthBuilder().name("swagger_oauth")
            .grantTypes(grantTypes)
            .scopes(Arrays.asList(scopes()))
            .build();
        
        return oauth;
    }
    
    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = { 
          new AuthorizationScope("read-foo", "Access foo API") };
        return scopes;
    }
    
    private SecurityContext securityContext() {
        return SecurityContext.builder()
          .securityReferences(
            Arrays.asList(new SecurityReference("swagger_oauth", scopes())))
          .forPaths(PathSelectors.regex("/foos*"))
          .build();
    }
}
