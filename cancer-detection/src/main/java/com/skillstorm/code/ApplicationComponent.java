package com.skillstorm.code;

//@Deprecated
/**
 * This class checks if you're old enough to purchase restricted items. 
 * 
 * Code Convention - compile, and follows good practices
 * 
 * Linter - Sonarlint plugin (Sonarqube)
 * 
 */
public class ApplicationComponent {

	/**
	 * Code is more maintainable
	 * 
	 */
	public boolean checkThatTheCustomerAgeIsOverEighteenYearsOld(int age) {
		if (age < 0) {
			throw new IllegalArgumentException();
		}
		if (age < 18) { // path
			return false;
		} else { // another path (code coverage)
			return true;
		}
	}

	// TDD - Write Actual Code Second
	public boolean checkId(int age, String item) {
		// stub - there as a placeholder
		switch (item) {
			case "beer": {
				return age >= 21;
			}
			case "lottery": {
				return age < 18;
			}
			default:
				return false;
		}
	}

}
