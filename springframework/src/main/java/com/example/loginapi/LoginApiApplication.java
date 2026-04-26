package com.example.loginapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableMongoRepositories(basePackages = "com.example")
public class LoginApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApiApplication.class, args);
	}

}
