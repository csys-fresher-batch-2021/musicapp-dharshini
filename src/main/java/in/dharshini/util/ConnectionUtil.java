package in.dharshini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	private ConnectionUtil() {
		// Default Constructor (To hide implicit public class)
	}

	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "dharshvenkat!";
	private static final String DB_URL = "jdbc:postgresql://localhost/musicapp_db";

	/**
	 * This method is used to get Connection to the db
	 *
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		return connection;
	}

	/**
	 * This method is used to close statement and connection
	 *
	 * @param st
	 * @param con
	 */
	public static void close(Statement st, Connection con) {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			Logger.println(e);
		}
	}

	/**
	 * This method is used to close resultSet, statement, connection
	 *
	 * @param rs
	 * @param st
	 * @param con
	 */
	public static void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			Logger.println(e);
		}
	}
}
