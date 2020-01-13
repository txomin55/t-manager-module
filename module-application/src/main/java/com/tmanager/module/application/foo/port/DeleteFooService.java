package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.command.FooDeleteCommand;
import com.tmanager.module.exception.CustomException;

public interface DeleteFooService {

	void deleteFoo(FooDeleteCommand command) throws CustomException;
}
