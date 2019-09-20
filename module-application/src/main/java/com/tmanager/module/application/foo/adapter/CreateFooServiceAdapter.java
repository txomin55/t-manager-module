package com.tmanager.module.application.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.application.foo.shared.command.FooCreateCommand;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

public class CreateFooServiceAdapter implements CreateFooService {

    private CreateFooPersistancePort fooPersistancePort;

    @Autowired
    public CreateFooServiceAdapter(CreateFooPersistancePort fooPersistancePort) {
        this.fooPersistancePort = fooPersistancePort;
    }

    @Override
    public void createFoo(FooCreateCommand command) {
        Foo foo = new Foo(command.getId(), command.getName());
        fooPersistancePort.fooMethod(foo);
    }
}
