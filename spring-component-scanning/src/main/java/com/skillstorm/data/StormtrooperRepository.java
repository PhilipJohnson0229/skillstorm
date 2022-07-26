package com.skillstorm.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository // accessing the database
public class StormtrooperRepository {

	// key from our environment
	// #{systemEnvironment}   operating system variables
	// #{ssytemProperties}    JVM system variables
	@Value("${jdbc.datasource.url}") // SpEL 
	public String url;
	
	@Value("${jdbc.datasource.user}")
	private String user;
	
	@Value("${jdbc.datasource.pass}")
	private String pass;

	public StormtrooperRepository() {
		System.out.println("new StormtrooperRepository()");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
