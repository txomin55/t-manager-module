package com.tmanager.module.application.inmemory.foo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Map;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.inmemory.foo.entity.FooEntity;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooInMemoryAdapterTest {

	@Autowired
	private Map<Integer, FooEntity> simulatedFooMap;
	
	public void deleteFooListInMemoryAdapter(){
		
		Integer id = simulatedFooMap.entrySet().stream()
													.findAny()
													.get()
													.getKey();
		
		int initalNFoo = simulatedFooMap.size();
		
		simulatedFooMap.remove(id);
		
		int finalNFoo = simulatedFooMap.size();
		
		assertThat(simulatedFooMap, not(simulatedFooMap.containsKey(id)));
		assertThat(initalNFoo, is(finalNFoo + 1));  
	}
}
