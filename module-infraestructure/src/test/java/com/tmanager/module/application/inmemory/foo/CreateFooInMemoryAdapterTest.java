package com.tmanager.module.application.inmemory.foo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Map;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;
import com.tmanager.module.domain.foo.model.Foo;

@RunWith(MockitoJUnitRunner.class)
public class CreateFooInMemoryAdapterTest {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;
	
	public void createFooInMemoryAdapter(){
		
		Integer id = simulatedFooMap.size() + 1;
		String name = "Soy " + id;
		Foo foo = new Foo(id, name);
		
		int initalNFoo = simulatedFooMap.size();
		
		simulatedFooMap.put(foo.getId(), new FooEntity(foo));
		
		int finalNFoo = simulatedFooMap.size();
		
		assertThat(simulatedFooMap, is(simulatedFooMap.containsKey(id)));
		assertThat(finalNFoo, is(initalNFoo + 1));  
	}
}
