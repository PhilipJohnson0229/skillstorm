package com.skillstorm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	// always?
	@Around("pointcutExpression()")  /// Transactions, Exception Handler (MVC), Security
	public Object aroundAdvice(ProceedingJoinPoint method) {
		System.out.println("Before");
		Object returnValue = null;
		try {
			System.out.println("Executing " + method.getSignature());
			returnValue = method.proceed(); // invoke method
		} catch (Throwable e) {
			// handle the exception / unlike @AfterThrowing
			System.out.println("Caught exception " + e.getClass());
		}
		// CAN mutate the returnValue / unlike AfterReturning
		returnValue = false;
		System.out.println("After");
		return returnValue;
	}

	// after *successfully* returning a value
	// @AfterReturning(pointcut = "pointcutExpression()", returning = "arg")
	public void afterReturning(Object arg) {
		System.out.println("@AfterReturning " + arg); // the value cannot be changed
	}

	// after *unsuccessfully* returning a value
	@AfterThrowing(pointcut = "pointcutExpression()", throwing = "exception")
	public void afterThrowing(Exception exception) {
		// does NOT CATCH the exception
		System.out.println("@AfterThrowing " + exception.getClass());
	}

	// advice - Before, After
	// @Before("pointcutExpression()") // any method with the signature "public void
	// go()"
	public void beforeGoMethod() {
		System.out.println("@Before advice");
	}

	// pointcut expression
	// @After("pointcutExpression()") // any method with the signature "public void
	// go()"
	public void afterGoMethod() {
		System.out.println("@After advice");
	}

	@Pointcut("within(com.skillstorm.*)") // DRY
	public void pointcutExpression() {
	}

}
