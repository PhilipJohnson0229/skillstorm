package com.skillstorm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// before init methods
		System.out.println("postProcessBeforeInitialization " + beanName );
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// after init methods
		System.out.println("postProcessAfterInitialization " + beanName);
		return bean;
	}
	
}
