package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.LanguageDAO;
import in.dharshini.model.Language;
import in.dharshini.userexception.DBException;

public class LanguageService {

	LanguageDAO languageDao = new LanguageDAO();

	/**
	 * This method calls the addLanguages() in language DAO to add languages to the
	 * database
	 *
	 * @param langName
	 * @throws DBException
	 */
	public boolean addLanguage(Language langName) throws DBException {
		return languageDao.addLanguages(langName);
	}

	/**
	 * This method Calls getAllLanguages() in language DAO to get List of languages
	 *
	 * @return
	 * @throws DBException
	 */
	public List<Language> getLanguages() throws DBException {
		return languageDao.getAllLanguages();
	}

	/**
	 * This method calls the removeLanguages() in language DAO to remove languages
	 * from the database
	 *
	 * @param langName
	 * @return
	 * @throws DBException
	 */
	public boolean removeLanguage(Language langName) throws DBException {
		return languageDao.removeLanguages(langName);
	}
}
