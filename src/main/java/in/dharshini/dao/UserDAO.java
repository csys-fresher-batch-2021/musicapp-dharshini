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
import in.dharshini.util.Logger;

public class UserDAO {

	/**
	 * This method is used to add new user to db
	 *
	 * @param user
	 * @throws DBException
	 */
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

	/**
	 * This method is used to update password of existing user
	 *
	 * @param user
	 * @return
	 */
	public boolean updatePassword(User user) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isUpdated = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update users set password=? where email=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getPassword());
			pst.setString(2, user.getMailId());

			pst.executeUpdate();
			isUpdated = true;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;
	}

	/**
	 * This method is used to get details list of all registered usrs
	 *
	 * @return
	 * @throws DBException
	 */
	public static Map<String, String> getAllRegisteredUser() throws DBException {
		final Map<String, String> userMap = new HashMap<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
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
			throw new DBException(e, "Sorry. Cannot List user details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userMap;
	}

	/**
	 * This method is used to get userId of particular user
	 *
	 * @param mailId
	 * @return
	 * @throws DBException
	 */
	public User getParticularUserId(User mailId) throws DBException {
		User userId = null;
		Connection connection = null;
		PreparedStatement pst = null;
		Integer userid = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select user_id from users where email=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, mailId.getMailId());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				userid = result.getInt("user_id");
				userId = new User(userid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot get user id from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userId;
	}
}