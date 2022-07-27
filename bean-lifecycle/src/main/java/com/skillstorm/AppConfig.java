package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan("com.skillstorm")
public class AppConfig {

	public static void main(String[] args) {
		//ApplicationContext IS-A BeanFactory
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // 1
		//context.getBean(SpringBean.class).service();
		//context.getBean(SpringBean.class).service();
		//context.getBean(SpringBean.class).service();
		context.close();
	}
	
	@Bean(initMethod = "init", destroyMethod = "destruction")
	public SpringBean springBean() {
		return new SpringBean();
	}
	
}
