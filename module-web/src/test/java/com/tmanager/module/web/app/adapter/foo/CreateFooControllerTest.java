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
		
		String fooId = fooService.createFoo(new FooCreateCommand("TEST-FOO", "1", "1"));
		
		Assert.isTrue(fooId != null, "Foo successfully created");
	}
}
