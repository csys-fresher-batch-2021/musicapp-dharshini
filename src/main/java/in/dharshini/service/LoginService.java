package in.dharshini.service;

import java.util.Set;
import in.dharshini.dao.LoginDAO;
import in.dharshini.model.User;
import in.dharshini.util.Logger;

public class LoginService {

	private LoginService() {
		// Default constructor
	}

	/**
	 * This method validates whether the user is registered user or not with the
	 * help of login details
	 * 
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */

	public static boolean loginDetailCheck(User user) {
		boolean isValid = false;
		try {
			if (InputValidator.isValidMailIdAndPassword(user.getMailId(), user.getPassword())
					&& checkUser(user.getMailId(), user.getPassword())) {
				isValid = true;
			}
		} catch (Exception e) {
			Logger.println(e);
		}
		return isValid;
	}

	/**
	 * This method checks whether the user input login credentials is in registered
	 * database or not
	 * 
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */

	public static boolean checkUser(String inputMailId, String inputPassword) {
		boolean isValid = false;
		try {
			Set<String> mail = LoginDAO.getAllRegisteredUser().keySet();
			for (String password : mail) {
				String user = LoginDAO.getAllRegisteredUser().get(password);
				if (inputMailId.equals(password) && inputPassword.equals(user)) {
					isValid = true;
					break;
				}
			}
		} catch (Exception e) {
			Logger.println(e);
		}
		return isValid;
	}
}
