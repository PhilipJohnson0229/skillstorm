package com.InventoryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtInventoryManagementApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//runs through BCrypt algorythm 10 times
		return new BCryptPasswordEncoder();  // 10 rounds salt.
		
	}


}
