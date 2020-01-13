package com.tmanager.module.web.app.adapter.foo;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooUpdateCommand;
import com.tmanager.module.application.foo.port.UpdateFooService;
import com.tmanager.module.exception.CustomException;

@RunWith(MockitoJUnitRunner.class)
public class UpdateFooControllerTest {

    @Autowired
    private UpdateFooService updateFooService;
    
	@Test
	public void getFooListController() throws CustomException{
		
		updateFooService.updateFoo(new FooUpdateCommand(UUID.randomUUID().toString(), "UPDATED", "UPDATED", "1"));		
	}
}
