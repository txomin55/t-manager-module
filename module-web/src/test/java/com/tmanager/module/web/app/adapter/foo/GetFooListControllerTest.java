package com.tmanager.module.web.app.adapter.foo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.web.app.adapter.foo.dto.FooWeb;

@RunWith(MockitoJUnitRunner.class)
public class GetFooListControllerTest {

    @Autowired
    private GetFooListService getFooListService;
    
	@Test
	public void getFooListController(){
		
		List<FooWeb> foos = getFooListService.getFoo().stream()
					            .map(foo -> new FooWeb(foo.getId(), foo.getName()))
					            .collect(Collectors.toList());
		
		Assert.notEmpty(foos, "Empty foos list");
	}
}
