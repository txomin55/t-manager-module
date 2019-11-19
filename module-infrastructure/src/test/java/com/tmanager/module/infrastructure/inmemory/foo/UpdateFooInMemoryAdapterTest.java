package com.tmanager.module.infrastructure.inmemory.foo;

import static org.hamcrest.CoreMatchers.not;
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
public class UpdateFooInMemoryAdapterTest {

	@Mock
	private Map<Integer, FooEntity> simulatedFooMap;
	
	@Test
	public void updateFooInMemoryAdapter(){
		
		simulatedFooMap = new HashMap<Integer, FooEntity>();
		
		simulatedFooMap.put(1, new FooEntity(1, "Test 1", "1"));
		simulatedFooMap.put(2, new FooEntity(2, "Test 2", "2"));
		
		Foo foo = new Foo(1, "UPDATED", "UPDATED");
		
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
		
		assertThat(simulatedFooMap.get(foo.getId()), not(null));
	}
}
