package com.tmanager.module.infrastructure.inmemory.foo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

public class GetFooListInMemoryAdapter implements GetFooListPersistancePort {

	@Autowired
	private Map<String, FooEntity> simulatedFooMap;

	@Override
	public List<Foo> getFoo(String owner) {
		return new ArrayList<Foo>(simulatedFooMap.values().stream().filter(it -> it.getOwner().equals(owner)).map(foo -> {
			return new Foo(foo.getId(), foo.getName(), foo.getValue(), owner);
		}).collect(Collectors.toList()));
	}
}
