package com.tmanager.module.application.foo.port;

import java.util.List;

import com.tmanager.module.application.foo.shared.dto.FooDTO;

public interface GetFooListService {

	List<FooDTO> getFoo();
}
