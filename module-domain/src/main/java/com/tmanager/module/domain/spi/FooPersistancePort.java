package com.tmanager.module.domain.spi;

import java.util.List;

import com.tmanager.module.domain.model.Foo;

public interface FooPersistancePort {

	void fooMethod(Foo foo);

	void deleteFoo(int id);

	List<Foo> getFoo();
}
