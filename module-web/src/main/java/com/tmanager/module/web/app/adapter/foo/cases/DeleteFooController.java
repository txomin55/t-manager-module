package com.tmanager.module.web.app.adapter.foo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.application.foo.shared.command.FooDeleteCommand;
import com.tmanager.module.web.app.adapter.foo.FooOperations;

@RestController
public class DeleteFooController implements FooOperations{

    @Autowired
    private DeleteFooService deleteFooService;

    @Autowired
    public DeleteFooController(DeleteFooService deleteFooService) {
        this.deleteFooService = deleteFooService;
    }
    
    @DeleteMapping("/{id}")
    public void deleteFoo(@PathVariable int id) {
    	deleteFooService.deleteFoo(new FooDeleteCommand(id));
    }
}
