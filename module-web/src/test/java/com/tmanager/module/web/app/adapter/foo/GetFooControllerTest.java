package com.tmanager.module.web.app.adapter.foo;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.exception.CustomException;

@RunWith(MockitoJUnitRunner.class)
public class GetFooControllerTest {

    @Mock
    private GetFooService getFooService;
    
	@Test
	public void getFooController() throws CustomException{
		
		FooGetCommand command = new FooGetCommand("1", "1");
		
		getFooService.getFoo(command); 

		verify(getFooService).getFoo(command); 
	}
}
