package com.tmanager.module.application.port;

import com.tmanager.module.application.shared.command.FooCreateCommand;

public interface CreateFooService {

	void createFoo(FooCreateCommand command);
} 
