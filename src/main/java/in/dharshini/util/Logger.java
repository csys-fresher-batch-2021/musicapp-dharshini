package in.dharshini.util;

public class Logger {
	private Logger() {
		// default constructor
	}

	/**
	 * This method will print the passed paramteres
	 * 
	 * @param e
	 */
	public static void println(Exception e) {
		System.out.println(e);
	}
}