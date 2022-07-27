package com.InventoryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ChinnokRestClient {

	private String baseUrl;
	
	private String trackApi = "/tracks";
	
	//capable of making HTTP calls in java
	//implements template design pattern
	//@Autowired
	private RestTemplate template = new RestTemplate();
	
	public Long getTrackCount() 
	{
		try 
		{
			String url = baseUrl + trackApi + "/count";
			
			ResponseEntity<Long> response = template.getForEntity(url, Long.class);
			System.out.println("Server sent a response code: " + response.getStatusCodeValue());
			return response.getBody();
			
		}catch(HttpClientErrorException e) 
		{
			e.printStackTrace();
			return 0L;
		}catch(HttpServerErrorException e) 
		{
			System.out.println("Server having some error");
			return 0L;
		}
		
	}
}
