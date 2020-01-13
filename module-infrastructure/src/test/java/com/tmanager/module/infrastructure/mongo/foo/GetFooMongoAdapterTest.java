package com.tmanager.module.infrastructure.mongo.foo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

@RunWith(MockitoJUnitRunner.class)
public class GetFooMongoAdapterTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void getFooInMemoryAdapter(){
		
		MongoFooEntity createdFooEnt = new MongoFooEntity("1", "name", "value", "1");
		mongoTemplate.save(createdFooEnt);
		
		MongoFooEntity fooEnt = mongoTemplate.findById(createdFooEnt.getId(), MongoFooEntity.class);
		Foo foo = new Foo(fooEnt.getId(), fooEnt.getName(), fooEnt.getValue(), fooEnt.getOwner());
		
		assertThat(foo, is(foo.getId().equals("1")));
	}
}
