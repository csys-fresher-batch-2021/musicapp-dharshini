package in.dharshini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class UtilitiesDAO {

	private UtilitiesDAO() {
		// Default Constructor
	}

	/**
	 * This method is used to get image source used for styling purposes
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public static byte[] getStyleImageSrc(String imageName) throws DBException {
		byte[] imageSource = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select image_source from images where image_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, imageName);
			result = pst.executeQuery();
			while (result.next()) {
				imageSource = result.getBytes(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot get image from db");
		} finally {
			ConnectionUtil.close(result, pst, connection);
		}
		return imageSource;
	}

}
