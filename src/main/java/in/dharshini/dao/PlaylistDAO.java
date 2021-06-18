package in.dharshini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.dharshini.model.Playlist;

import in.dharshini.userexception.DBException;
import in.dharshini.util.ConnectionUtil;
import in.dharshini.util.Logger;

public class PlaylistDAO {

	public static boolean addPlaylistDetails(Playlist playlist)   {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isValid = false;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into playlists(user_id,playlist_song,playlist_song_link) values (?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, playlist.getUserId());
			pst.setString(2, playlist.getPlaylistSongName());
			pst.setString(3, playlist.getPlaylistSongLink());
			pst.executeUpdate();
			isValid = true;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isValid;
	}

	public List<Playlist> getAllPlaylistSongs(Playlist userId) throws DBException {
		List<Playlist> playlistList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select playlist_song,playlist_song_link from playlists where user_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId.getUserId());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songName = result.getString("playlist_song");
				String songLink = result.getString("playlist_song_link");
				Playlist play = new Playlist(songName, songLink);
				playlistList.add(play);
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot List playlist details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return playlistList;

	}
}
