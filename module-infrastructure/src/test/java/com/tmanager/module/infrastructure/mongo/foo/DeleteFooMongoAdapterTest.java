package com.tmanager.module.infrastructure.mongo.foo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

@RunWith(MockitoJUnitRunner.class)
public class DeleteFooMongoAdapterTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void deleteFooListInMemoryAdapter(){
		
		MongoFooEntity fooEnt = new MongoFooEntity("1", "name", "value", "1");
		mongoTemplate.save(fooEnt);
		
		mongoTemplate.remove(new Query(Criteria.where("id").is(fooEnt.getId())), MongoFooEntity.class);
		
        // then
        assertThat(mongoTemplate.findAll(MongoFooEntity.class)).extracting("key")
            .doesNotContain("id");
	}
}
