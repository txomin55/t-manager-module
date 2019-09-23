package com.tmanager.module.web.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

@Configuration
public class WebApplicationInitializerConfiguration implements WebApplicationInitializer{

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
  
		servletContext.setInitParameter("spring.profiles.default", "local-in-memory");
        servletContext.setInitParameter("spring.profiles.active", "local-in-memory");
    }
}
