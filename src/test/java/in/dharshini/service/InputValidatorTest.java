package in.dharshini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class InputValidatorTest {
	InputValidator validator = new InputValidator();

	/**
	 * Below methods tests whether the mailid and password is valid or not
	 */
	@Test
	public void validMailAndValidPassword() {
		String inputMailId = "dharshu.jasper@dharsan.co.in";
		String inputPassword = "123ABCabc*#*";
		assertTrue(validator.isValidMailIdAndPassword(inputMailId, inputPassword));
	}

	@Test
	public void InvalidMailAndInvalidPassword() {
		String inputMailId = "dharshu.jasperdharsan.co.in";
		String inputPassword = "123ABCab";
		assertFalse(validator.isValidMailIdAndPassword(inputMailId, inputPassword));
	}

	@Test
	public void ValidMailAndInvalidPassword() {
		String inputMailId = "dharshu@gmail.com";
		String inputPassword = " ";
		assertFalse(validator.isValidMailIdAndPassword(inputMailId, inputPassword));
	}

	@Test
	public void InvalidMailAndValidPassword() {
		String inputMailId = "dharshu@gmailcom";
		String inputPassword = "qweAVC54%$#";
		assertFalse(validator.isValidMailIdAndPassword(inputMailId, inputPassword));
	}

}
