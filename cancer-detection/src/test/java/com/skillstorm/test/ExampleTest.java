package com.skillstorm.test;

import com.skillstorm.code.ApplicationComponent;

// junit.framework - most times they work. sometimes... not so much
// org.junit - work as expected
import org.junit.Assert; // deprecated (isn't supported anymore)
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*; // import all static methods

// src/test/java
// JavaCoCo (Java Code Coverage)
//in src/test/java *Test.java get run by Maven
public class ExampleTest { 
	
	static ApplicationComponent component; 
	
	// before all my tests - run this setup method
	@BeforeClass // @BeforeAll
	public static void setupBeforeAll() {
		 component = new ApplicationComponent();
	}

	@Test // tells JUnit that this is a test method (Test case)
	public void testOver18() {
		
		boolean actual = component.checkThatTheCustomerAgeIsOverEighteenYearsOld(25); // actual
		// expect to get true
		boolean expected = true;

		// Assert methods - if(expected == actual) else throw new AssertionException
		assertEquals(expected, actual);
	}
	
	// positive testing - valid inputs
	@Test
	public void testUnder18() {
		assertEquals(false, component.checkThatTheCustomerAgeIsOverEighteenYearsOld(12));
	}

	// negative testing - testing invalid inputs
	// expected == fail the test if the exception is not thrown
	@Test(expected = IllegalArgumentException.class) // unhandled exceptions will FAIL test method
	public void testUnderZero() {
		component.checkThatTheCustomerAgeIsOverEighteenYearsOld(-1);
	}
	
	/// TDD - Write Tests First
	@Test
	public void testUnder21() {
		assertEquals(false, component.checkId(20, "beer"));
	}
	
	@Test
	public void testOver21() {
		assertEquals(true, component.checkId(21, "beer"));
	}
	
}






