package in.dharshini.model;

public class Playlist {

	private Integer userId;
	private String playlistSongName;
	private String playlistSongLink;

	public Playlist(Integer userId, String playlistSongName, String playlistSongLink) {
		super();
		this.userId = userId;
		this.playlistSongName = playlistSongName;
		this.playlistSongLink = playlistSongLink;
	}

	public Playlist(Integer userId) {
		super();
		this.userId = userId;
	}

	public Playlist(String playlistSongName, String playlistSongLink) {
		super();
		this.playlistSongName = playlistSongName;
		this.playlistSongLink = playlistSongLink;
	}

	public String getPlaylistSongName() {
		return playlistSongName;
	}

	public void setPlaylistSongName(String playlistSongName) {
		this.playlistSongName = playlistSongName;
	}

	public String getPlaylistSongLink() {
		return playlistSongLink;
	}

	public void setPlaylistSongLink(String playlistSongLink) {
		this.playlistSongLink = playlistSongLink;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
