package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.shared.command.FooCreateCommand;

public interface CreateFooService {

	void createFoo(FooCreateCommand command);
} 
