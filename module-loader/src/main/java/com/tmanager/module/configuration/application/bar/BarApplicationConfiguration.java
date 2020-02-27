package com.tmanager.module.configuration.application.bar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.application.bar.adapter.GetBarServiceAdapter;
import com.tmanager.module.application.bar.port.GetBarService;
import com.tmanager.module.domain.bar.port.GetBarPersistancePort;

@Configuration
public class BarApplicationConfiguration {

    @Bean
    public GetBarService getBarService(GetBarPersistancePort getBarPersistancePort) {
    	return new GetBarServiceAdapter(getBarPersistancePort);
    }
}
