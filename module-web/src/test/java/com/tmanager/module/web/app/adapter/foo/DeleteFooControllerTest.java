package com.tmanager.module.web.app.adapter.foo;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.exception.CustomException;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooControllerTest {

    @Mock
    private DeleteFooService deleteFooService;
    
	@Test
	public void deleteFooControllerTest() throws CustomException{
		
		FooDeleteCommand command = new FooDeleteCommand("1", "1");
		
		deleteFooService.deleteFoo(command);
		
		verify(deleteFooService).deleteFoo(command);
	}
}
