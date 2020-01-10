package com.tmanager.module.application.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;

public class DeleteFooServiceAdapter implements DeleteFooService {

    private DeleteFooPersistancePort deleteFooPersistancePort;
    private GetFooPersistancePort getFooPersistancePort;

    @Autowired
    public DeleteFooServiceAdapter(DeleteFooPersistancePort deleteFooPersistancePort) {
        this.deleteFooPersistancePort = deleteFooPersistancePort;
    }

    @Override
    public void deleteFoo(FooDeleteCommand command) {
    	
    	Foo foo = getFooPersistancePort.getFoo(command.getId());
    	
    	if(!foo.getOwner().equals(command.getOwner())) {
    		
    	}
    	
        deleteFooPersistancePort.deleteFoo(command.getId());
    }
}
