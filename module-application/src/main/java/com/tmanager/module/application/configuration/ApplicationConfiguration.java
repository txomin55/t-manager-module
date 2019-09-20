package com.tmanager.module.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.application.adapter.DeleteFooServiceAdapter;
import com.tmanager.module.application.adapter.CreateFooServiceAdapter;
import com.tmanager.module.application.adapter.GetFooListServiceAdapter;
import com.tmanager.module.application.port.DeleteFooService;
import com.tmanager.module.application.port.CreateFooService;
import com.tmanager.module.application.port.GetFooListService;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreateFooService getFooService(CreateFooPersistancePort fooPersistencePort) {
        return new CreateFooServiceAdapter(fooPersistencePort);
    }
    
    @Bean
    public GetFooListService getFooListService(GetFooListPersistancePort getFooListPersistancePort) {
    	return new GetFooListServiceAdapter(getFooListPersistancePort);
    }

    @Bean
    public DeleteFooService deleteFooService(DeleteFooPersistancePort deleteFooPersistancePort) {
    	return new DeleteFooServiceAdapter(deleteFooPersistancePort);
    }
}
