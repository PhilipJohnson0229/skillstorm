package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import control.BeanController;
import data.TestDao;

@Configuration
public class SpringConfig {

	public static void main(String[] args) {
		//start the spring app by creating the IOC container
		//ioc - Bean Factory
		//this line takes all methods anotated with bean within this class and stores them in ioc container
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		BeanController controller = context.getBean(BeanController.class);
		controller.callDao();
		
		
	}
	//bean definitions
	@Bean //tells spring to create a bean and put it in the ioc
	public TestDao testDao() 
	{
		return new TestDao();
	}
	
	@Bean
	public BeanController expenseController() 
	{
		//spring works with setters and constructors
		//Dependencies are mapped through either one of these
		BeanController beanController = new BeanController();
		beanController.setTestDao(testDao());
		return beanController;
	}
}
