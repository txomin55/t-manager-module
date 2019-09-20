package com.tmanager.module.application.port;

import java.util.List;

import com.tmanager.module.application.shared.dto.FooDTO;

public interface GetFooListService {

	List<FooDTO> getFoo();
}
