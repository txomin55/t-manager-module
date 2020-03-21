package com.tmanager.module.application.bar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.domain.bar.model.Bar;
import com.tmanager.module.domain.bar.port.GetBarPersistancePort;

@RunWith(MockitoJUnitRunner.class)
public class GetBarServiceAdapterTest {

	@Mock
	private GetBarPersistancePort getBarPersistancePort;
	
	@Test
	public void getBarServiceAdapter(){
		
		List<Bar> list = new ArrayList<Bar>();
		list.add(new Bar("1", "TEST-1"));
		list.add(new Bar("2", "TEST-2"));
		
		Map<String, String> aux = new HashMap<String, String>();
		
		when(getBarPersistancePort.getBar("1", aux)).thenReturn(list.get(0)); 
		
		Bar bar = getBarPersistancePort.getBar("1", aux);
		
		assertThat("No element returned", bar.getId().equals("1"));
	}
}
