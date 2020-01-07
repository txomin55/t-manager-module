package com.tmanager.module.configuration.adapters.foo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.adapter.CreateFooMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.DeleteFooMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.GetFooListMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.GetFooMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.UpdateFooMongoAdapter;


@Configuration
@Profile({"develop-mongo", "production-mongo"})
public class FooMongoAdapterConfiguration {

    @Bean
    public CreateFooPersistancePort fooPersistancePort() {
        return new CreateFooMongoAdapter();
    }

    @Bean
    public GetFooListPersistancePort getFooListPersistancePort() {
        return new GetFooListMongoAdapter();
    }

    @Bean
    public DeleteFooPersistancePort deleteFooPersistancePort() {
        return new DeleteFooMongoAdapter();
    }

    @Bean
    public UpdateFooPersistancePort updateFooPersistancePort() {
    	return new UpdateFooMongoAdapter();
    }

    @Bean
    public GetFooPersistancePort getFooPersistancePort() {
    	return new GetFooMongoAdapter();
    }
}
