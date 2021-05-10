package in.dharshini.service;

import static org.junit.Assert.assertEquals;


//import static org.junit.Assert.*;

import org.junit.Test;

public class LanguageListTest {

	@Test
	public void test() {
		assertEquals(2,LanguageList.displayAvailableLanguages().size());
	}
}
