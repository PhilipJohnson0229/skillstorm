package com.skillstorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.data.StormtrooperRepository;

@Service // logic
public class StormtrooperService {
	
	public StormtrooperService() {
		System.out.println("new StormtrooperService()");
	}

	@Autowired
	private StormtrooperRepository repository;
	
}
