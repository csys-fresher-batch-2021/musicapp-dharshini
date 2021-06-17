package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.MovieDAO;
import in.dharshini.model.Movie;
import in.dharshini.userexception.DBException;

public class MovieService {

	/**
	 * This Method calls addMovies() method from movieDAO to add new movies into
	 * database
	 * 
	 * @param movieName
	 * @throws DBException
	 */
	public void addMovies(Movie movieName) throws DBException {
		MovieDAO.addMovies(movieName);
	}

	/**
	 * This method is used to get all movies from database
	 * 
	 * @param languageId
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getMovies(Integer languageId) throws DBException {
		return MovieDAO.getAllMovies(languageId);
	}
}
