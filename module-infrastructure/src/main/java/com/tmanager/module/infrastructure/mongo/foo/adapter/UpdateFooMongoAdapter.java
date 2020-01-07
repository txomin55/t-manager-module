package com.tmanager.module.infrastructure.mongo.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

public class UpdateFooMongoAdapter implements UpdateFooPersistancePort {

	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public void updateFoo(Foo foo) {
		
        Update update = new Update();
        update.set("name", foo.getName());
        update.set("value", foo.getValue());
        
		mongoTemplate.updateFirst(new Query(Criteria.where("id").is(foo.getId())), update, MongoFooEntity.class);
	}
}
