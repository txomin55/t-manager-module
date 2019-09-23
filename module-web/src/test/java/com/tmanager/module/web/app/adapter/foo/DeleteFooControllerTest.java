package com.tmanager.module.web.app.adapter.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.application.foo.port.DeleteFooService;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooControllerTest {

    @Autowired
    private DeleteFooService deleteFooService;
    
	@Test
	public void deleteFooControllerTest(){
		
		int id = 1;
		
		deleteFooService.deleteFoo(new FooDeleteCommand(id));
	}
}
