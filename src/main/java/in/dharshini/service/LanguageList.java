package in.dharshini.service;

import java.util.ArrayList;
import java.util.List;

class LanguageList {
	public static List<String> languages = new ArrayList<>();

	/**
	 * This static block adds available languages to array list
	 */
	static {
		languages.add("Tamil");
		languages.add("Hindi");
	}

	/**
	 * This method adds the available languages to the array list and displays
	 * @return 
	 */
	public static List<String> displayAvailableLanguages() {
		for (String list : languages) {
			System.out.println(list);
		}
		return languages;
	}

}
