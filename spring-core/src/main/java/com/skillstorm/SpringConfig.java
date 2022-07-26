package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.skillstorm.beans.Expense;
import com.skillstorm.controllers.ExpenseController;

@Configuration // 1 main config that imports other configs
@Import({
	DatabaseLayerConfig.class
})
public class SpringConfig {
	
	public static void main(String[] args) {
		// start a Spring App - by creating the IoC Container
		// IoC - BeanFactory / ApplicationContext
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// ApplicationContext - preinitialize singleton beans
		ExpenseController controller = context.getBean(ExpenseController.class);
		controller.callDao();
		// Singleton beans - default (bean scope)
		System.out.println("----------------Singleton @Scope------------------");
		System.out.println(context.getBean(ExpenseController.class)); // always
		System.out.println(context.getBean(ExpenseController.class));// the same
		System.out.println(context.getBean(ExpenseController.class));// object
		
		System.out.println("----------------Prototype @Scope------------------");
		System.out.println(context.getBean(Expense.class)); // brand
		System.out.println(context.getBean(Expense.class)); // new
		System.out.println(context.getBean(Expense.class)); // instance
	}
	
	@Bean
	public ExpenseController expenseController() {
		// call a setter, or use a constructor (constructor injection or setter injection)
		ExpenseController controller = new ExpenseController();
		// controller.setDao(expenseDAO()); // DI - bean wiring (manual wiring) OR auto-wiring
		return controller;
	}
	
}
