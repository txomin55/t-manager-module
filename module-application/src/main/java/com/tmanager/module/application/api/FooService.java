package com.tmanager.module.application.api;

import java.util.List;

import com.tmanager.module.application.shared.FooDTO;

public interface FooService {

	void createFoo(FooDTO fooDto);

	void deleteFoo(int id);

	List<FooDTO> getFoo();
} 
