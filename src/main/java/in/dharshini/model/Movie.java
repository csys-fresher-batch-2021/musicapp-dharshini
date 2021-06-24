package in.dharshini.model;

public class Movie {

	private String movieName;
	private Integer movieId;
	private Integer languageId;

	public Movie(Integer languageId, String movieName) {
		super();
		this.languageId = languageId;
		this.movieName = movieName;
	}

	public Movie(String movieName) {
		this.movieName = movieName;
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