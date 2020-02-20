package com.tmanager.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
@EnableDiscoveryClient
@EnableFeignClients
public class TManagerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TManagerModuleApplication.class, args);
	}
}
