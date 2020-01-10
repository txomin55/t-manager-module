package com.tmanager.module.application.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;

public class GetFooServiceAdapter implements GetFooService {

	private GetFooPersistancePort getFooPersistancePort;

	@Autowired
	public GetFooServiceAdapter(GetFooPersistancePort getFooPersistancePort) {
		this.getFooPersistancePort = getFooPersistancePort;
	}

	@Override
	public FooDTO getFoo(FooGetCommand command) {
				
		Foo foo = getFooPersistancePort.getFoo(command.getId());
		
		if(!foo.getOwner().equals(command.getOwner())) {
			
		}
		
		return new FooDTO(foo.getId(), foo.getName(), foo.getValue(), foo.getOwner()); 
	}
}
