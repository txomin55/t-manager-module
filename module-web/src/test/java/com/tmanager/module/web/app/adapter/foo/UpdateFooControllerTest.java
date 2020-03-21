package com.tmanager.module.web.app.adapter.foo;

import static org.mockito.Mockito.verify;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tmanager.module.application.foo.command.FooUpdateCommand;
import com.tmanager.module.application.foo.port.UpdateFooService;
import com.tmanager.module.exception.CustomException;

@RunWith(MockitoJUnitRunner.class)
public class UpdateFooControllerTest {

    @Mock
    private UpdateFooService updateFooService;
    
	@Test
	public void getFooListController() throws CustomException{
		
		FooUpdateCommand command = new FooUpdateCommand(UUID.randomUUID().toString(), "UPDATED", "UPDATED", "1");
		
		updateFooService.updateFoo(command);		
		
		verify(updateFooService).updateFoo(command);
	}
}
