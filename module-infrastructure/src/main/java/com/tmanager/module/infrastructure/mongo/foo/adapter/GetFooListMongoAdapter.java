package com.tmanager.module.infrastructure.mongo.foo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

public class GetFooListMongoAdapter implements GetFooListPersistancePort {

    @Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public List<Foo> getFoo(String owner) {
		return new ArrayList<Foo>(mongoTemplate.find(new Query(Criteria.where("owner").is(owner)), MongoFooEntity.class).stream().map(foo -> {
			return new Foo(foo.getId(), foo.getName(), foo.getValue(), foo.getOwner());
		}).collect(Collectors.toList()));
	}
}
