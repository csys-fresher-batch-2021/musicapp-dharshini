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
import in.dharshini.util.Logger;

public class SongDAO {
	private SongDAO() {
		// Default constructor
	}

	public static boolean addSong(Song songName) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into songs(language_id,movie_id,song,song_link) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, songName.getLanguageid());
			pst.setInt(2, songName.getMovieId());
			pst.setString(3, songName.getSongName());
			pst.setString(4, songName.getSongLink());

			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}
	
	public static boolean removeSongs(Song songName) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from songs where song= ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songName.getSongName());

			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

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
			throw new DBException(e, "Sorry. Cannot List user details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return songsList;
	}

	public static Song getSongLinkAndSong(Integer songId) throws DBException {
		Song link = null;
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song_link,song from songs  where song_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, songId);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songLink = result.getString("song_link");
				String songName = result.getString("song");

				Song song = new Song(songLink, songName);
				link = song;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot List song details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return link;
	}

}
