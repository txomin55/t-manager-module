package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.command.FooUpdateCommand;

public interface UpdateFooService {

	void updateFoo(FooUpdateCommand command);
}
