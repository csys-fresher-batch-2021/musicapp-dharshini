package in.dharshini.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.dto.SongDTO;
import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;
import in.dharshini.util.Logger;

public class SongDAO {
	private SongDAO() {
		// Default constructor
	}

	/**
	 * This method is used to add songs src and details to db
	 *
	 * @param songDetails
	 * @return
	 */
	public static boolean addSong(SongDTO songDetails) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			File songSource = new File("E:\\musicapp-dharshini\\ProjectUtilities\\" + songDetails.getSongFile());
			File imageSource = new File("E:\\musicapp-dharshini\\ProjectUtilities\\" + songDetails.getSongImage());

			try (FileInputStream fisObj1 = new FileInputStream(songSource);
					FileInputStream fisObj2 = new FileInputStream(imageSource);) {
				connection = ConnectionUtil.getConnection();
				String sql = "insert into songs(language_id,movie_id,song_name,song_src,song_image) values (?,?,?,?,?)";

				pst = connection.prepareStatement(sql);
				pst.setInt(1, songDetails.getLanguageId());
				pst.setInt(2, songDetails.getMovieId());
				pst.setString(3, songDetails.getSongName());
				pst.setBinaryStream(4, fisObj1);
				pst.setBinaryStream(5, fisObj2);

				pst.executeUpdate();
				isDone = true;
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This method is used to remove song from db
	 *
	 * @param songName
	 * @return
	 */
	public static boolean removeSongs(Song songName) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from songs where song_name= ?";
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

	/**
	 * This Method is used to get all songs list from db
	 *
	 * @param movieId
	 * @return
	 * @throws DBException
	 */
	public static List<Song> getAllSongNames(Integer movieId) throws DBException {
		final List<Song> songsList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song_id,song_name from songs where movie_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, movieId);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				Integer songId = result.getInt("song_id");
				String songName = result.getString("song_name");
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

	/**
	 * This method is used to get song source file
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public static byte[] getSongSrc(String songName) throws DBException {
		byte[] songSource = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song_src from songs where song_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songName);
			result = pst.executeQuery();
			while (result.next()) {
				songSource = result.getBytes(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot get song from db");
		} finally {
			ConnectionUtil.close(result, pst, connection);
		}
		return songSource;

	}

	/**
	 * This method is used to check whether the song is present in songs db or not
	 * for search song feature and returns number of results available for searched
	 * keyword
	 *
	 * @param songName
	 * @return
	 */
	public static Integer isSongPresent(Song songName) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		Integer hasSong = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT COUNT(song_name) FROM songs WHERE LOWER(song_name) LIKE  '%"
					+ songName.getSongName().toLowerCase() + "%'";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				hasSong = result.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return hasSong;
	}

	/**
	 * This method gives the list of songs available in db for the searched keyword
	 *
	 * @param songName
	 * @return
	 */
	public static List<SongDTO> searchSongList(Song songName) {
		List<SongDTO> searchSongList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT song_name FROM songs WHERE LOWER(song_name) LIKE  '%"
					+ songName.getSongName().toLowerCase() + "%'";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String song = result.getString("song_name");
				SongDTO songDto = new SongDTO(song);
				searchSongList.add(songDto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return searchSongList;
	}

	/**
	 * This method is used to get song's banner image source drom db
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public static byte[] getSongImageSrc(String imageName) throws DBException {
		byte[] songImageSource = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song_image from songs where song_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, imageName);
			result = pst.executeQuery();
			while (result.next()) {
				songImageSource = result.getBytes(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot get song Image from db");
		} finally {
			ConnectionUtil.close(result, pst, connection);
		}
		return songImageSource;
	}
}