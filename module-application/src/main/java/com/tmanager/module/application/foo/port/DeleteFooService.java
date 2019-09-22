package com.tmanager.module.application.foo.port;

import com.tmanager.module.application.foo.command.FooDeleteCommand;

public interface DeleteFooService {

	void deleteFoo(FooDeleteCommand command);
}
