package com.tmanager.module.application.foo;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooServiceAdapterTest {

	@Mock
	private DeleteFooPersistancePort deleteFooPersistancePort;
	
	@Mock
	private List<Foo> list = new ArrayList<Foo>();
	
	@Test
	public void deleteFooServiceAdapter(){
		
		list.add(new Foo("1", "TEST-1", "1", "1"));
		list.add(new Foo("2", "TEST-2", "2", "1"));
		
		String id = "1";
		
		doNothing().when(deleteFooPersistancePort).deleteFoo(isA(String.class)); 
		
		deleteFooPersistancePort.deleteFoo(id);
		
		verify(deleteFooPersistancePort).deleteFoo(id);
	}
}
