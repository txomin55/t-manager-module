package com.tmanager.module.infrastructure.inmemory.foo;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

@RunWith(SpringRunner.class)
public class GetFooInMemoryAdapterTest {
	
	@Test
	public void getFooInMemoryAdapter(){
		
		Map<String, FooEntity> simulatedFooMap = new HashMap<String, FooEntity>();
		
		simulatedFooMap.put("1", new FooEntity("1", "Test 1", "1", "1"));
		simulatedFooMap.put("2", new FooEntity("2", "Test 2", "1", "1"));
		
		FooEntity fooEnt = simulatedFooMap.get("1");
		Foo foo = new Foo(fooEnt.getId(), fooEnt.getName(), fooEnt.getValue(), fooEnt.getOwner());
		
		assertThat("Element does not exist", foo.getId().equals("1"));
	}
}
