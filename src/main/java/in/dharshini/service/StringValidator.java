package in.dharshini.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;

public class StringValidator {
	
	private StringValidator() {
		// default constructor
	}
	
	/**
	 * This method validates whether the user input mail id is in correct format or
	 * not
	 * 
	 * @param newUserEmail
	 * @return
	 */

	public static boolean verifyEmail(String newUserMail) {
		EmailValidator eValidator = EmailValidator.getInstance();
		return (eValidator.isValid(newUserMail));
	}

	/**
	 * This method validates whether the user input password is in correct and
	 * required format or not
	 * 
	 * @param newUserPassword
	 * @return
	 */

	public static boolean verifyPassword(String newUserPassword) {
		Matcher matcher;
		boolean isValid = false;
		try {
			if (newUserPassword == null || newUserPassword.trim().equals("")) {
				return false;
			}
			String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>])(?!.*\\s).{8,20}$";
			Pattern pattern = Pattern.compile(regexPattern);
			// digit + lowercase char + uppercase char + punctuation + symbol
			matcher = pattern.matcher(newUserPassword);
			isValid = matcher.matches();
		} catch (Exception e) {
			System.out.println(e);
		}
		return isValid;
	}

	/**
	 * This Method validates whether user input select is in correct format or not
	 */
	public static boolean verifyUserInput(String inputLanguage) {
		boolean isValid = true;
		if (inputLanguage == null || inputLanguage.trim().equals("") || inputLanguage.trim().matches("[^A-Za-z]")) {
			isValid = false;
		}
		return isValid;
	}

}