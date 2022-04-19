package com.project.foodOderingSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class FoodOderingSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FoodOderingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
