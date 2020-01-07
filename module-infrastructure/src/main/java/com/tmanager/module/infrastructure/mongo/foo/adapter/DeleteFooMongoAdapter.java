package com.tmanager.module.infrastructure.mongo.foo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

public class DeleteFooMongoAdapter implements DeleteFooPersistancePort {

    @Autowired
    private MongoTemplate mongoTemplate;
    
	@Override
	public void deleteFoo(String id) {
		
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), MongoFooEntity.class);
	}
}
