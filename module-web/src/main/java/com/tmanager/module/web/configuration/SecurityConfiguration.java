package com.tmanager.module.web.configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/init/**").permitAll()
				.antMatchers("/actuator/**").permitAll()
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/favicon.ico").permitAll()
				.antMatchers("/static/**").permitAll()
				.antMatchers("/static/js/**").permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/")
				.antMatchers("/init/**")
				.antMatchers("/actuator/**")
				.antMatchers("/auth/**")
				.antMatchers("/favicon.ico")
				.antMatchers("/static/**")
				.antMatchers("/static/js/**");
	}
}
