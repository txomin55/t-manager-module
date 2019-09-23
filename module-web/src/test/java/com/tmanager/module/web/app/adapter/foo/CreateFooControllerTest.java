package com.tmanager.module.web.app.adapter.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.web.app.adapter.foo.cases.CreateFooController;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateFooController.class)
public class CreateFooControllerTest {

    @Autowired
    private CreateFooService fooService;
    
	@Test
	public void createFooController(){
		
		int fooId = fooService.createFoo(new FooCreateCommand("TEST-FOO"));
		
		Assert.isTrue(fooId > 0, "Foo successfully created");
	}
}
