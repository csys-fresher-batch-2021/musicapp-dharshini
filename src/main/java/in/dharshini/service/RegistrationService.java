package in.dharshini.service;

import in.dharshini.model.User;

public class RegistrationService {

	private RegistrationService() {
		// default Constructor
	}

	public static void addUser(String newMail, String newPassword) {
		User user5 = new User(newPassword);
		LoginService.registeredList.put(newMail, user5);
	}

	public static boolean checkNotRegisteredUser(String newMail, String newPassword) {
		boolean isValid = false;
		try {
			if ((InputValidator.isValidMailIdAndPassword(newMail, newPassword))
					&& !(LoginService.registeredList.containsKey(newMail))) {
				isValid = true;
				addUser(newMail, newPassword);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isValid;
	}
}
