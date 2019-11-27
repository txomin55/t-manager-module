package com.tmanager.module.configuration.adapters.foo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public Map<String, FooEntity> simulatedFooMap() {
        Map<String, FooEntity> fooMap = new HashMap<String, FooEntity>();
        String id1 = UUID.randomUUID().toString();
		String id2 = UUID.randomUUID().toString();
		
        fooMap.put(id1, new FooEntity(id1, "Soy 0", "1"));
        fooMap.put(id2, new FooEntity(id2, "Soy 1", "2"));
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
