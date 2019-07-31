package com.tmanager.module.application.inmemory.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tmanager.module.domain.model.Foo;
import com.tmanager.module.domain.spi.FooPersistancePort;

public class FooInMemoryAdapter implements FooPersistancePort{

	private static final Map<Integer, Foo> fooMap = new HashMap<Integer, Foo>(0);
	
	@Override
	public void fooMethod(Foo foo) {
		fooMap.put(foo.getId(), foo);
	}

	@Override
	public void deleteFoo(int id) {
		fooMap.remove(id);
	}

	@Override
	public List<Foo> getFoo() {
		return (List<Foo>) fooMap.values();
	}
}
