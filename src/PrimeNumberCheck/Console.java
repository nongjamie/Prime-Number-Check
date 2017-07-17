package PrimeNumberCheck;

/**
 * Checking the prime number.
 * @author Jamie Sathira Kittisukmongkol
 * 			Software Engineering Student
 * 			Kasetsart University Bangkaen Campus
 */
public class Console {

	private String result = "";

	public Console() {
		/* Do nothing */
	}

	/**
	 * Check that is it number or not?
	 * @param input , from the GUI class.
	 */
	public void checkingPrimeNumber( String input ) {
		try {
			int number = Integer.parseInt( input );
			if( number < 1 ) {
				result = "Please enter positive number.";
			}
			else {
				if( number == 1 ) {
					result = "1 is not Prime Number.";
				}
				else {
					result = number + check( number );
				}
			}
		} catch( Exception ex ) {
			result = "Please enter only the number.";
		}
	}

	/**
	 * Check that is input number prime number?
	 * @param number , number that wants to check.
	 * @return is prime number or not.
	 */
	private String check( int number ) {
		String ansresult = " is Prime Number.";
		for( int i = 2 ; i < number ; i++ ) {
			if( (number % i == 0) ) {
				ansresult = " is not Prime Number.";
				i = number;
			}
		}
		return ansresult;
	}
	
	/**
	 * Get the result of that number.
	 * @return
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Reset the previous result.
	 */
	public void resetAll() {
		result = "";
	}

}
