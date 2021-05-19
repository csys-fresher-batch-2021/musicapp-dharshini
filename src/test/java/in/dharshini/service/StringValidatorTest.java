package in.dharshini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringValidatorTest {
	@Test
	public void test1() {
		String newUserEmail = "dharshu@gmail.com";
		String newUserPassword = "123ABCabc*#*";
		assertTrue(LoginService.isValidLogin(newUserEmail, newUserPassword));
	}
	
	@Test
	public void test2() {
		String newUserEmail = "dharshu@gmail.com";
		String newUserPassword = "123ABCabc";
		assertFalse(LoginService.isValidLogin(newUserEmail, newUserPassword));
	}
	
	@Test
	public void test3() {
	String newUserEmail = "dharshugmail.com";
	String newUserPassword = "123ABCabc*#*";
	assertFalse(LoginService.isValidLogin(newUserEmail,newUserPassword));
	}
	
	@Test
	public void test4() {
	String newUserEmail = "dharshu@gmail.com";
	String newUserPassword = "123ABCabc *#*";
	assertFalse(LoginService.isValidLogin(newUserEmail,newUserPassword));
	}

	@Test
	public void test5() {
	String newUserEmail = "dharshu.email@gmail.co.in";
	String newUserPassword = "123ABCabc*#*";
	assertTrue(LoginService.isValidLogin(newUserEmail,newUserPassword));
	}
	
	@Test
	public void test6() {
	String newUserEmail = "dharshu.email@gmail.co.in";
	String newUserPassword = " ";
	assertFalse(LoginService.isValidLogin(newUserEmail,newUserPassword));
	}
	
	@Test
	public void test7() {
	String newUserEmail = null;
	String newUserPassword = "123ABCabc*#*";
	assertFalse(LoginService.isValidLogin(newUserEmail,newUserPassword));
	}
}
