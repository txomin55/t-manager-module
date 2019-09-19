package com.tmanager.module.application.inmemory.foo.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tmanager.module.application.inmemory.foo.bean.FooEntity;
import com.tmanager.module.domain.model.Foo;
import com.tmanager.module.domain.spi.FooPersistancePort;

public class FooInMemoryAdapter implements FooPersistancePort{

	private static final Map<Integer, FooEntity> fooMap = new HashMap<Integer, FooEntity>();
	
	public FooInMemoryAdapter() {
		fooMap.put(0, new FooEntity(0, "Soy 0"));
		fooMap.put(1, new FooEntity(1, "Soy 1"));
	}
	
	@Override
	public void fooMethod(Foo foo) {
		fooMap.put(foo.getId(), new FooEntity(foo));
	}

	@Override
	public void deleteFoo(int id) {
		fooMap.remove(id);
	}

	@Override
	public List<Foo> getFoo() {
		return new ArrayList<Foo>(
					fooMap.values()
					.stream()
					.map(foo -> {
						return new Foo(foo.getId(), foo.getName());
					})
					.collect(Collectors.toList())
		);
	}
}
