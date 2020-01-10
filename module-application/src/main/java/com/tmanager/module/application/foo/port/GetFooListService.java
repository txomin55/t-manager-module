package com.tmanager.module.application.foo.port;

import java.util.List;

import com.tmanager.module.application.foo.dto.FooDTO;

public interface GetFooListService {

	List<FooDTO> getFoo(String owner);
}
