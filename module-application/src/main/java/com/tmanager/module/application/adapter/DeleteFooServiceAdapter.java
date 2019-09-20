package com.tmanager.module.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.port.DeleteFooService;
import com.tmanager.module.application.shared.command.FooDeleteCommand;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;

public class DeleteFooServiceAdapter implements DeleteFooService{

    private DeleteFooPersistancePort deleteFooPersistancePort;

    @Autowired
    public DeleteFooServiceAdapter(DeleteFooPersistancePort deleteFooPersistancePort) {
        this.deleteFooPersistancePort = deleteFooPersistancePort;
    }

	@Override
	public void deleteFoo(FooDeleteCommand command) {
		deleteFooPersistancePort.deleteFoo(command.getId());
	}

}
