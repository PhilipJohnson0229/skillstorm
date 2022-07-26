package com.skillstorm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.skillstorm.beans.Expense;
import com.skillstorm.data.ExpenseDAO;
import com.skillstorm.data.ExpenseDAOHibernateImpl;
import com.skillstorm.data.ExpenseDAOImpl;

@Configuration
public class DatabaseLayerConfig {
	
	@Bean //Singleton
	@Scope("prototype") // calling context.getBean produces a brand NEW object
	public Expense expense() {
		return new Expense();
	}

	// Bean definitions - tells Spring to manage these beans
	@Bean
	@Scope("singleton")
	@Primary // if more than 1 candidate for autowiring, use this by default
	public ExpenseDAO expenseDAO() {
		return new ExpenseDAOImpl();
	}
	
	@Bean
	public ExpenseDAO hibernateDAO() {
		return new ExpenseDAOHibernateImpl(); // ExpenseController needs an ExpenseDAO (2+ exception)
	}
	
}
