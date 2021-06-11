package in.dharshini.dao;

import in.dharshini.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class SongDAO {
	private SongDAO() {
		// Default constructor
	}

	public static void addSong(Song songName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into songs(song) values (?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, songName.getSongName());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to add song in db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

//"insert into songs (language_id,movie_id,song,song_link) values (?,?,?,?)";
	public static List<Song> getAllSongs(Integer movieId) throws DBException {
		final List<Song> songsList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song,song_Id from songs as s inner join movies as m on s.movie_id = m.movie_id inner join languages as l on l.language_id = m.language_id where m.movie_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, movieId);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				Integer songId = result.getInt("song_id");
				String songName = result.getString("song");
				Song song = new Song(songName, songId);
				songsList.add(song);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Sorry. Cannot List user details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return songsList;
	}

	public static Song getSongLink(Integer songId) throws DBException {
		Song link = null;
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song_link from songs  where song_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, songId);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songLink = result.getString("song_link");
				Song song = new Song(songLink);
				link = song;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Sorry. Cannot List user details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return link;
	}

}
