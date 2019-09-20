package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.application.foo.shared.command.FooCreateCommand;
import com.tmanager.module.application.foo.shared.dto.FooDTO;
import com.tmanager.module.web.app.adapter.foo.FooOperations;

@RestController
public class CreateFooController implements FooOperations{

    @Autowired
    private CreateFooService fooService;

    @Autowired
    public CreateFooController(CreateFooService fooService) {
        this.fooService = fooService;
    }
    
    @PostMapping
    public void createFoo(@RequestBody FooDTO fooDto) {
    	fooService.createFoo(new FooCreateCommand(fooDto.getId(), fooDto.getName()));
    }
}
