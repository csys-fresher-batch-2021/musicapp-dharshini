package in.dharshini.dto;

public class SongDTO {

	private Integer languageId;
	private Integer hasSong;
	private Integer movieId;
	private String songName;

	private String songFile;
	private String songImage;

	private byte[] songSrc;
	private byte[] songImageSrc;

	public SongDTO(Integer hasSong, String songName) {
		super();
		this.hasSong = hasSong;
		this.songName = songName;
	}

	public SongDTO(String songName) {
		super();
		this.songName = songName;
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

	public SongDTO(Integer languageId, Integer movieId, String songName, String songFile, String songImage) {
		super();
		this.languageId = languageId;
		this.movieId = movieId;
		this.songName = songName;
		this.songFile = songFile;
		this.songImage = songImage;
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
		return songImage;
	}

	public void setSongImage(String songImage) {
		this.songImage = songImage;
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
