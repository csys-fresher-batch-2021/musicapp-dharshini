package in.dharshini.dto;

import java.sql.Date;

public class SongDTO {

	private Integer languageId;
	private Integer hasSong;
	private Integer movieId;
	private String songName;
	private String movieName;
	private String musicDirector;
	private String singers;

	private String songFile;
	private String movieImage;

	private byte[] songSrc;
	private byte[] songImageSrc;

	private Date movieReleasedDate;

	public SongDTO(Integer languageId, Integer movieId, String songName, String movieName, String musicDirector,
			String singers, String songFile, Date movieReleasedDate) {
		super();
		this.languageId = languageId;
		this.movieId = movieId;
		this.songName = songName;
		this.movieName = movieName;
		this.musicDirector = musicDirector;
		this.singers = singers;
		this.songFile = songFile;
		this.movieReleasedDate = movieReleasedDate;
	}

	public SongDTO(String musicDirector, Date movieReleaseDate) {
		super();
		this.musicDirector = musicDirector;
		this.movieReleasedDate = movieReleaseDate;
	}

	public SongDTO(String songName, String movieName, String musicDirector, String singers, Date movieReleaseDate) {
		super();
		this.songName = songName;
		this.movieName = movieName;
		this.musicDirector = musicDirector;
		this.singers = singers;
		this.movieReleasedDate = movieReleaseDate;
	}

	public Date getMovieReleasedDate() {
		return movieReleasedDate;
	}

	public void setMovieReleasedDate(Date movieReleasedDate) {
		this.movieReleasedDate = movieReleasedDate;
	}

	public SongDTO(Integer hasSong, String songName) {
		super();
		this.hasSong = hasSong;
		this.songName = songName;
	}

	public SongDTO(String movieName) {
		super();
		this.movieName = movieName;
	}

	public SongDTO(byte[] songSrc) {
		super();
		this.songSrc = songSrc;
	}

	public SongDTO(byte[] songSource, byte[] songImageSource) {
		super();
		this.songSrc = songSource;
		this.songImageSrc = songImageSource;
	}

	public SongDTO(byte[] songImageSrc, String movieName, String songName) {
		super();
		this.songImageSrc = songImageSrc;
		this.movieName = movieName;
		this.songName = songName;
	}

	public SongDTO(Integer languageId, Integer movieId, String songName, String songFile, String songImage) {
		super();
		this.languageId = languageId;
		this.movieId = movieId;
		this.songName = songName;
		this.songFile = songFile;
		this.movieImage = songImage;
	}

	public SongDTO(String songName, String movieName) {
		super();
		this.songName = songName;
		this.movieName = movieName;

	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public String getSingers() {
		return singers;
	}

	public void setSingers(String singers) {
		this.singers = singers;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getHasSong() {
		return hasSong;
	}

	public void setHasSong(Integer hasSong) {
		this.hasSong = hasSong;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongFile() {
		return songFile;
	}

	public void setSongFile(String songFile) {
		this.songFile = songFile;
	}

	public String getSongImage() {
		return movieImage;
	}

	public void setSongImage(String songImage) {
		this.movieImage = songImage;
	}

	public byte[] getSongSrc() {
		return songSrc;
	}

	public void setSongSrc(byte[] songSrc) {
		this.songSrc = songSrc;
	}

	public byte[] getSongImageSrc() {
		return songImageSrc;
	}

	public void setSongImageSrc(byte[] songImageSrc) {
		this.songImageSrc = songImageSrc;
	}

}
