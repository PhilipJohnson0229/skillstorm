package com.chinook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
@ComponentScan("com.chinook")
@Configuration
@EnableAutoConfiguration
public class ChinookSpringApplication {

	public static void main(String[] args) {
		// creates the ApplicationContext for you
		SpringApplication.run(ChinookSpringApplication.class, args);
	}

}
// /ROOT
