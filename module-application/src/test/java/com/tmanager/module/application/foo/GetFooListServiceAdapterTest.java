package com.tmanager.module.application.foo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;

@RunWith(MockitoJUnitRunner.class)
public class GetFooListServiceAdapterTest {

	@Mock
	private GetFooListPersistancePort getFooListPersistancePort;
	
	@Test
	public void getFooListServiceAdapter(){
		
		List<Foo> list = new ArrayList<Foo>();
		list.add(new Foo("1", "TEST-1", "1", "1"));
		list.add(new Foo("2", "TEST-2", "2", "1"));
		
		String owner = "1";
		
		when(getFooListPersistancePort.getFoo(isA(String.class))).thenReturn(list); 
		
		List<Foo> myList = getFooListPersistancePort.getFoo(owner);
		
		assertThat("No elements returned", myList.size() == 2);
	}
}
