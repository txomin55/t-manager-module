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
public class UpdateFooInMemoryAdapterTest {
	
	@Test
	public void updateFooInMemoryAdapter(){
		
		Map<String, FooEntity> simulatedFooMap = new HashMap<String, FooEntity>();
		
		simulatedFooMap.put("1", new FooEntity("1", "Test 1", "1", "1"));
		simulatedFooMap.put("2", new FooEntity("2", "Test 2", "1", "1"));
		
		Foo foo = new Foo("1", "UPDATED", "UPDATED", "1");
		
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
		
		assertThat("Element does not exist", simulatedFooMap.get(foo.getId()).getName().equals("UPDATED"));
	}
}
