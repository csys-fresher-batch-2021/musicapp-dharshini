package in.dharshini.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LanguageListTest {

	@Test
	public void test() {
		int arrayListSize = LanguageList.displayAvailableLanguages().size();
		assertEquals(2,arrayListSize);
	}
}
