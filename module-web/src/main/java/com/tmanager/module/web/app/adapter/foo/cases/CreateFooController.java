package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.CreateFooWeb;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;

@RestController
public class CreateFooController implements FooOperations {

    @Autowired
    private CreateFooService fooService;

    @Autowired
    public CreateFooController(CreateFooService fooService) {
        this.fooService = fooService;
    }

    @PostMapping
    public GetFooWeb createFoo(@RequestBody CreateFooWeb fooDto) {
        int id = fooService.createFoo(new FooCreateCommand(fooDto.getName(), fooDto.getValue()));
        return new GetFooWeb(id, fooDto.getName(), fooDto.getValue());
    }
}
