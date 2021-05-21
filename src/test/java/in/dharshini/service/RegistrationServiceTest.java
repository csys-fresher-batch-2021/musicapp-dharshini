package in.dharshini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * If the User is not a registered user, then it returns True. If user is
 * already registered user, returns false. If mail id is registerd and password
 * is not registered, that is also considered as registered user. (i.e, false)
 * If password is registerd and mailid is not registered, that is also
 * considered as not registered user. ( i.e, true).
 * 
 */
public class RegistrationServiceTest {
	@Test
	public void InvalidMailidAndInvalidPassword() {
		String userMail = "sjakjja";
		String userPassword = "augus";
		assertFalse(RegistrationService.checkNotRegisteredUser(userMail, userPassword));
	}

	@Test
	public void ValidMailidAndValidPassword() {
		String userMail = "ranga@gmail.com";
		String userPassword = "13GDjd&#nkj";
		assertTrue(RegistrationService.checkNotRegisteredUser(userMail, userPassword));
	}

	@Test
	public void AvailableMailidAndIncorrectPassword() {
		String userMail = "gokul@gmail.com";
		String userPassword = "Au1@bkjskj";
		assertFalse(RegistrationService.checkNotRegisteredUser(userMail, userPassword));
	}

	@Test
	public void IncorrectMailidAndAvailablePassword() {
		String userMail = "ki@gmail.com";
		String userPassword = "123ABCabc*#*";
		assertTrue(RegistrationService.checkNotRegisteredUser(userMail, userPassword));
	}

	@Test
	public void AvailableMailIdAndAvailablePassword() {
		String userMail = "dharshu@gmail.com";
		String userPassword = "123ABCabc*#*";
		assertFalse(RegistrationService.checkNotRegisteredUser(userMail, userPassword));
	}
}
