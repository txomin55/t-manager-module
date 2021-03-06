package com.tmanager.module.application.foo.adapter;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

public class CreateFooServiceAdapter implements CreateFooService {

	private CreateFooPersistancePort fooPersistancePort;

    @Autowired
    public CreateFooServiceAdapter(CreateFooPersistancePort fooPersistancePort) {
        this.fooPersistancePort = fooPersistancePort;
    }

    @Override
    public String createFoo(FooCreateCommand command) {
    	
    	String id = UUID.randomUUID().toString();
        Foo foo = new Foo(id, command.getName(), command.getValue(), command.getOwner());
        fooPersistancePort.createFoo(foo);
        
        return id;
    }
}
