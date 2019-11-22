package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;

@RestController
public class GetFooController implements FooOperations {

    @Autowired
    private GetFooService getFooService;

    @Autowired
    public GetFooController(GetFooService getFooService) {
        this.getFooService = getFooService;
    }

    @GetMapping
    public GetFooWeb getFoos(Integer id) {
    	FooDTO foo = getFooService.getFoo(new FooGetCommand(id));
    	
        return new GetFooWeb(foo.getId(), foo.getName(), foo.getValue());
    }
}
