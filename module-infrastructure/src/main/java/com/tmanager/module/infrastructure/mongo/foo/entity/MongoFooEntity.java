package com.tmanager.module.infrastructure.mongo.foo.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tmanager.module.domain.foo.model.Foo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "foo")
@Getter
@Setter
@AllArgsConstructor
public class MongoFooEntity implements Serializable{
	
	private static final long serialVersionUID = -7595011183671841430L;

    private String id;
    private String name;
    private String value;

    public MongoFooEntity(Foo foo) {
        this.id = foo.getId();
        this.name = foo.getName();
        this.value = foo.getValue();
    }
}
