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
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;

@RunWith(MockitoJUnitRunner.class)
public class UpdateFooServiceAdapterTest {

	@Mock
	private UpdateFooPersistancePort updateFooPersistancePort;
	
	@Mock
	private List<Foo> list;
	
	@Test
	public void updateFooServiceAdapter(){
		
		List<Foo> list = new ArrayList<Foo>();
		list.add(new Foo(1, "TEST-1", "1"));
		list.add(new Foo(2, "TEST-2", "2"));
		
		doNothing().when(updateFooPersistancePort).updateFoo(isA(Foo.class)); 
		
		updateFooPersistancePort.updateFoo(new Foo(2, "TEST-2-EDITED", "2-EDITED"));
		
		verify(list);
	}
}
