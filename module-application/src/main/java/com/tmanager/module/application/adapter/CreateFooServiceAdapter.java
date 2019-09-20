package com.tmanager.module.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.port.CreateFooService;
import com.tmanager.module.application.shared.command.FooCreateCommand;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

public class CreateFooServiceAdapter implements CreateFooService{

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
