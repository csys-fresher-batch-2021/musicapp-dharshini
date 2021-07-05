package in.dharshini.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import in.dharshini.dao.MovieDAO;
import in.dharshini.dao.MusicGenreDAO;
import in.dharshini.model.Movie;
import in.dharshini.model.MusicGenre;
import in.dharshini.userexception.DBException;

public class MovieService {
	private static final String MELODY = "Melody";
	private static final String ILAYARAAJA_HITS = "Ilayaraaja_hits";
	MovieDAO movieDao = new MovieDAO();
	MusicGenreDAO musicGenreDao = new MusicGenreDAO();

	/**
	 * This Method calls addMovies() method from movieDAO to add new movies into
	 * database
	 *
	 * @param movieName
	 * @throws DBException
	 * @throws FileNotFoundException
	 */
	public boolean addMovies(Movie movieName) throws DBException {
		return movieDao.addMovies(movieName);
	}

	/**
	 * This method is used to remove movie from db
	 *
	 * @param movieName
	 * @return
	 */
	public boolean removeMovies(Movie movieName) throws DBException {
		return movieDao.removeMovies(movieName);
	}

	/**
	 * This method is used to get all movies from database
	 *
	 * @param languageId
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getMovies(Integer languageId) throws DBException {
		return movieDao.getAllMovies(languageId);
	}

	/**
	 * This method is used to get movie_image_source from database
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public byte[] getMovieImageSrc(String imageName) throws DBException {
		return movieDao.getMovieImageSrc(imageName);
	}

	/**
	 * This method is used to get movie details
	 *
	 * @param movieName
	 * @return
	 * @throws DBException
	 */
	public Movie getMovieDetails(Movie movieName) throws DBException {
		return movieDao.getMovieDetails(movieName);
	}

	/**
	 * Thi method is used get list of albums for the user search keyword
	 *
	 * @param movieName
	 * @return
	 * @throws DBException
	 */
	public List<Movie> searchMovieList(Movie movieName) throws DBException {
		return movieDao.searchMovieList(movieName);
	}

	/**
	 * This method returns list of recently released movies from d
	 *
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getRecentReleasedMovie() throws DBException {
		return movieDao.getRecentReleasedMovie();
	}

	/**
	 * This method returns list of all movies in db
	 *
	 * @return
	 * @throws DBException
	 */
	public List<Movie> getAllMovies() throws DBException {
		return movieDao.getAllMovies();
	}

	/**
	 * This method returns list of all genre from db
	 *
	 * @return
	 * @throws DBException
	 */
	public List<MusicGenre> getAllGenreNames() throws DBException {
		return musicGenreDao.getAllGenreNames();
	}

	/**
	 * This method returns Recommended genre for particular user based on age
	 *
	 * @param age
	 * @return
	 * @throws DBException
	 */
	public List<MusicGenre> getRecommendedGenre(Integer age) throws DBException {
		List<String> genreList = new ArrayList<>();
		if (age <= 7) {
			genreList.add("Kids");
		} else if (age > 7 && age <= 15) {
			genreList.add("Folk");
			genreList.add(MELODY);
		} else if (age > 15 && age <= 25) {
			genreList.add(MELODY);
			genreList.add(ILAYARAAJA_HITS);
			genreList.add("Folk");
		} else if (age > 25 && age <= 50) {
			genreList.add(MELODY);
			genreList.add(ILAYARAAJA_HITS);
		} else if (age >= 50) {
			genreList.add(ILAYARAAJA_HITS);
			genreList.add("60s And 70s Hits");
		}
		return musicGenreDao.getRecommendedGenre(genreList);
	}
}