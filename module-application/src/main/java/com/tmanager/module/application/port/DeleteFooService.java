package com.tmanager.module.application.port;

import com.tmanager.module.application.shared.command.FooDeleteCommand;

public interface DeleteFooService {
	
	void deleteFoo(FooDeleteCommand command);
}
