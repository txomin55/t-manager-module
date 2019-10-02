package com.tmanager.module.application.inmemory.foo.adapter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;

public class DeleteFooInMemoryAdapter implements DeleteFooPersistancePort {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;

	@Override
	public void deleteFoo(int id) {
		simulatedFooMap.remove(id);
	}
}
