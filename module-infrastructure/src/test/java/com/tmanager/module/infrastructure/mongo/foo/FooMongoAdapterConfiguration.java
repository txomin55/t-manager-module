package com.tmanager.module.infrastructure.mongo.foo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
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
