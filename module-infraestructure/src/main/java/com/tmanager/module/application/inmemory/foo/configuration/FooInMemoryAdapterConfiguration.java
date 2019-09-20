package com.tmanager.module.application.inmemory.foo.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmanager.module.application.inmemory.foo.adapter.DeleteFooInMemoryAdapter;
import com.tmanager.module.application.inmemory.foo.adapter.CreateFooInMemoryAdapter;
import com.tmanager.module.application.inmemory.foo.adapter.GetFooListInMemoryAdapter;
import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;

@Configuration
public class FooInMemoryAdapterConfiguration {

	@Bean 
	public Map<Integer, FooEntity> simulatedFooMap(){
		Map<Integer, FooEntity> fooMap = new HashMap<Integer, FooEntity>();
		fooMap.put(0, new FooEntity(0, "Soy 0"));
		fooMap.put(1, new FooEntity(1, "Soy 1"));
		return fooMap;
	}
    @Bean
    public CreateFooPersistancePort getFooPersistancePort() {
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
}
