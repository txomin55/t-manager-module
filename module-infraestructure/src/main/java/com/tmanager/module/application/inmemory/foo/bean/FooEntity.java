package com.tmanager.module.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.tmanager.module.domain.model.Foo;

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
