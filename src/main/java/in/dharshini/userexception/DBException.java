package in.dharshini.userexception;

public class DBException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * This method gives errorMessage
	 * @param message
	 */
	public DBException(String message) {
		super(message);
	}
	
	/**
	 * This method gives error message and stackTrace
	 * @param e
	 * @param message
	 */
	public DBException(Throwable e, String message) {
		super(message,e);
	}
}