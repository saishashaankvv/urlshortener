package com.assignment.urlshortener.Config;

import com.assignment.urlshortener.Commons.Constants;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;


public class MongoDBConfig {

    public static MongoTemplate getMongoTemplate(){
        return new MongoTemplate(new MongoClient(Constants.HOST_NAME,Constants.DATABASE_PORT_NUMBER), Constants.DATABASE_NAME);
    }

}
