package in.dharshini.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.model.MusicGenre;
import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class MusicGenreDAO {
	private static final String GENRE = "genre";

	/**
	 * This method is used to add languages to the db
	 *
	 * @param gente
	 * @return
	 * @throws DBException
	 */
	public boolean addGenre(String genre) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into genre(genre) values (?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, genre);
			pst.executeUpdate();

			isDone = true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot add genre into db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This method is used to remove available genre from the db
	 *
	 * @param languageName
	 * @return
	 * @throws DBException
	 */
	public boolean removeGenre(String genre) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from genre where genre= ?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, genre);
			pst.executeUpdate();

			isDone = true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot remove genre from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This method is used to add songs src and details to genre db
	 *
	 * @param songDetails
	 * @return
	 * @throws DBException
	 */
	public boolean addGenreSong(MusicGenre songDetails) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;

		try (FileInputStream fisObj1 = new FileInputStream(songDetails.getSongFile())) {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into genre_song_list(song_name,music_director,genre_id,singers,song_src) values (?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songDetails.getSongName());
			pst.setString(2, songDetails.getMusicDirector());
			pst.setInt(3, songDetails.getGenreId());
			pst.setString(4, songDetails.getSingers());
			pst.setBinaryStream(5, fisObj1);
			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | IOException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot add Song into genre db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This method is used to remove song from genre db
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public boolean removeGenreSongs(Song songName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from genre_song_list where song_name= ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songName.getSongName());
			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot remove Song from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This method is used to check whether song is present in db or not
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public boolean isGenreSongPresent(String songName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isExist = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select exists(select from genre_song_list where song_name=?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songName);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				isExist = result.getBoolean("exists");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot check Song is present in db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isExist;
	}

	/**
	 * This method is used to get list of songs in music genre
	 *
	 * @param genreName
	 * @return
	 * @throws DBException
	 */
	public List<MusicGenre> getGenreSongList(Integer genreId) throws DBException {
		List<MusicGenre> genreSongList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select genre.genre,genre_song_list.song_name,genre_song_list.music_director,genre_song_list.singers from genre_song_list inner join genre on genre_song_list.genre_id=genre.genre_id where genre.genre_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, genreId);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songName = result.getString("song_name");
				String musicDirector = result.getString("music_director");
				String singers = result.getString("singers");
				String genre = result.getString(GENRE);
				MusicGenre genreList = new MusicGenre(songName, musicDirector, singers, genre);
				genreSongList.add(genreList);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot List genre details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return genreSongList;
	}

	/**
	 * This method is used to get song source file
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public byte[] getMusicGenreSongSrc(String songName) throws DBException {
		byte[] songSource = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select song_src from genre_song_list where song_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songName);
			result = pst.executeQuery();
			while (result.next()) {
				songSource = result.getBytes(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot get music genre song source from db");
		} finally {
			ConnectionUtil.close(result, pst, connection);
		}
		return songSource;
	}

	/**
	 * This method is used to get list of songs in music genre
	 *
	 * @param genreName
	 * @return
	 * @throws DBException
	 */
	public List<MusicGenre> getAllGenreNames() throws DBException {
		List<MusicGenre> genreList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select genre,genre_id from genre";
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String genreName = result.getString(GENRE);
				Integer genreId = result.getInt("genre_id");

				MusicGenre musicGenre = new MusicGenre(genreName, genreId);
				genreList.add(musicGenre);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot List genre details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return genreList;
	}

	/**
	 * This method returns Recommended genre for particular user based on age
	 *
	 * @param age
	 * @return
	 * @throws DBException
	 */
	public List<MusicGenre> getRecommendedGenre(List<String> genreList) throws DBException {
		List<MusicGenre> recommendedGenreList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select genre,genre_id from genre where genre=?";
			pst = connection.prepareStatement(sql);
			for (String genre : genreList) {
				pst.setString(1, genre);
				ResultSet result = pst.executeQuery();
				while (result.next()) {
					String genreName = result.getString(GENRE);
					Integer genreId = result.getInt("genre_id");
					MusicGenre musicGenre = new MusicGenre(genreName, genreId);
					recommendedGenreList.add(musicGenre);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot List recommended genre details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return recommendedGenreList;
	}

}
