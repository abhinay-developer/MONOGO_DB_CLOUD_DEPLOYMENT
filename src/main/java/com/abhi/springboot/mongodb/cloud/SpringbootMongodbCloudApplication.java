package com.abhi.springboot.mongodb.cloud;

import com.abhi.springboot.mongodb.cloud.repository.UserRepository;
import org.apache.tomcat.jni.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringbootMongodbCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbCloudApplication.class, args);
	}

}
