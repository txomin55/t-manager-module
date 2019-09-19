package com.tmanager.module.application.inmemory.foo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.application.inmemory.foo.adapter.FooInMemoryAdapter;
import com.tmanager.module.domain.spi.FooPersistancePort;

@Configuration
public class FooInMemoryAdapterConfiguration {

    @Bean
    public FooPersistancePort getFooPersistancePort() {
        return new FooInMemoryAdapter();
    }
}
