package com.tmanager.module.infrastructure.inmemory.foo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

@RunWith(MockitoJUnitRunner.class)
public class GetFooInMemoryAdapterTest {

	@Mock
	private Map<String, FooEntity> simulatedFooMap;
	
	@Test
	public void getFooInMemoryAdapter(){
		
		simulatedFooMap = new HashMap<String, FooEntity>();
		
		simulatedFooMap.put("1", new FooEntity("1", "Test 1", "1", "1"));
		simulatedFooMap.put("2", new FooEntity("2", "Test 2", "1", "1"));
		
		FooEntity fooEnt = simulatedFooMap.get("1");
		Foo foo = new Foo(fooEnt.getId(), fooEnt.getName(), fooEnt.getValue(), fooEnt.getOwner());
		
		assertThat(foo, is(foo.getId().equals("1")));
	}
}
