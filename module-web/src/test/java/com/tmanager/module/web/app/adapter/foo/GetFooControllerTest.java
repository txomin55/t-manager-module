package com.tmanager.module.web.app.adapter.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;

@RunWith(MockitoJUnitRunner.class)
public class GetFooControllerTest {

    @Autowired
    private GetFooService getFooService;
    
	@Test
	public void getFooController(){
		
    	FooDTO foo = getFooService.getFoo(new FooGetCommand("1", "1")); 
    	
        GetFooWeb fooWeb = new GetFooWeb(foo.getId(), foo.getName(), foo.getValue());
		
		Assert.notNull(fooWeb, "Null fooWeb");
	}
}
