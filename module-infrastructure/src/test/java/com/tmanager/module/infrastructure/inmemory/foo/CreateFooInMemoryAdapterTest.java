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
public class CreateFooInMemoryAdapterTest {
	
	@Test
	public void createFooInMemoryAdapter(){
		
		Map<String, FooEntity> simulatedFooMap = new HashMap<String, FooEntity>();
		
		String id = "1";
		String name = "Soy " + id;
		Foo foo = new Foo(id, name, "1", "1");
				
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
				
		assertThat("Map does not contain id", simulatedFooMap.containsKey(id));  
	}
}
