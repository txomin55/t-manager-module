package com.tmanager.module.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/module").permitAll()
				.antMatchers("/module/actuator/**").permitAll().antMatchers("/module/init")
				.permitAll().antMatchers("/module/static/js/*").permitAll()
				.antMatchers("/module/static/css/*").permitAll().antMatchers("/module/static/img/*")
				.permitAll().antMatchers("/module/favicon.ico").permitAll().antMatchers("/foo/*")
				.permitAll().antMatchers("/module/auth/*").permitAll();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/module").antMatchers("/module/actuator/**")
				.antMatchers("/module/init").antMatchers("/module/static/js/*")
				.antMatchers("/module/static/css/*").antMatchers("/module/static/img/*")
				.antMatchers("/module/favicon.ico").antMatchers("/foo/*")
				.antMatchers("/module/auth/*");
	}

}
