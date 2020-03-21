package com.tmanager.module.web.app.adapter.foo;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;

@RunWith(MockitoJUnitRunner.class)
public class CreateFooControllerTest {

    @Mock
    private CreateFooService fooService;
    
	@Test
	public void createFooController(){
		
		FooCreateCommand command = new FooCreateCommand("TEST-FOO", "1", "1");
		
		fooService.createFoo(command);
		
		verify(fooService).createFoo(command);
	}
}
