package com.tmanager.module.application.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooUpdateCommand;
import com.tmanager.module.application.foo.port.UpdateFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;

public class UpdateFooServiceAdapter implements UpdateFooService {
	
	private GetFooPersistancePort getFooPersistancePort;
	
	private UpdateFooPersistancePort fooPersistancePort;

    @Autowired
    public UpdateFooServiceAdapter(UpdateFooPersistancePort fooPersistancePort, GetFooPersistancePort getFooPersistancePort) {
        this.fooPersistancePort = fooPersistancePort;
        this.getFooPersistancePort = getFooPersistancePort;
    }

    @Override
    public void updateFoo(FooUpdateCommand command) {
    	
    	Foo foo = getFooPersistancePort.getFoo(command.getId());
    	foo.setName(command.getName());
    	foo.setValue(command.getValue());
    	
        fooPersistancePort.updateFoo(foo);        
    }
}