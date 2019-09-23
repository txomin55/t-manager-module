package com.tmanager.module.application.inmemory.foo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooInMemoryAdapterTest {

	@Mock
	private Map<Integer, FooEntity> simulatedFooMap;
	
	public void deleteFooListInMemoryAdapter(){
		
		simulatedFooMap = new HashMap<Integer, FooEntity>();
		
		simulatedFooMap.put(1, new FooEntity(1, "Test 1"));
		simulatedFooMap.put(2, new FooEntity(2, "Test 2"));
		
		Integer id = simulatedFooMap.entrySet().stream()
													.findAny()
													.get()
													.getKey();
		
		int initalNFoo = simulatedFooMap.size();
		
		Mockito.verify(simulatedFooMap.remove(id));
		
		int finalNFoo = simulatedFooMap.size();
		
		assertThat(simulatedFooMap, not(simulatedFooMap.containsKey(id)));
		assertThat(initalNFoo, is(finalNFoo + 1));  
	}
}
