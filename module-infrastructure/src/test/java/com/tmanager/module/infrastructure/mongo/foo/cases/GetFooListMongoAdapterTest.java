package com.tmanager.module.infrastructure.mongo.foo.cases;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
public class GetFooListMongoAdapterTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void getFooListInMemoryAdapter(){
		
		String owner = "1";
		
		MongoFooEntity fooEnt = new MongoFooEntity("1", "name", "value", owner);
		mongoTemplate.save(fooEnt);
		
		ArrayList<Foo> foos = new ArrayList<Foo>(mongoTemplate.find(new Query(Criteria.where("owner").is(owner)), MongoFooEntity.class).stream().map(foo -> {
			return new Foo(foo.getId(), foo.getName(), foo.getValue(), foo.getOwner());
		}).collect(Collectors.toList()));
		
		assertThat(foos, not(IsEmptyCollection.empty()));
	}
}
 