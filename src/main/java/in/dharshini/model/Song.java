package in.dharshini.model;

import java.io.File;

public class Song {
	private Integer songId;
	private String songName;

	private Integer languageid;
	private Integer movieId;
	private File songFile;
	private String singers;

	public Song(Integer languageid, Integer movieId, String songName, String singers, File songFile) {
		super();
		this.languageid = languageid;
		this.movieId = movieId;
		this.songName = songName;
		this.singers = singers;
		this.songFile = songFile;
	}

	public Song(Integer languageid, Integer movieId, String songName) {
		super();
		this.songName = songName;
		this.languageid = languageid;
		this.movieId = movieId;
	}

	public Song(String songName) {
		super();
		this.songName = songName;
	}

	public String getSingers() {
		return singers;
	}

	public void setSingers(String singers) {
		this.singers = singers;
	}

	public File getSongFile() {
		return songFile;
	}

	public void setSongFile(File songFile) {
		this.songFile = songFile;
	}

	public Song(String songName, Integer songId) {
		super();
		this.songName = songName;
		this.songId = songId;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Integer getLanguageid() {
		return languageid;
	}

	public void setLanguageid(Integer languageid) {
		this.languageid = languageid;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongName() {
		return songName;
	}
}
