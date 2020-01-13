package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.command.FooGetCommand;
import com.tmanager.module.application.foo.dto.FooDTO;
import com.tmanager.module.exception.CustomException;

public interface GetFooService {

	FooDTO getFoo(FooGetCommand command) throws CustomException;
}
