package in.dharshini.model;

import java.io.File;

public class MusicGenre {
	private String songName;
	private String musicDirector;
	private String singers;
	private String genre;
	private Integer genreId;

	private File songFile;

	private byte[] songSrc;

	public MusicGenre(String genre, Integer genreId) {
		super();
		this.genre = genre;
		this.genreId = genreId;

	}

	public MusicGenre(String songName, String musicDirector, Integer genreId, String singers, File songFile) {
		super();
		this.songName = songName;
		this.musicDirector = musicDirector;
		this.genreId = genreId;
		this.singers = singers;
		this.songFile = songFile;
	}

	public MusicGenre(String songName, String musicDirector, String singers, String genre) {
		super();
		this.songName = songName;
		this.musicDirector = musicDirector;
		this.singers = singers;
		this.genre = genre;

	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public File getSongFile() {
		return songFile;
	}

	public void setSongFile(File songFile) {
		this.songFile = songFile;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public byte[] getSongSrc() {
		return songSrc;
	}

	public void setSongSrc(byte[] songSrc) {
		this.songSrc = songSrc;
	}

}
