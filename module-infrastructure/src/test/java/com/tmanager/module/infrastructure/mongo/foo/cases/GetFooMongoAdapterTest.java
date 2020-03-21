package com.tmanager.module.infrastructure.mongo.foo.cases;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
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
public class GetFooMongoAdapterTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void getFooInMemoryAdapter(){
		
		MongoFooEntity createdFooEnt = new MongoFooEntity(UUID.randomUUID().toString(), "name", "value", "1");
		mongoTemplate.save(createdFooEnt);
		
		MongoFooEntity fooEnt = mongoTemplate.findById(createdFooEnt.getId(), MongoFooEntity.class);
		Foo foo = new Foo(fooEnt.getId(), fooEnt.getName(), fooEnt.getValue(), fooEnt.getOwner());
		
		assertThat(foo, is(foo.getId() != null));
	}
}
