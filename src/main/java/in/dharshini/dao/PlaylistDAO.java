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

	/**
	 * This method is used to add songs and userid to playlist db
	 *
	 * @param playlist
	 * @return
	 */
	public boolean addPlaylistDetails(Playlist playlist) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isValid = false;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into playlists(user_id,playlist_song) values (?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, playlist.getUserId());
			pst.setString(2, playlist.getPlaylistSongName());
			pst.executeUpdate();
			isValid = true;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isValid;
	}

	/**
	 * This method is used to get the list of playlist songs of an individual
	 *
	 * @param userId
	 * @return
	 * @throws DBException
	 */
	public List<String> getIndividualsPlaylistSongs(Playlist userId) throws DBException {
		List<String> userPlaylist = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select playlist_song from playlists where user_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId.getUserId());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songName = result.getString("playlist_song");
				userPlaylist.add(songName);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot List playlist details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userPlaylist;

	}

	/**
	 * This method is used to get the list of all songs in playlist
	 *
	 * @param userId
	 * @return
	 * @throws DBException
	 */
	public List<Playlist> getAllPlaylistSongs(Playlist userId) throws DBException {
		List<Playlist> playlistList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select playlist_song from playlists where user_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId.getUserId());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String songName = result.getString("playlist_song");
				Playlist play = new Playlist(songName);
				playlistList.add(play);
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot List playlist details from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return playlistList;

	}

	/**
	 * This method is used to clear all songs from playlist
	 *
	 * @param userId
	 */
	public void clearPlaylist(Playlist userId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from playlists where user_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId.getUserId());
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			Logger.println(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to delete particaular song from playlist
	 *
	 * @param idAndSong
	 * @return
	 * @throws DBException
	 */
	public boolean removePlaylistSong(Playlist idAndSong) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isremoved = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from playlists where user_id=? and playlist_song=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, idAndSong.getUserId());
			pst.setString(2, idAndSong.getPlaylistSongName());
			pst.executeUpdate();
			isremoved = true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DBException(e, "Sorry. Cannot remove playlist song from db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isremoved;
	}

}
