package com.tmanager.module.infrastructure.mongo.foo.cases;

import static org.assertj.core.api.Assertions.assertThat;

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

import com.tmanager.module.infrastructure.mongo.foo.FooMongoAdapterConfiguration;
import com.tmanager.module.infrastructure.mongo.foo.entity.MongoFooEntity;

@Ignore
@RunWith(SpringRunner.class)
@TestPropertySource(locations={"classpath:application.yml", "classpath:application-develop-mongo.yml"})
@ContextConfiguration(initializers={ConfigFileApplicationContextInitializer.class}, classes= {FooMongoAdapterConfiguration.class})
@SpringBootTest
public class CreateFooMongoAdapterTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
    
	@Test
	public void createFooMongoAdapter(){
		
		MongoFooEntity fooEnt = new MongoFooEntity("1", "name", "value", "1");
		
		mongoTemplate.save(fooEnt);

        assertThat(mongoTemplate.findAll(MongoFooEntity.class)).extracting("key")
            .containsOnly("id");
	}
}
