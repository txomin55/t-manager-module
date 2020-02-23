package com.tmanager.module.application.foo.port;

import java.util.List;

import com.tmanager.module.application.foo.dto.FooListDTO;

public interface GetFooListService {

	List<FooListDTO> getFoo(String owner);
}
