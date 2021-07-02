package in.dharshini.service;

import java.util.Set;

import in.dharshini.dao.UserDAO;
import in.dharshini.model.User;
import in.dharshini.userexception.DBException;
import in.dharshini.userexception.ServiceException;
import in.dharshini.util.Logger;

public class UserService {
	InputValidator validator = new InputValidator();

	/**
	 * This method checks whether the registration input credentials are in correct
	 * format and not already registered user
	 *
	 * @param newMail
	 * @param newPassword
	 * @return
	 * @throws DBException
	 */
	public boolean checkNotRegisteredUser(User user) throws DBException {
		boolean isValid = false;
		if ((validator.isValidMailIdAndPassword(user.getMailId(), user.getPassword()))
				&& !(checkUserForLogin(user.getMailId(), user.getPassword()))) {
			isValid = true;
			UserDAO.addUser(user);
		}
		return isValid;
	}

	/**
	 * This method validates the user input details for correct format and call
	 * checkUser() method to check the user is registered user or not with the help
	 * of login details
	 *
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */

	public boolean loginDetailCheck(User user) {
		boolean isValid = false;
		try {
			if (validator.isValidMailIdAndPassword(user.getMailId(), user.getPassword())
					&& checkUserForLogin(user.getMailId(), user.getPassword())) {
				isValid = true;
			}
		} catch (Exception e) {
			Logger.println(e);
		}
		return isValid;
	}

	/**
	 * This method gets the particular user_id with the help of email from users db
	 *
	 * @param mailId
	 * @return
	 * @throws DBException
	 */
	public User getParticularUserDetails(User mailId) throws DBException {
		UserDAO userDao = new UserDAO();
		return (userDao.getParticularUserDetails(mailId));
	}

	/**
	 * This method checks whether the user input login credentials is in registered
	 * database or not
	 *
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */

	public boolean checkUserForLogin(String inputMailId, String inputPassword) {
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

	/**
	 * This method is used to check whether the admin login detail is correct or not
	 *
	 * @param user
	 * @return
	 */
	public boolean adminLoginCheck(User user) {
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

	/**
	 * This method is used to update password of existing user
	 *
	 * @param user
	 * @return
	 * @return
	 * @throws ServiceException
	 * @throws DBException
	 */
	public boolean updatePassword(User user) throws DBException, ServiceException {
		boolean isUpdated = false;

		if (!(validator.isValidMailIdAndPassword(user.getMailId(), user.getPassword()))) {
			throw new ServiceException("Mail Id or Password is in Incorrect Format");
		} else if (!(checkUserForPasswordUpdate(user.getMailId()))) {
			throw new DBException("Entered Mailid is Not registered");
		} else if (validator.isValidMailIdAndPassword(user.getMailId(), user.getPassword())
				&& checkUserForPasswordUpdate(user.getMailId())) {
			isUpdated = true;
			UserDAO userDao = new UserDAO();
			userDao.updatePassword(user);
		}
		return isUpdated;
	}

	/**
	 * This method is used to check whether the input mailId in update password
	 * feature is registered mailId or not
	 *
	 * @param inputMailId
	 * @return
	 */
	public boolean checkUserForPasswordUpdate(String inputMailId) {
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
