package spring;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
public class NoSQLBeans {

    private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "embeded_db";
    
    Logger logger = Logger.getLogger(NoSQLBeans.class);

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {

        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();

        mongo.setBindIp(MONGO_DB_URL);

        try {
        	MongoClient mongoClient = mongo.getObject();

        	MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);

        	return mongoTemplate;
        } catch(Exception e) {
        	logger.debug(e.getMessage());
        	
        	return null;
        }

    }	
	
}
