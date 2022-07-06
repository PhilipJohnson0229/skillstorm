package com.skillstorm.code;


/**
 * This class checks if you're guessed number is between 0 and 10. 
 * 
 * Code Convention - compile, and follows good practices
 * 
 * Linter - Sonarlint plugin (Sonarqube)
 * 
 */

public class TestComponent2 {

	/**
	 * Code is more maintainable
	 * 
	 */
	private final static int lowestNumber = 2;
	
	private final static int highestNumber = 10;
	
	public boolean checkIfGuessedNumberInRange(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Cannot be 0");
		}else if(number > 10) 
		{
			return false;
		}
		else if (number >= lowestNumber) { // path
			return true;
		} else if(number <= highestNumber){ // another path (code coverage)
			return true;
		}
		
		return false;
	}

}
