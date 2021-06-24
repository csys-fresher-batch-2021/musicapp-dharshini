package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.LanguageDAO;
import in.dharshini.model.Language;
import in.dharshini.userexception.DBException;

public class LanguageService {

	/**
	 * This method calls the addLanguages() in language DAO to add languages to the
	 * database
	 *
	 * @param langName
	 * @throws DBException
	 */
	public static boolean addLanguage(Language langName) {
		return LanguageDAO.addLanguages(langName);
	}

	/**
	 * This method Calls getAllLanguages() in language DAO to get List of languages
	 *
	 * @return
	 * @throws DBException
	 */
	public List<Language> getLanguages() throws DBException {
		return LanguageDAO.getAllLanguages();
	}

	/**
	 * This method calls the removeLanguages() in language DAO to remove languages
	 * from the database
	 *
	 * @param langName
	 * @return
	 */
	public static boolean removeLanguage(Language langName) {
		return LanguageDAO.removeLanguages(langName);
	}
}
