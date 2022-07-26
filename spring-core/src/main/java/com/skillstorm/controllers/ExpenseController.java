package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.skillstorm.data.ExpenseDAO;

public class ExpenseController {

	@Autowired // looks inside the IOC container for an "ExpenseDAO" bean then INJECTS
	 // @Primary and @Qualifier
	@Qualifier("hibernateDAO") // specify which bean to use (when I have multiple autowired candidates) byType
	private ExpenseDAO dao; // NOT new DAO()
	
	public ExpenseController() {
		System.out.println("new ExpenseController()");
	}
	
	public void callDao() {
		dao.go();
	}

	public void setDao(ExpenseDAO dao) {
		this.dao = dao;
	}
	
}
