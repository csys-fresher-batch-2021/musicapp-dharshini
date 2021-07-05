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

import in.dharshini.model.Movie;
import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class MovieDAO {
	private static final String MOVIE = "movie";
	private static final String MUSIC_DIRECTOR = "music_director";

	/**
	 * This Method is used to add movies to db
	 *
	 * @param movieName
	 * @return
	 * @throws DBException
	 */
	public boolean addMovies(Movie movieName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try (FileInputStream fisObj1 = new FileInputStream(movieName.getMovieImage())) {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into movies (language_id,movie,music_director,movie_release_date,movie_img) values (?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, movieName.getLanguageId());
			pst.setString(2, movieName.getMovieName());
			pst.setString(3, movieName.getMusicDirector());
			pst.setDate(4, movieName.getMovieReleaseDate());
			pst.setBinaryStream(5, fisObj1);
			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new DBException(e, "Sorry. Cannot add movie into db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This method is used to remove movies from db
	 *
	 * @param movieName
	 * @return
	 */
	public boolean removeMovies(Movie movieName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isDone = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from movies where movie= ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, movieName.getMovieName());

			pst.executeUpdate();
			isDone = true;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot remove movie from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDone;
	}

	/**
	 * This Method is used to get all available movies from db for search by
	 * language feature
	 *
	 * @param languageId
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getAllMovies(Integer languageId) throws DBException {
		final List<Movie> moviesList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select movie_id,movie from movies as m inner join languages as l on m.language_id = l.language_id where l.language_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, languageId);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				Integer movieId = result.getInt("movie_id");
				String movieName = result.getString(MOVIE);
				Movie movie = new Movie(movieName, movieId);
				moviesList.add(movie);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot List movies from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return moviesList;
	}

	/**
	 * This method is used to get movie's banner image source drom db
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public byte[] getMovieImageSrc(String imageName) throws DBException {
		byte[] songImageSource = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select movie_img from movies where movie=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, imageName);
			result = pst.executeQuery();
			while (result.next()) {
				songImageSource = result.getBytes(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot get movie Image source from db");
		} finally {
			ConnectionUtil.close(result, pst, connection);
		}
		return songImageSource;
	}

	/**
	 * This method is used to get list of albums(movies) for the user's search
	 * keyword
	 *
	 * @param movieName
	 * @return
	 */
	public List<Movie> searchMovieList(String movieName) throws DBException {
		List<Movie> searchMovieList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "SELECT movie,music_director FROM movies WHERE LOWER(movie) LIKE  '" + movieName.toLowerCase()
					+ "%'";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String movie = result.getString(MOVIE);
				String musicDirector = result.getString(MUSIC_DIRECTOR);
				Movie movieObj = new Movie(movie, musicDirector);
				searchMovieList.add(movieObj);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot List search result for movies from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return searchMovieList;
	}

	/**
	 * This method gets the Particular movie details for album search
	 *
	 * @param movieName
	 * @return
	 * @throws DBException
	 */
	public Movie getMovieDetails(Movie movieName) throws DBException {
		Movie movieObj = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT movie,music_director,movie_release_date FROM movies WHERE movie = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, movieName.getMovieName());
			result = pst.executeQuery();
			while (result.next()) {
				String movie = result.getString(MOVIE);
				String musicDirector = result.getString(MUSIC_DIRECTOR);
				Date movieReleaseDate = result.getDate("movie_release_date");
				movieObj = new Movie(movie, musicDirector, movieReleaseDate);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot get movie details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return movieObj;
	}

	/**
	 * This method gets he list of recent movies released in past 5 months
	 *
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getRecentReleasedMovie() throws DBException {
		List<Movie> recentReleaseMovieList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT movie,music_director FROM movies WHERE movie_release_date > now() - interval '5 month'";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String movie = result.getString(MOVIE);
				String musicDirector = result.getString(MUSIC_DIRECTOR);
				Movie movieObj = new Movie(movie, musicDirector);
				recentReleaseMovieList.add(movieObj);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot get recently released movies from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return recentReleaseMovieList;
	}

	/**
	 * This method gets list of all available movies details in db
	 *
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getAllMovies() throws DBException {
		List<Movie> allMoviesList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT movie,music_director,movie_release_date FROM movies";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String movie = result.getString(MOVIE);
				String musicDirector = result.getString(MUSIC_DIRECTOR);
				Date movieReleaseDate = result.getDate("movie_release_date");
				Movie movieObj = new Movie(movie, musicDirector, movieReleaseDate);
				allMoviesList.add(movieObj);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot List movies from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return allMoviesList;
	}
}
