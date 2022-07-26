package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.skillstorm.service.StormtrooperService;

// Stereotype annotations


@Controller // exact same as @Component 
// register itself with Spring
// minimize the @Bean definitions in your @Configuration files
@Profile("dev") // this bean is only created when spring.profiles.active=dev
public class StormtrooperController {
	
	public StormtrooperController() {
		System.out.println("new StormtrooperController()");
	}

	@Autowired
	private StormtrooperService service;
	
}
