package in.dharshini.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static boolean verifyEmail(String newUserEmail) {
		if (newUserEmail == null || newUserEmail.trim().equals("") || (!newUserEmail.trim().matches(
				"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))) {
			return false;
		}
		return true;

	}

	public static boolean verifyPassword(String newUserPassword) {
		if (newUserPassword == null || newUserPassword.trim().equals("")) {
			return false;
		}
		String passwordPatternRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])(?!.*\\s).{8,20}$";

		Pattern pattern = Pattern.compile(passwordPatternRegex);
		// digit + lowercase char + uppercase char + punctuation + symbol

		Matcher matcher = pattern.matcher(newUserPassword);
		return matcher.matches();
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
