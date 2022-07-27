package com.InventoryManagement;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

import com.InventoryManagement.controllers.ItemController;
import com.InventoryManagement.data.ItemRepo;
import com.InventoryManagement.data.ItemDaoImpl;

//@Import({DatabaseLayerConfig.class}) //if we wanted to load stuff manually with a ton of annotations
//the main config file that will import other config files
//all of our spring configuration is done here
//the controller is decoupled from the dao and is unaware of its creation thanks to this config file through spring
//@PropertySource("classpath:application.properties") // load these properties into the Environment
@Configuration
@ComponentScan(basePackages = {"com.InventoryManagement"})
public class SpringConfig {
	public static void main(String[] args) {
		//start the spring app by creating the IOC container
		//ioc - Bean Factory
		//this line takes all methods anotated with bean within this class and stores them in ioc container
		//singletons are eagerly loaded
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		context.close();
		
		
		
	}
	//bean definitions

}
