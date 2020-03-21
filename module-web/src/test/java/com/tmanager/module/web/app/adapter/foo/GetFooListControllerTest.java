package com.tmanager.module.web.app.adapter.foo;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.foo.port.GetFooListService;

@RunWith(MockitoJUnitRunner.class)
public class GetFooListControllerTest {

    @Mock
    private GetFooListService getFooListService;
    
	@Test
	public void getFooListController(){
		
		getFooListService.getFoo("1");
		
		verify(getFooListService).getFoo("1");
	}
}
