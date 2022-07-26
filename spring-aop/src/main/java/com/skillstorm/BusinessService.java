package com.skillstorm;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {

	public void go() {
		System.out.println("BusinessService.go()");
	}
	
	public boolean goToWork(boolean weekday, boolean holiday) {
		System.out.println("BusinessService.goToWork()");
		if(new Random().nextBoolean()) throw new RuntimeException(); //sick
		return weekday && !holiday;
	}
	
	
	
}
