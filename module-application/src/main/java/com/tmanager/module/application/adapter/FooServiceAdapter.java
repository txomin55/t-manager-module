package com.tmanager.module.application.adapter;

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
	public void fooMethod(FooDTO fooDto) {

		Foo foo = new Foo();
		foo.setId(fooDto.getId());
		
		fooPersistancePort.fooMethod(foo);
	}

}
