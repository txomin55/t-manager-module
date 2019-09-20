package com.tmanager.module.application.inmemory.foo.adapter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

public class CreateFooInMemoryAdapter implements CreateFooPersistancePort{
	
	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap; 
	
	@Override
	public void fooMethod(Foo foo) {
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
	}

}
