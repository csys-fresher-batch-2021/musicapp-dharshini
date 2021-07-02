package in.dharshini.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

import in.dharshini.util.Logger;

public class InputValidator {

	/**
	 * This method validates whether both the user input mail id and password is in
	 * correct format or not
	 *
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */
	public boolean isValidMailIdAndPassword(String inputMailId, String inputPassword) {
		boolean isExist = false;
		try {
			if ((isValidEmail(inputMailId)) && (isValidPassword(inputPassword))) {
				isExist = true;
			}
		} catch (Exception e) {
			Logger.println(e);
		}
		return isExist;
	}

	/**
	 * This method validates whether the user input mail id is in correct format or
	 * not
	 *
	 * @param newUserEmail
	 * @return
	 */

	public boolean isValidEmail(String newUserMail) {
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

	public boolean isValidPassword(String newUserPassword) {
		Matcher matcher;
		boolean isValid = false;
		try {
			if (newUserPassword == null || newUserPassword.trim().equals("")) {
				return false;
			}
			String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])(?!.*\\s).{8,20}$";
			Pattern pattern = Pattern.compile(regexPattern);
			// digit + lowercase char + uppercase char + punctuation + symbol
			matcher = pattern.matcher(newUserPassword);
			isValid = matcher.matches();
		} catch (Exception e) {
			Logger.println(e);
		}
		return isValid;
	}

	/**
	 * This Method validates whether user input select is in correct format or not
	 */
	public boolean verifyUserInput(String inputLanguage) {
		boolean isValid = true;
		if (inputLanguage == null || inputLanguage.trim().equals("") || inputLanguage.trim().matches("[^A-Za-z]")) {
			isValid = false;
		}
		return isValid;
	}
}
