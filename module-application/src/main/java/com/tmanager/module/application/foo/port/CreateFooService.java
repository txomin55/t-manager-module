package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.command.FooCreateCommand;

public interface CreateFooService {

	int createFoo(FooCreateCommand command);
}
