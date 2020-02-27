package com.tmanager.module.configuration.adapters.bar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.domain.bar.port.GetBarPersistancePort;
import com.tmanager.module.infrastructure.rest.bar.adapter.GetBarRestAdapter;

@Configuration
//@Profile({"communication-rest"})
public class BarRestAdapterConfiguration {

    @Bean
    public GetBarPersistancePort getBarPersistancePort() {
    	return new GetBarRestAdapter();
    }
}
