package com.tmanager.module.configuration.application.foo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.application.foo.adapter.CreateFooServiceAdapter;
import com.tmanager.module.application.foo.adapter.DeleteFooServiceAdapter;
import com.tmanager.module.application.foo.adapter.GetFooListServiceAdapter;
import com.tmanager.module.application.foo.adapter.GetFooServiceAdapter;
import com.tmanager.module.application.foo.adapter.UpdateFooServiceAdapter;
import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.application.foo.port.UpdateFooService;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;

@Configuration
public class FooApplicationConfiguration {

    @Bean
    public CreateFooService fooCreateService(CreateFooPersistancePort fooPersistencePort) {
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
    
    @Bean
    public UpdateFooService updateFooService(UpdateFooPersistancePort updateFooPersistancePort, GetFooPersistancePort getFooPersistancePort) {
    	return new UpdateFooServiceAdapter(updateFooPersistancePort, getFooPersistancePort);
    }
    
    @Bean
    public GetFooService getFooService(GetFooPersistancePort getFooPersistancePort) {
    	return new GetFooServiceAdapter(getFooPersistancePort);
    }
}
