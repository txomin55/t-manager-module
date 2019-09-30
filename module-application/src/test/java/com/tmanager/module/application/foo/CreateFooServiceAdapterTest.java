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
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

@RunWith(MockitoJUnitRunner.class)
public class CreateFooServiceAdapterTest {

	@Mock
	private CreateFooPersistancePort createFooPersistancePort;
	
	@Mock
	private List<Foo> list;
	
	@Test
	public void deleteFooServiceAdapter(){
		
		list = new ArrayList<Foo>();
		
		list.add(new Foo(1, "TEST-1", "1"));
		
		doNothing().when(createFooPersistancePort).createFoo(isA(Foo.class)); 
		
		createFooPersistancePort.createFoo(new Foo(2, "TEST-2", "2"));
		
		verify(list);
	}
}
