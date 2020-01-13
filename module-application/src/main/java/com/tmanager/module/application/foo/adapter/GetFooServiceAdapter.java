package com.tmanager.module.application.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.application.foo.port.GetFooService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.exception.CustomException;
import com.tmanager.module.exception.error.ErrorEnum;

public class GetFooServiceAdapter implements GetFooService {

	private GetFooPersistancePort getFooPersistancePort;

	@Autowired
	public GetFooServiceAdapter(GetFooPersistancePort getFooPersistancePort) {
		this.getFooPersistancePort = getFooPersistancePort;
	}

	@Override
	public FooDTO getFoo(FooGetCommand command) throws CustomException {
				
		Foo foo = getFooPersistancePort.getFoo(command.getId());
		
		if(!foo.getOwner().equals(command.getOwner())) {
			throw new CustomException(ErrorEnum.UNAUTHORIZED_RESOURCE_ERROR);
		}
		
		return new FooDTO(foo.getId(), foo.getName(), foo.getValue(), foo.getOwner()); 
	}
}
