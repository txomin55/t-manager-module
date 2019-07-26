package com.tmanager.module.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.application.adapter.FooServiceAdapter;
import com.tmanager.module.application.api.FooService;
import com.tmanager.module.domain.spi.FooPersistancePort;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FooService getProductService(FooPersistancePort fooPersistencePort) {
        return new FooServiceAdapter(fooPersistencePort);
    }
}
