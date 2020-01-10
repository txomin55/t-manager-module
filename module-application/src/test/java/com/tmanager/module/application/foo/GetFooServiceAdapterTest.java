package com.tmanager.module.application.foo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;

@RunWith(MockitoJUnitRunner.class)
public class GetFooServiceAdapterTest {

	@Mock
	private GetFooPersistancePort getFooPersistancePort;
	
	@Test
	public void getFooServiceAdapter(){
		
		List<Foo> list = new ArrayList<Foo>();
		list.add(new Foo("1", "TEST-1", "1", "1"));
		list.add(new Foo("2", "TEST-2", "2", "1"));
		
		when(getFooPersistancePort.getFoo("1")).thenReturn(list.get(0)); 
		
		Foo foo = getFooPersistancePort.getFoo("1");
		
		assertThat(foo, is(foo.getId().equals("1")));
	}
}
