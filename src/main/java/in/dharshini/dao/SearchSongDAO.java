package in.dharshini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class SearchSongDAO {
	private SearchSongDAO() {
		// default constructor
	}

	public static Song getSearchedSongLink(String song) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		Song songAndLink = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song,song_link from songs  where song = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, song);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String searchedSongLink = result.getString("song_link");
				String searchedSong = result.getString("song");
				 songAndLink = new Song(searchedSongLink,searchedSong);
				//songAndLink = songLink;
				//System.out.println(songLink);
			}
		} catch (ClassNotFoundException | NullPointerException | SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Sorry. Cannot List user details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return songAndLink;
	}
}
