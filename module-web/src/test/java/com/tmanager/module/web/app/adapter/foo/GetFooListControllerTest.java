package com.tmanager.module.web.app.adapter.foo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.tmanager.module.web.app.adapter.foo.cases.GetFooListController;
import com.tmanager.module.web.app.adapter.foo.dto.FooWeb;

@RunWith(SpringRunner.class)
@WebMvcTest(GetFooListController.class)
public class GetFooListControllerTest {

    @Autowired
    private GetFooListService fooService;
    
	@Test
	public void getFooListController(){
		
		List<FooWeb> foos = fooService.getFooListService.getFoo().stream()
					            .map(foo -> new FooWeb(foo.getId(), foo.getName()))
					            .collect(Collectors.toList());
		
		Assert.notEmpty(foos, "Empty foos list");
	}
}
