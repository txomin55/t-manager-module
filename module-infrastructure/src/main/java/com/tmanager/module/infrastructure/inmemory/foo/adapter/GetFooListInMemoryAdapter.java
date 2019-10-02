package com.tmanager.module.infrastructure.inmemory.foo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;

public class GetFooListInMemoryAdapter implements GetFooListPersistancePort {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;

	@Override
	public List<Foo> getFoo() {
		return new ArrayList<Foo>(simulatedFooMap.values().stream().map(foo -> {
			return new Foo(foo.getId(), foo.getName(), foo.getValue());
		}).collect(Collectors.toList()));
	}
}
