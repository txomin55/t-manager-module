package com.tmanager.module.application.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.application.foo.port.DeleteFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.exception.CustomException;
import com.tmanager.module.exception.error.ErrorEnum;

public class DeleteFooServiceAdapter implements DeleteFooService {

    private DeleteFooPersistancePort deleteFooPersistancePort;
    private GetFooPersistancePort getFooPersistancePort;

    @Autowired
    public DeleteFooServiceAdapter(DeleteFooPersistancePort deleteFooPersistancePort, GetFooPersistancePort getFooPersistancePort) {
        this.deleteFooPersistancePort = deleteFooPersistancePort;
        this.getFooPersistancePort = getFooPersistancePort;
    }

    @Override
    public void deleteFoo(FooDeleteCommand command) throws CustomException {
    	
    	Foo foo = getFooPersistancePort.getFoo(command.getId());
    	
    	if(!foo.getOwner().equals(command.getOwner())) {
    		throw new CustomException(ErrorEnum.UNAUTHORIZED_RESOURCE_ERROR);
    	}
    	
        deleteFooPersistancePort.deleteFoo(command.getId());
    }
}
