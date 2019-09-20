package com.tmanager.module.domain.foo.port;

import java.util.List;

import com.tmanager.module.domain.foo.model.Foo;

public interface GetFooListPersistancePort {

	List<Foo> getFoo();
}
