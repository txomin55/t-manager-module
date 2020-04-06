package com.tmanager.module.configuration.adapters.bar;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.domain.bar.port.GetBarPersistancePort;
import com.tmanager.module.infrastructure.rest.bar.adapter.GetBarRestAdapter;

@Configuration
@ConditionalOnProperty(value = "module.deploy.external-communication-tech", havingValue = "rest")
public class BarRestAdapterConfiguration {

	@Bean
	public GetBarPersistancePort getBarPersistancePort() {
		return new GetBarRestAdapter();
	}
}
