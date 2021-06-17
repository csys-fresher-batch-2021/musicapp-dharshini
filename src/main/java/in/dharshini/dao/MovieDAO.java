package in.dharshini.dao;
import in.dharshini.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;

public class MovieDAO {
	private MovieDAO() {
		// Default constructor
	}

	public static void addMovies(Movie movieName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into movies (language_id,movie) values (?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, movieName.getMovieName());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Unable to add movie in db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public static List<Movie> getAllMovies(Integer languageId) throws DBException {
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
				String movieName = result.getString("movie");
				Movie movie = new Movie(movieName,movieId);
				moviesList.add(movie);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "Sorry. Cannot List movie details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return moviesList;
	}

}
