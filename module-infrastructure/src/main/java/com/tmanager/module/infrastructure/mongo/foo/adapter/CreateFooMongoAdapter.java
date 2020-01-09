package com.tmanager.module.infrastructure.mongo.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

public class CreateFooMongoAdapter implements CreateFooPersistancePort {

    @Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public void createFoo(Foo foo) {
		
		mongoTemplate.save(new MongoFooEntity(foo));
	}
}
