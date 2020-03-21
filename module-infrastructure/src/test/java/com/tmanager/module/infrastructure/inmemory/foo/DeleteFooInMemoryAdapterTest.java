package com.tmanager.module.infrastructure.inmemory.foo;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tmanager.module.infrastructure.inmemory.foo.entity.FooEntity;

@RunWith(SpringRunner.class)
public class DeleteFooInMemoryAdapterTest {
	
	@Test
	public void deleteFooListInMemoryAdapter(){
		
		Map<String, FooEntity> simulatedFooMap = new HashMap<String, FooEntity>();
		
		simulatedFooMap.put("1", new FooEntity("1", "Test 1", "1", "1"));
		simulatedFooMap.put("2", new FooEntity("2", "Test 2", "1", "1"));
		
		String id = simulatedFooMap.entrySet().stream()
													.findAny()
													.get()
													.getKey();
				
		simulatedFooMap.remove(id);
				
		assertThat("Map does not contain id", !simulatedFooMap.containsKey(id));
	}
}
