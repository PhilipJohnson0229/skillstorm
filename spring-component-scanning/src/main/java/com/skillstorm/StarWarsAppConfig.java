package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.skillstorm.controllers.StormtrooperController;
import com.skillstorm.data.StormtrooperRepository;

@Configuration
@ComponentScan(basePackages = "com.skillstorm") // basePackage - all subpackages
// Spring Profiles (spring.profiles.active) run in a different profile
@PropertySource("classpath:application-${spring.profiles.active}.properties") // load these properties into the Environment
public class StarWarsAppConfig {

	public static void main(String[] args) {
		// BeanFactory - NOT eagerly load singletons
		ApplicationContext context = new AnnotationConfigApplicationContext(StarWarsAppConfig.class);
		System.out.println(context.getBean(StormtrooperRepository.class).url);
		context.getBean(StormtrooperController.class);

	}

}
