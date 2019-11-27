package com.tmanager.module.infrastructure.inmemory.foo.adapter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

public class UpdateFooInMemoryAdapter implements UpdateFooPersistancePort {

	@Autowired
	private Map<String, FooEntity> simulatedFooMap;

	@Override
	public void updateFoo(Foo foo) {
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
	}
}
