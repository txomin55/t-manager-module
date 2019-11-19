package com.tmanager.module.infrastructure.inmemory.foo.adapter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

public class GetFooInMemoryAdapter implements GetFooPersistancePort {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;

	@Override
	public Foo getFoo(Integer id) {
		FooEntity fooEnt = simulatedFooMap.get(id);
		return new Foo(fooEnt.getId(), fooEnt.getName(), fooEnt.getValue());
	}
}