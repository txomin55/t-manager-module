package com.tmanager.module.infrastructure.inmemory.foo.adapter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

public class CreateFooInMemoryAdapter implements CreateFooPersistancePort {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;

	@Override
	public void createFoo(Foo foo) {
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
	}
}
