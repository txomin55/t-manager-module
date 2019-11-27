package com.tmanager.module.domain.foo.port;

import com.tmanager.module.domain.foo.model.Foo;

public interface GetFooPersistancePort {

	Foo getFoo(String id);
}
