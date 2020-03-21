package com.tmanager.module.infrastructure.mongo.foo.cases;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.tmanager.module.domain.foo.model.Foo;
import com.tmanager.module.infrastructure.mongo.foo.FooMongoAdapterConfiguration;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

@Ignore
@RunWith(SpringRunner.class)
@TestPropertySource(locations={"classpath:application.yml", "classpath:application-develop-mongo.yml"})
@ContextConfiguration(initializers={ConfigFileApplicationContextInitializer.class}, classes= {FooMongoAdapterConfiguration.class})
@SpringBootTest
public class UpdateFooMongoAdapterTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void updateFooInMemoryAdapter(){
		
		MongoFooEntity fooEnt = new MongoFooEntity("1", "name", "value", "1");
		mongoTemplate.save(fooEnt);
		
		Foo foo = new Foo("1", "UPDATED", "value", "1");
		
        Update update = new Update();
        update.set("name", foo.getName());
        update.set("value", foo.getValue());
        
		mongoTemplate.updateFirst(new Query(Criteria.where("id").is(foo.getId())), update, MongoFooEntity.class);
		
		MongoFooEntity updated = mongoTemplate.findById(fooEnt.getId(), MongoFooEntity.class);
		
		assertThat("Element not updated", updated.getName().equals("UPDATED"));
	}
}
