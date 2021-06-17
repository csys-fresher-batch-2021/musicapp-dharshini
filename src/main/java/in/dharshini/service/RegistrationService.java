package in.dharshini.service;

import java.util.Set;

import in.dharshini.dao.LoginDAO;
import in.dharshini.model.User;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

public class RegistrationService {

	private RegistrationService() {
		// default Constructor
	}

	/**
	 * This method checks whether the registration input credentials are in correct
	 * format and not already registered user
	 * 
	 * @param newMail
	 * @param newPassword
	 * @return
	 * @throws DBException
	 */
	public static boolean checkNotRegisteredUser(User user) throws DBException {
		boolean isValid = false;
		if((InputValidator.isValidMailIdAndPassword(user.getMailId(), user.getPassword())) && !(LoginService.checkUser(user.getMailId(), user.getPassword()))){
			isValid=true;
			LoginDAO.addUser(user);
		}
		return isValid;
	}
	
	/**
	 * This method checks whether user details is registered or not
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
