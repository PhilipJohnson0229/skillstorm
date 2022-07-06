package com.skillstorm.test;

// .* is telling java to import every static method in the assert class
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.skillstorm.code.TestComponent2;

public class GuessNumberTest {

	//we make a constructor so we know how many objects are baing created
	public GuessNumberTest()
	{
		System.out.println("Hello this is a new object");
	}
	
	//refreshed with each test
	private List<Object> testData;
	
	
	//instance variable
	static TestComponent2 testItem;
	
	private static int iterate = -1;
	
	//this method MUST be static so that we can call it before the class runs
	//if we dont annotate this then we will throw nullException for testItem
	@BeforeClass
	public static void setupBeforeTests() 
	{
		System.out.println("This is the beginning");
		testItem = new TestComponent2();
		System.out.println(testItem);
	}
	
	//this method must be instance
	//we use this method to refresh the test data set to avoid DIRTY
	//DIRTY means we change values in the test data set
	@Before
	public void before() 
	{
		testData = new LinkedList<Object>();
		testData.add(new Object());
		testData.add(new Object());
		testData.add(new Object());
	}
	
	@Test
	public void testInRange() 
	{
		boolean actual = testItem.checkIfGuessedNumberInRange(5); // actual
		// expect to get true
		boolean expected = true;

		// Assert methods - if(expected == actual) else throw new AssertionException
		assertEquals(expected, actual);
	}
	
	@Test
	public void testOutOfRange() 
	{
		assertEquals(false, testItem.checkIfGuessedNumberInRange(12));
	}
	
	//this should run after each test
	@After
	public void after() 
	{
		
	}
	
	//this is known as a tear down method
	@AfterClass
	public static void afterTest() 
	{
		System.out.println("this is the end of the test");
		
		//this will add 1 to the int from it's initial value
		++iterate;
		
		//with this we can determine the same object exists at the same location
		//trying to verify were not creating a bunch of objects just to test
		//junit will run iterate through the code as many times as there are test methods
		System.out.println(testItem);
	}
}
