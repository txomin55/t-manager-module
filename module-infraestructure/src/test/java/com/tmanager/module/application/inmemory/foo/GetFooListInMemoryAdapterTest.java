package com.tmanager.module.application.inmemory.foo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;

@RunWith(MockitoJUnitRunner.class)
public class GetFooListInMemoryAdapterTest {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;
	
	@Test
	public void getFooListInMemoryAdapter(){
		ArrayList<Foo> foos = new ArrayList<Foo>(simulatedFooMap.values().stream().map(foo -> {
			return new Foo(foo.getId(), foo.getName());
		}).collect(Collectors.toList()));
		
		assertThat(foos, not(IsEmptyCollection.empty()));
	}
}
