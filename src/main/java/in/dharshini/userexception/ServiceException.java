package in.dharshini.userexception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * This method gives errorMessage
	 * 
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * This method gives error message and stackTrace
	 * 
	 * @param e
	 * @param message
	 */
	public ServiceException(Throwable e, String message) {
		super(message, e);
	}
}