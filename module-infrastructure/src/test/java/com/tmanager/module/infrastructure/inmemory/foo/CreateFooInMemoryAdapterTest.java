package com.tmanager.module.application.inmemory.foo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;

@RunWith(MockitoJUnitRunner.class)
public class CreateFooInMemoryAdapterTest {

	@Mock
	private Map<Integer, FooEntity> simulatedFooMap;
	
	public void createFooInMemoryAdapter(){
		
		simulatedFooMap = new HashMap<Integer, FooEntity>();
		
		Integer id = simulatedFooMap.size() + 1;
		String name = "Soy " + id;
		Foo foo = new Foo(id, name, "1");
		
		int initalNFoo = simulatedFooMap.size();
		
		Mockito.verify(simulatedFooMap.put(foo.getId(), new FooEntity(foo)));
		
		int finalNFoo = simulatedFooMap.size();
		
		assertThat(simulatedFooMap, is(simulatedFooMap.containsKey(id)));
		assertThat(finalNFoo, is(initalNFoo + 1));  
	}
}
