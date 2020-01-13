package com.tmanager.module.infrastructure.mongo.foo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateFooMongoAdapterTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
    
	@Test
	public void createFooMongoAdapter(){
		
		
		MongoFooEntity fooEnt = new MongoFooEntity("1", "name", "value", "1");
		
		mongoTemplate.save(fooEnt);

        // then
        assertThat(mongoTemplate.findAll(MongoFooEntity.class)).extracting("key")
            .containsOnly("id");
	}
}
