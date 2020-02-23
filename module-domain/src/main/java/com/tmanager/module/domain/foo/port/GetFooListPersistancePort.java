package com.tmanager.module.domain.foo.port;

import java.util.List;

import com.tmanager.module.domain.foo.model.FooList;

public interface GetFooListPersistancePort {

	List<FooList> getFoo(String owner);
}
