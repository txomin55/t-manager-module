package com.tmanager.module.infrastructure.inmemory.foo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.domain.foo.model.FooList;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

public class GetFooListInMemoryAdapter implements GetFooListPersistancePort {

	@Autowired
	private Map<String, FooEntity> simulatedFooMap;

	@Override
	public List<FooList> getFoo(String owner) {
		return new ArrayList<FooList>(simulatedFooMap.values().stream().map(foo -> {
			return new FooList(foo.getId(), foo.getName(), foo.getValue(), owner);
		}).collect(Collectors.toList()));
	}
}
