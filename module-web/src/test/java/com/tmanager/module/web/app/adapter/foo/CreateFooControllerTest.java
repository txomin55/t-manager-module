package com.tmanager.module.web.app.adapter.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;

@RunWith(MockitoJUnitRunner.class)
public class CreateFooControllerTest {

    @Autowired
    private CreateFooService fooService;
    
	@Test
	public void createFooController(){
		
		int fooId = fooService.createFoo(new FooCreateCommand("TEST-FOO"));
		
		Assert.isTrue(fooId > 0, "Foo successfully created");
	}
}
