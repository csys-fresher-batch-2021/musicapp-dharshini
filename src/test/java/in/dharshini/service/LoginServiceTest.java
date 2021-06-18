package in.dharshini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginServiceTest {
	/**
	 * Below method checks whether the user details is already registered or not
	 */
	@Test
	public void CorrectMailidAndPassword() {
		String inputMailId = "dharshu@gmail.com";
		String inputPassword = "Dharshu@123";
		assertTrue(LoginService.checkUserForLogin(inputMailId, inputPassword));
	}

	@Test
	public void CorrectMailidAndPassword1() {
		String inputMailId = "sandyjooy@gmail.com";
		String inputPassword = "SandyJooy@123";
		assertTrue(LoginService.checkUserForLogin(inputMailId, inputPassword));
	}

	@Test
	public void IncorrectmailidAndCorrectPassword() {
		String inputMailId = "raja@gmail.com";
		String inputPassword = "123ABCabc*#*";
		assertFalse(LoginService.checkUserForLogin(inputMailId, inputPassword));
	}

	@Test
	public void CorrectMailidAndIncorrectpassword() {
		String inputMailId = "dharshu@gmail.com";
		String inputPassword = "123ABC#*";
		assertFalse(LoginService.checkUserForLogin(inputMailId, inputPassword));
	}

	@Test
	public void IncorrectMailidAndIncorrectpassword() {
		String inputMailId = "rupa@gmail.com";
		String inputPassword = "123ABC#*";
		assertFalse(LoginService.checkUserForLogin(inputMailId, inputPassword));
	}

}
