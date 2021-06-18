package in.dharshini.model;

public class Song {
	private String songName;
	private Integer languageid;
	private Integer movieId;
	private Integer songId;
	private String songLink;

	public Song(Integer languageid, Integer movieId, String songName, String songLink) {
		super();
		this.songName = songName;
		this.languageid = languageid;
		this.movieId = movieId;
		this.songLink = songLink;
	}

	public Song(String songLink, String songName) {
		super();
		this.songLink = songLink;
		this.songName = songName;

	}

	public Song(String songName) {
		super();
		this.songName = songName;

	}

	public String getSongLink() {
		return songLink;
	}

	public void setSongLink(String songLink) {
		this.songLink = songLink;
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
