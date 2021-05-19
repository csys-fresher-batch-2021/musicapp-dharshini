package in.dharshini.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import in.dharshini.model.User;

public class LoginService {

	private LoginService() {
		// Default constructor
	}

	/**
	 * This HashMap contains the details of registered users
	 */
	static Map<String, User> registeredList = new HashMap<>();
	static {
		User user1 = new User("Admin123*&");
		User user2 = new User("JAYsan32&$");
		User user3 = new User("123ABCabc*#*");
		User user4 = new User("12Ab#2%B");

		registeredList.put("admin@gmail.com", user1);
		registeredList.put("SandyJooy@gmail.com", user2);
		registeredList.put("dharshu@gmail.com", user3);
		registeredList.put("gokul@gmail.com", user4);
	}

	public static Map<String,String> getAllRegisteredUser() {
		Map<String,String> usersList = new HashMap<>(); ;
		Set<String> mail = registeredList.keySet();
		for(String s : mail) {
			User user = registeredList.get(s);
			usersList.put(s,user.getPassword());
		}
		return usersList;
	}

	
	/**
	 * This method validates whether the user is registered user or not with the
	 * help of login details
	 * 
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */

	public static boolean loginDetailCheck(String inputMailId, String inputPassword) {
		boolean isValid = false;
		User user = registeredList.get(inputMailId);
		try {
			if (isValidLogin(inputMailId, inputPassword) && (registeredList.containsKey(inputMailId))
					&& (user.getPassword().equals(inputPassword))) {
				isValid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	/**
	 * This method checks whether the user input mail id is valid or not by calling
	 * email validator method and password validator method from
	 * NewRegistrationLogic class
	 * 
	 * @param inputMailId
	 * @param inputPassword
	 * @return
	 */

	public static boolean isValidLogin(String inputMailId, String inputPassword) {
		boolean isExist = false;
		// email validation is done
		if ((StringValidator.verifyEmail(inputMailId)) && (StringValidator.verifyPassword(inputPassword))) {
			isExist = true;
		}
		return isExist;
	}
}
