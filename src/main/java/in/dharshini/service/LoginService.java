package in.dharshini.service;

import java.util.Set;
import in.dharshini.dao.UserDAO;
import in.dharshini.model.User;
import in.dharshini.userexception.DBException;
import in.dharshini.userexception.ServiceException;
import in.dharshini.util.Logger;

public class LoginService {

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
					&& checkUserForLogin(user.getMailId(), user.getPassword())) {
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

	public static boolean checkUserForLogin(String inputMailId, String inputPassword) {
		boolean isValid = false;
		try {
			Set<String> mailSet = UserDAO.getAllRegisteredUser().keySet();
			for (String mail : mailSet) {
				String password = UserDAO.getAllRegisteredUser().get(mail);
				if (inputMailId.equals(mail) && inputPassword.equals(password)) {
					isValid = true;
					break;
				}
			}
		} catch (Exception e) {
			Logger.println(e);
		}
		return isValid;
	}

	public static boolean adminLoginCheck(User user) {
		boolean isValid = false;
		try {
			if ((user.getMailId().equals("admin@gmail.com")) && (user.getPassword().equals("Admin@123"))) {
				isValid = true;
			}
		} catch (Exception e) {
			Logger.println(e);
		}
		return isValid;
	}

	public boolean updatePassword(User user) throws ServiceException, DBException {
		boolean isUpdated = false;

		if (!(InputValidator.isValidMailIdAndPassword(user.getMailId(), user.getPassword()))) {
			throw new ServiceException("Mail Id or Password is in Incorrect Format");
		} else if (!(checkUserForPasswordUpdate(user.getMailId()))) {
			throw new DBException("Entered Mailid is Not registered");
		} else if (InputValidator.isValidMailIdAndPassword(user.getMailId(), user.getPassword())
				&& checkUserForPasswordUpdate(user.getMailId())) {
			isUpdated = true;
			UserDAO userDao = new UserDAO();
			userDao.updatePassword(user);
		}
		return isUpdated;
	}

	public static boolean checkUserForPasswordUpdate(String inputMailId) {
		boolean isValid = false;
		try {
			Set<String> mailSet = UserDAO.getAllRegisteredUser().keySet();
			for (String mail : mailSet) {
				if (inputMailId.equals(mail)) {
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
