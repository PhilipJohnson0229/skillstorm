package com.InventoryManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.dto.IMUserDTO;
import com.InventoryManagement.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping(value = "/register")
	public ResponseEntity<Void> register(@RequestBody IMUserDTO dto) {
		service.register(dto.getUsername(), dto.getPassword());
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login-check")
	public ResponseEntity<Void> login() {
		return ResponseEntity.ok().build();
	}

}
