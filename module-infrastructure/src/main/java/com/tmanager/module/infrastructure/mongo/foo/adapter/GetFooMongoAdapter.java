package com.tmanager.module.infrastructure.mongo.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

public class GetFooMongoAdapter implements GetFooPersistancePort {

	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public Foo getFoo(String id) {
		
		MongoFooEntity fooEnt = mongoTemplate.findById(id, MongoFooEntity.class);
		
		return new Foo(fooEnt.getId(), fooEnt.getName(), fooEnt.getValue(), fooEnt.getOwner());
	}
}
