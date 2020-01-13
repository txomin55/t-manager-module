package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.command.FooUpdateCommand;
import com.tmanager.module.exception.CustomException;

public interface UpdateFooService {

	void updateFoo(FooUpdateCommand command) throws CustomException;
}
