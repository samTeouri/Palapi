package com.tp_spring.palapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PalapiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PalapiApplication.class, args);
		System.out.println("Swagger : -> http://localhost:8080/swagger-ui/index.html");
	}

}