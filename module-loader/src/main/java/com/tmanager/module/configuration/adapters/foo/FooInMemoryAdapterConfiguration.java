package com.tmanager.module.configuration.adapters.foo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;
import com.tmanager.module.infrastructure.inmemory.foo.adapter.CreateFooInMemoryAdapter;
import com.tmanager.module.infrastructure.inmemory.foo.adapter.DeleteFooInMemoryAdapter;
import com.tmanager.module.infrastructure.inmemory.foo.adapter.GetFooInMemoryAdapter;
import com.tmanager.module.infrastructure.inmemory.foo.adapter.GetFooListInMemoryAdapter;
import com.tmanager.module.infrastructure.inmemory.foo.adapter.UpdateFooInMemoryAdapter;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

@Configuration
@Profile({"develop-in-memory", "production-in-memory"})
public class FooInMemoryAdapterConfiguration {

    @Bean
    public Map<Integer, FooEntity> simulatedFooMap() {
        Map<Integer, FooEntity> fooMap = new HashMap<Integer, FooEntity>();
        fooMap.put(0, new FooEntity(0, "Soy 0", "1"));
        fooMap.put(1, new FooEntity(1, "Soy 1", "2"));
        return fooMap;
    }

    @Bean
    public CreateFooPersistancePort fooPersistancePort() {
        return new CreateFooInMemoryAdapter();
    }

    @Bean
    public GetFooListPersistancePort getFooListPersistancePort() {
        return new GetFooListInMemoryAdapter();
    }

    @Bean
    public DeleteFooPersistancePort deleteFooPersistancePort() {
        return new DeleteFooInMemoryAdapter();
    }

    @Bean
    public UpdateFooPersistancePort updateFooPersistancePort() {
    	return new UpdateFooInMemoryAdapter();
    }

    @Bean
    public GetFooPersistancePort getFooPersistancePort() {
    	return new GetFooInMemoryAdapter();
    }
}
