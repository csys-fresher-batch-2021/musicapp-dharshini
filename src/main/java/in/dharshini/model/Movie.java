package in.dharshini.model;

import java.sql.Date;

public class Movie {

	private String movieName;
	private String movieImage;
	private String musicDirector;
	private Date movieReleaseDate;
	private Integer movieId;
	private Integer languageId;

	public Movie(Integer languageId, String movieName, String musicDirector, Date movieReleaseDate, String movieImage) {
		super();
		this.languageId = languageId;
		this.movieName = movieName;
		this.musicDirector = musicDirector;
		this.movieReleaseDate = movieReleaseDate;
		this.movieImage = movieImage;
	}

	public Movie(Integer languageId, String movieName, String movieImage) {
		super();
		this.languageId = languageId;
		this.movieName = movieName;
		this.movieImage = movieImage;

	}

	public Movie(String movieName) {
		super();
		this.movieName = movieName;
	}

	public Movie(String movieName, String musicDirector, Date movieReleaseDate) {
		super();
		this.movieName = movieName;
		this.musicDirector = musicDirector;
		this.movieReleaseDate = movieReleaseDate;
	}

	public Movie(String movieName, String musicDirector) {
		super();
		this.movieName = movieName;
		this.musicDirector = musicDirector;

	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public Movie(String movieName, Integer movieId) {
		super();
		this.movieName = movieName;
		this.movieId = movieId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieName() {
		return movieName;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
}