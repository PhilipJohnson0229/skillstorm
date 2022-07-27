package com.InventoryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ComSpringClientApplication implements CommandLineRunner {

	@Autowired
	private ChinnokRestClient client;
	
	public static void main(String[] args) {
		SpringApplication.run(ComSpringClientApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(client.getTrackCount());
	}

}
