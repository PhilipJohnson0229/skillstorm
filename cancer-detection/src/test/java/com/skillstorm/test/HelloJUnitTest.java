package com.skillstorm.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// @BeforeClass
// @Before
// @Test
// @After
// @AfterClass
public class HelloJUnitTest {

	// instance variables refreshed in each test
	private List<Object> testData;
	
	public HelloJUnitTest() {
		System.out.println("new HelloJUnitTest()");
	}
	
	// setup - for all tests
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}

	// setup - for EACH test (each test gets a fresh dataset)
	@Before
	public void before() {
		System.out.println("@Before"); 
		testData = new LinkedList<Object>(); 
		testData.add(new Object());
		testData.add(new Object());
		testData.add(new Object());
	}
	
	@Test
	public void test() {
		System.out.println("@Test 1");
		// maybe might change the test data set - DIRTY
	}

	@Test
	public void test2() {
		System.out.println("@Test 2");
	}
	
	@After
	public void after() {
		System.out.println("@After");
	}

	// teardown - for all tests
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	}

}
