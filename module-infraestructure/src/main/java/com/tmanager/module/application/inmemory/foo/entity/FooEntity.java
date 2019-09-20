package com.tmanager.module.application.inmemory.foo.entity;

import com.tmanager.module.domain.foo.model.Foo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FooEntity {

    private int id;
    private String name;

    public FooEntity(Foo foo){
        this.id = foo.getId();
        this.name = foo.getName();
    }
}
