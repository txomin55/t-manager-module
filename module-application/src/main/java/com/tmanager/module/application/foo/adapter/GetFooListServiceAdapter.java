package com.tmanager.module.application.foo.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.foo.dto.FooListDTO;
import com.tmanager.module.application.foo.port.GetFooListService;
import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;

public class GetFooListServiceAdapter implements GetFooListService {

	private GetFooListPersistancePort getFooListPersistancePort;

	@Autowired
	public GetFooListServiceAdapter(GetFooListPersistancePort getFooListPersistancePort) {
		this.getFooListPersistancePort = getFooListPersistancePort;
	}

	@Override
	public List<FooListDTO> getFoo(String owner) {
		List<Foo> foos = getFooListPersistancePort.getFoo(owner);

		return foos.stream().map(foo -> new FooListDTO(foo.getId(), foo.getName(), foo.getValue(), foo.getOwner()))
				.collect(Collectors.toList());
	}
}
