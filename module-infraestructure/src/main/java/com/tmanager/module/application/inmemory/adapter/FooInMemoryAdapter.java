package com.tmanager.module.application.inmemory.adapter;

import java.util.HashMap;
import java.util.Map;

import com.tmanager.module.domain.model.Foo;
import com.tmanager.module.domain.spi.FooPersistancePort;

public class FooInMemoryAdapter implements FooPersistancePort{

	private static final Map<Integer, Foo> productMap = new HashMap<Integer, Foo>(0);
	
	@Override
	public void fooMethod(Foo foo) {
		productMap.put(foo.getId(), foo);
	}
}
