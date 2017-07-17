package PrimeNumberCheck;

/**
 * Main class to run the program.
 * @author Jamie Sathira Kittisukmongkol
 * 			Software Engineering Student
 * 			Kasetsart University Bangkaen Campus
 */
public class Main {

	public static void main(String[]args) {
		Console console = new Console();
		GUI gui = new GUI( console );
		gui.run();
	}
	
}
