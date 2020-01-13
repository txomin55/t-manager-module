package com.tmanager.module.infrastructure.mongo.foo;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

@RunWith(MockitoJUnitRunner.class)
public class UpdateFooMongoAdapterTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void updateFooInMemoryAdapter(){
		
		MongoFooEntity fooEnt = new MongoFooEntity("1", "name", "value", "1");
		mongoTemplate.save(fooEnt);
		
		Foo foo = new Foo("1", "name", "value", "1");
		
        Update update = new Update();
        update.set("name", foo.getName());
        update.set("value", foo.getValue());
        
		mongoTemplate.updateFirst(new Query(Criteria.where("id").is(foo.getId())), update, MongoFooEntity.class);
		
		assertThat(mongoTemplate.findById(fooEnt.getId(), MongoFooEntity.class), not(null));
	}
}
