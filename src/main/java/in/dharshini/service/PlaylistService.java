package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.PlaylistDAO;
import in.dharshini.model.Playlist;
import in.dharshini.userexception.DBException;

public class PlaylistService {

	PlaylistDAO dao = new PlaylistDAO();

	/**
	 * This method adds List of songs in playlist db
	 *
	 * @param playlist
	 * @return
	 * @throws DBException
	 */
	public boolean addPlaylist(Playlist playlist) throws DBException {
		boolean isValid = false;
		if (isSongAlreadyInPlaylist(playlist)) {
			Integer userIdInt = playlist.getUserId();
			Playlist userId = new Playlist(userIdInt);
			getAllPlaylistSongs(userId);
		} else {
			isValid = dao.addPlaylistDetails(playlist);
		}
		return isValid;
	}

	/**
	 * This method is used to check whether the song is already present in
	 * Individual users playlist or not
	 *
	 * @param userIdAndSong
	 * @return
	 * @throws DBException
	 */
	public boolean isSongAlreadyInPlaylist(Playlist userIdAndSong) throws DBException {
		boolean isPresent = false;
		List<String> userPlaylist = dao.getIndividualsPlaylistSongs(userIdAndSong);
		if (userPlaylist.contains(userIdAndSong.getPlaylistSongName())) {
			isPresent = true;
		}
		return isPresent;

	}

	/**
	 * This method gets the list of all playlist songs from db
	 *
	 * @param userId
	 * @return
	 * @throws DBException
	 */
	public List<Playlist> getAllPlaylistSongs(Playlist userId) throws DBException {
		return (dao.getAllPlaylistSongs(userId));
	}

	/**
	 * This method is used to clear all songs from individual user's playlist
	 *
	 * @param userId
	 */
	public void clearPlaylist(Playlist userId) {
		dao.clearPlaylist(userId);
	}

	/**
	 * This method is used to remove particular songs from individual user's
	 * playlist
	 *
	 * @param idAndSong
	 * @return
	 * @throws DBException
	 */
	public boolean removePlaylistSong(Playlist idAndSong) throws DBException {
		return dao.removePlaylistSong(idAndSong);

	}
}
