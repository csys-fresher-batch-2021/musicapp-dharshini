package in.dharshini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.dharshini.model.User;
import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class LoginDAO {

	private LoginDAO() {
		// Default constructor
	}

	public static void addUser(User user) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into users(email,password) values (?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getMailId());
			pst.setString(2, user.getPassword());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Unable to add new user in db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public static Map<String, String> getAllRegisteredUser() throws DBException {
		final Map<String, String> userMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select email,password from users";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String mailId = result.getString("email");
				String passWord = result.getString("password");
				userMap.put(mailId, passWord);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e,"Sorry. Cannot List user details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userMap;
	}
}