package in.dharshini.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.dto.SongDTO;
import in.dharshini.model.Movie;
import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;
import in.dharshini.util.Logger;

public class SongDAO {
	private static final String SONG_NAME = "song_name";

	/**
	 * This method is used to add songs src and details to db
	 *
	 * @param songDetails
	 * @return
	 * @throws DBException
	 */
	public boolean addSong(Song songDetails) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;

		try (FileInputStream fisObj1 = new FileInputStream(songDetails.getSongFile())) {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into songs(language_id,movie_id,song_name,singers,song_src) values (?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, songDetails.getLanguageid());
			pst.setInt(2, songDetails.getMovieId());
			pst.setString(3, songDetails.getSongName());
			pst.setString(4, songDetails.getSingers());
			pst.setBinaryStream(5, fisObj1);
			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | IOException | SQLException e) {
			Logger.println(e);
			throw new DBException(e, "Sorry. Cannot add Song into db");
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
	 * @throws DBException
	 */
	public boolean removeSongs(Song songName) throws DBException {
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
	public boolean isSongPresent(String songName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isExist = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select exists(select from songs where song_name=?)";
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
	 * This Method is used to get all songs list from db
	 *
	 * @param movieId
	 * @return
	 * @throws DBException
	 */
	public List<Song> getAllSongNames(Movie movieName) throws DBException {
		final List<Song> songsList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT songs.song_name from songs inner join movies on movies.movie_id=songs.movie_id where movie = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, movieName.getMovieName());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songName = result.getString(SONG_NAME);
				Song song = new Song(songName);
				songsList.add(song);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot get Song list from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return songsList;
	}

	/**
	 * This method gives the list of songs available in db for the searched keyword
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public List<SongDTO> searchSongList(Song songName) throws DBException {
		List<SongDTO> searchSongList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT movies.movie,songs.song_name from movies INNER JOIN songs on movies.movie_id=songs.movie_id WHERE LOWER(song_name) LIKE  '"
					+ songName.getSongName().toLowerCase() + "%'";
			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();
			while (result.next()) {
				String song = result.getString(SONG_NAME);
				String movie = result.getString("movie");
				SongDTO songDto = new SongDTO(song, movie);
				searchSongList.add(songDto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot get searched song list from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return searchSongList;
	}

	/**
	 * This method is used to get song source file
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public byte[] getSongSrc(String songName) throws DBException {
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
			throw new DBException(e, "Sorry. Cannot get song source from db");
		} finally {
			ConnectionUtil.close(result, pst, connection);
		}
		return songSource;
	}

	/**
	 * This method is used to get song details of searched song
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public SongDTO getSearchSongDetails(String songName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		SongDTO songDto = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT songs.song_name,songs.singers,movies.movie,movies.music_director,movies.movie_release_date from movies INNER JOIN songs on movies.movie_id=songs.movie_id WHERE song_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, songName);
			result = pst.executeQuery();
			while (result.next()) {
				String song = result.getString(SONG_NAME);
				String movie = result.getString("movie");
				String musicDirector = result.getString("music_director");
				String singers = result.getString("singers");
				Date movieReleaseDate = result.getDate("movie_release_date");

				songDto = new SongDTO(song, movie, musicDirector, singers, movieReleaseDate);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot get Song details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return songDto;
	}

}