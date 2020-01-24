package com.tmanager.module.configuration.adapters.foo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.tmanager.module.domain.foo.port.CreateFooPersistancePort;
import com.tmanager.module.domain.foo.port.DeleteFooPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooListPersistancePort;
import com.tmanager.module.domain.foo.port.GetFooPersistancePort;
import com.tmanager.module.domain.foo.port.UpdateFooPersistancePort;
import com.tmanager.module.infrastructure.mongo.foo.adapter.CreateFooMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.DeleteFooMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.GetFooListMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.GetFooMongoAdapter;
import com.tmanager.module.infrastructure.mongo.foo.adapter.UpdateFooMongoAdapter;

@Configuration
@Profile({ "develop-mongo", "production-mongo" })
public class FooMongoAdapterConfiguration extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.authentication-database}")
	private String authenticationDatabase;

	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port}")
	private Integer mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String mongoDatabaseName;

	@Value("${spring.data.mongodb.username}")
	private String username;

	@Value("${spring.data.mongodb.password}")
	private String password;

	@Bean
	public CreateFooPersistancePort fooPersistancePort() {
		return new CreateFooMongoAdapter();
	}

	@Bean
	public GetFooListPersistancePort getFooListPersistancePort() {
		return new GetFooListMongoAdapter();
	}

	@Bean
	public DeleteFooPersistancePort deleteFooPersistancePort() {
		return new DeleteFooMongoAdapter();
	}

	@Bean
	public UpdateFooPersistancePort updateFooPersistancePort() {
		return new UpdateFooMongoAdapter();
	}

	@Bean
	public GetFooPersistancePort getFooPersistancePort() {
		return new GetFooMongoAdapter();
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(new ServerAddress(mongoHost, mongoPort),
				MongoCredential.createCredential(username, authenticationDatabase, password.toCharArray()),
				MongoClientOptions.builder().applicationName(mongoDatabaseName).build());
	}

	@Override
	protected String getDatabaseName() {
		return mongoDatabaseName;
	}
}
