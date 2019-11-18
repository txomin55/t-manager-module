package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.command.FooUpdateCommand;
import com.tmanager.module.application.foo.port.UpdateFooService;
import com.tmanager.module.web.app.adapter.foo.FooOperations;
import com.tmanager.module.web.app.adapter.foo.dto.GetFooWeb;
import com.tmanager.module.web.app.adapter.foo.dto.UpdateFooWeb;

@RestController
public class UpdateFooController implements FooOperations {

    @Autowired
    private UpdateFooService fooService;

    @Autowired
    public UpdateFooController(UpdateFooService fooService) {
        this.fooService = fooService;
    }

    @PutMapping
    public GetFooWeb createFoo(@RequestBody UpdateFooWeb fooDto) {
        fooService.updateFoo(new FooUpdateCommand(fooDto.getId(), fooDto.getName(), fooDto.getValue()));
        return new GetFooWeb(fooDto.getId(), fooDto.getName(), fooDto.getValue());
    }
}
