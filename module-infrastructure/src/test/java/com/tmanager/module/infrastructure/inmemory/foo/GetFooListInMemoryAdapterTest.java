package com.tmanager.module.infrastructure.inmemory.foo;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

@RunWith(MockitoJUnitRunner.class)
public class GetFooListInMemoryAdapterTest {

	@Mock
	private Map<String, FooEntity> simulatedFooMap;
	
	@Test
	public void getFooListInMemoryAdapter(){
		
		simulatedFooMap = new HashMap<String, FooEntity>();
		
		simulatedFooMap.put("1", new FooEntity("1", "Test 1", "1", "1"));
		simulatedFooMap.put("2", new FooEntity("2", "Test 2", "1", "1"));
		
		ArrayList<Foo> foos = new ArrayList<Foo>(simulatedFooMap.values().stream().map(foo -> {
			return new Foo(foo.getId(), foo.getName(), foo.getValue(), foo.getOwner());
		}).collect(Collectors.toList()));
		
		assertThat(foos, not(IsEmptyCollection.empty()));
	}
}
