package com.tmanager.module.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfigJwt extends ResourceServerConfigurerAdapter {
 
    @Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;
 
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
	public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setAccessTokenConverter(customAccessTokenConverter);
        
	    Resource resource = new ClassPathResource("publicKey/public.txt");
	    String publicKey = null;
	    try {
	        publicKey = IOUtils.toString(resource.getInputStream());
	    } catch (final IOException e) {
	        throw new RuntimeException(e);
	    }
	    converter.setVerifierKey(publicKey);
	    return converter;
	}
}