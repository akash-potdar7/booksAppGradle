package com.angularSpringBootApp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.akash.booksApp"})
@EnableJpaRepositories("com.akash.booksApp.app.repo")
@EntityScan(basePackages = {"com.akash.booksApp.app.entity"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}

}