package in.dharshini.service;

import java.util.ArrayList;
import java.util.List;

import in.dharshini.model.Language;

public class LanguageService {
	
	private LanguageService() {
		//default constructor
	}
	private static final List<Language> languageList = new ArrayList<>();
	static {
		Language language1 = new Language("Tamil");
		Language language2 = new Language("Hindi");
		languageList.add(language1);
		languageList.add(language2);
	}

	public static List<Language> getLanguages() {
		return languageList;

	}
	public static List<Language> displayAvailableLanguages() {
		for (Language list : languageList) {
			System.out.println(list);
		}
		return languageList;
	}
}

/*
 * List<LanguageDomain> languages = new ArrayList<>(); LanguageDomain l1 = new
 * LanguageDomain("Tamil"); static { LanguageList obj = new LanguageList();
 * obj.languages.add("Tamil"); obj.languages.add("Hindi"); }
 */
/**
 * This method adds the available languages to the array list and displays
 * 
 * @return
 */