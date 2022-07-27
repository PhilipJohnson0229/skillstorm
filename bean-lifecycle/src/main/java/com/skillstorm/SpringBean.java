package com.skillstorm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Component
public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, // get a prototype
	InitializingBean, DisposableBean, AutoCloseable{ 
	
	// "Aware" that it exists in the Spring IoC container
	private String beanName;
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;
	
	@Value("hello")
	private String value;
	
	//@Autowired
	//private AnotherBean bean; // reflection

	public SpringBean() {
		System.out.println("Instantiate");
		// your fields haven't been initialized
		//System.out.println(value + " " + bean);
	}

	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("Populate properties");
		System.out.println("BeanNameAware");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("ApplicationContextAware");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("BeanFactoryAware");
	}

	// init
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean");
	}
	
	public void init() throws Exception {
		System.out.println("Custom init()");
	}
	
	// in service
	public void service() {
		System.out.println("Making a bean.. " + this.applicationContext.getBean(AnotherBean.class)); // create prototype beans
	}

	// destroy
	public void destroy() throws Exception {
		System.out.println("DisposableBean");
	}	
	
	public void destruction() {
		System.out.println("Custom destroy()");
	}

	public void close() throws Exception {
		System.out.println("Autocloseable");
	}
	
}
