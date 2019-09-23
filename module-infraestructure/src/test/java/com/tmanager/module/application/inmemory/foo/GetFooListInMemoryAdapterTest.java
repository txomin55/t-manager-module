package com.tmanager.module.application.inmemory.foo;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;

@RunWith(MockitoJUnitRunner.class)
public class GetFooListInMemoryAdapterTest {

	@Mock
	private Map<Integer, FooEntity> simulatedFooMap;
	
	@Test
	public void getFooListInMemoryAdapter(){
		
		simulatedFooMap.put(1, new FooEntity(1, "Test 1"));
		simulatedFooMap.put(2, new FooEntity(2, "Test 2"));
		
		ArrayList<Foo> foos = new ArrayList<Foo>(simulatedFooMap.values().stream().map(foo -> {
			return new Foo(foo.getId(), foo.getName());
		}).collect(Collectors.toList()));
		
		assertThat(foos, not(IsEmptyCollection.empty()));
	}
}
