package in.dharshini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginServiceTest {
	@Test
	public void CorrectMailidAndPassword() {
		String inputMailId = "dharshu@gmail.com";
		String inputPassword = "123ABCabc*#*";
		assertTrue(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}

	@Test
	public void IncorrectmailidAndCorrectPassword() {
		String inputMailId = "raja@gmail.com";
		String inputPassword = "123ABCabc*#*";
		assertFalse(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}

	@Test
	public void CorrectMailidAndIncorrectpassword() {
		String inputMailId = "dharshu@gmail.com";
		String inputPassword = "123ABC#*";
		assertFalse(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}

	@Test
	public void IncorrectMailidAndIncorrectpassword() {
		String inputMailId = "rupa@gmail.com";
		String inputPassword = "123ABC#*";
		assertFalse(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}
	
	@Test
	public void InvalidMailidAndInvalidpassword() {
		String inputMailId = "rupagmail.com";
		String inputPassword = "123#*";
		assertFalse(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}
	
	@Test
	public void ValidMailidAndInvalidpassword() {
		String inputMailId = "rupa@gmail.com";
		String inputPassword = "123#*";
		assertFalse(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}
	
	@Test
	public void InvalidMailidAndValidpassword() {
		String inputMailId = "rupagmail.com";
		String inputPassword = "123ABCabc*#*";
		assertFalse(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}
	

	@Test
	public void ValidMailidAndValidpassword() {
		String inputMailId = "dharshu@gmail.com";
		String inputPassword = "123ABCabc*#*";
		assertTrue(LoginService.loginDetailCheck(inputMailId, inputPassword));
	}
	

}
