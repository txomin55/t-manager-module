package com.tmanager.module.application.foo.adapter;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooCreateCommand;
import com.tmanager.module.application.foo.port.CreateFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;

public class CreateFooServiceAdapter implements CreateFooService {

    private static final int MINIMUM = 0;
	private static final int MAXIMUM = 1000;
	
	private CreateFooPersistancePort fooPersistancePort;

    @Autowired
    public CreateFooServiceAdapter(CreateFooPersistancePort fooPersistancePort) {
        this.fooPersistancePort = fooPersistancePort;
    }

    @Override
    public int createFoo(FooCreateCommand command) {
    	
    	Random rand = new Random();
    	int randomNum = MINIMUM + rand.nextInt((MAXIMUM - MINIMUM) + 1);
        Foo foo = new Foo(randomNum, command.getName());
        fooPersistancePort.fooMethod(foo);
        
        return randomNum;
    }
}
