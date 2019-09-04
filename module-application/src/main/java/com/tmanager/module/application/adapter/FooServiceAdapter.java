package com.tmanager.module.application.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmanager.module.application.api.FooService;
import com.tmanager.module.application.shared.FooDTO;
import com.tmanager.module.domain.model.Foo;
import com.tmanager.module.domain.spi.FooPersistancePort;

public class FooServiceAdapter implements FooService{

    private FooPersistancePort fooPersistancePort;

    @Autowired
    public FooServiceAdapter(FooPersistancePort fooPersistancePort) {
        this.fooPersistancePort = fooPersistancePort;
    }
    
	@Override
	public void createFoo(FooDTO fooDto) {

		Foo foo = new Foo(fooDto.getId());
		fooPersistancePort.fooMethod(foo);
	}

	@Override
	public void deleteFoo(int id) {
		fooPersistancePort.deleteFoo(id);
	}

	@Override
	public List<FooDTO> getFoo() {
		List<Foo> foos = fooPersistancePort.getFoo();
		
		return foos.stream()
				.map(foo -> new FooDTO(foo.getId()))
				.collect(Collectors.toList());
	}

}
