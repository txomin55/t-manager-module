package com.tmanager.module.web.app.adapter.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.exception.CustomException;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooControllerTest {

    @Autowired
    private DeleteFooService deleteFooService;
    
	@Test
	public void deleteFooControllerTest() throws CustomException{
		
		String id = "1";
		String owner = "1";
		
		deleteFooService.deleteFoo(new FooDeleteCommand(id, owner));
	}
}
