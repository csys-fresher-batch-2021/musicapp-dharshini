package in.dharshini.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LanguageServiceTest {

	@Test
	public void test() {
		int arrayListSize = LanguageService.getLanguages().size();
		assertEquals(2,arrayListSize);
	}
}
