package com.tmanager.module.web.app.adapter.foo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.tmanager.module.web.app.adapter.foo.cases.DeleteFooController;
import com.tmanager.module.web.app.adapter.foo.cases.FooDeleteCommand;
import com.tmanager.module.web.app.adapter.foo.dto.FooWeb;

@RunWith(SpringRunner.class)
@WebMvcTest(DeleteFooController.class)
public class DeleteFooControllerTest {

    @Autowired
    private DeleteFooService fooService;
    
	@Test
	public void deleteFooControllerTest(){
		
		int id = 1;
		
		deleteFooService.deleteFoo(new FooDeleteCommand(id));
	}
}
