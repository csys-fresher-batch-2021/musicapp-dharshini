package in.dharshini.dao;

import in.dharshini.model.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class LanguageDAO {
	private LanguageDAO() {
		// Default constructor
	}

	public static void addLanguages(Language languageName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into languages(language) values (?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, languageName.getLanguageName());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Unable to add language in db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public static List<Language> getAllLanguages() throws DBException {
		List<Language> languageList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select language_id,language from languages";
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				Integer languageId = result.getInt("language_id");
				String language = result.getString("language");
				Language lang = new Language(language, languageId);
				languageList.add(lang);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot List language details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return languageList;
	}

}
