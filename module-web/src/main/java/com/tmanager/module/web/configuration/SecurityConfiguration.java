package com.tmanager.module.web.configuration;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/actuator/**").permitAll()
				/*
				.antMatchers("/module/init").permitAll()
				.antMatchers("/module/static/js/*").permitAll()
				.antMatchers("/module/static/css/*").permitAll()
				.antMatchers("/module/static/img/*").permitAll()
				.antMatchers("/module/favicon.ico").permitAll()
				.antMatchers("/foo/*").permitAll()
				*/
				.antMatchers("/auth/*").permitAll();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/")
				.antMatchers("/actuator/**")
				/*
				.antMatchers("/module/init").antMatchers("/module/static/js/*")
				.antMatchers("/module/static/css/*").antMatchers("/module/static/img/*")
				.antMatchers("/module/favicon.ico").antMatchers("/foo/*")
				*/
				.antMatchers("/auth/*");
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
	    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    Resource resource = new ClassPathResource("public.txt");
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
