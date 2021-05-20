package in.dharshini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

	public class StringValidatorTest{

	@Test
	public void validMailId1() {
		String newUserEmail = "dharshu.sandyJooy@gmail.com";
		assertTrue(StringValidator.verifyEmail(newUserEmail));
	}

	@Test
	public void validMailId2() {
		String newUserEmail = "dharshu.jasper@dharsan.co.in";
		assertTrue(StringValidator.verifyEmail(newUserEmail));
	}

	@Test
	public void invalidMailId() {
		String newUserEmail = "dharshu@gmailcom";
		assertFalse(StringValidator.verifyEmail(newUserEmail));
	}

	@Test
	public void invalidMailId1() {
		String newUserEmail = "dharshugmail.com";
		assertFalse(StringValidator.verifyEmail(newUserEmail));
	}

	@Test
	public void invalidMailId2() {
		String newUserEmail = "";
		assertFalse(StringValidator.verifyEmail(newUserEmail));
	}

	@Test
	public void invalidMailId3() {
		String newUserEmail = null;
		assertFalse(StringValidator.verifyEmail(newUserEmail));
	}

	@Test
	public void test5() {
		String newUserPassword = "123ABCabc*#*";
		assertTrue(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test3() {
		String newUserPassword = "123AB*#*";
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test4() {
		String newUserPassword = "123ABCabc *#*";
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test6() {
		String newUserPassword = "123abc*#*";
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test7() {
		String newUserPassword = "ABCabc*#*";
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test8() {
		String newUserPassword = "123ABCabc";
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test9() {
		String newUserPassword = "";
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}

	@Test
	public void test() {
		String newUserPassword = null;
		assertFalse(StringValidator.verifyPassword(newUserPassword));
	}
}
