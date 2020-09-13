package com.web.covid.tracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Override
	public MongoClient mongoClient() {
MongoClient mongoClient = MongoClients.create(
    "mongodb+srv://avinash:avinash@cluster0-5c9s5.mongodb.net/test?retryWrites=true&w=majority");
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		MongoDatabase mongoDb = mongoClient().getDatabase("winrisk");
		String db = mongoDb.getName();
		System.out.println("db "+db);
		return "winrisk";
	}

}
