package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.PlaylistDAO;
import in.dharshini.dao.UserDAO;
import in.dharshini.model.Playlist;
import in.dharshini.model.User;
import in.dharshini.userexception.DBException;

public class PlaylistService {

	
	
	/**
	 * This method adds List of songs in playlist db
	 * 
	 * @param playlist
	 * @return
	 * @throws DBException
	 */
	public boolean addPlaylist(Playlist playlist) throws DBException {
		boolean isvalid=false;
		isvalid = PlaylistDAO.addPlaylistDetails(playlist);
		return isvalid;
	}

	/**
	 * This method gets the particular user_id with the help of email from users db
	 * 
	 * @param mailId
	 * @return
	 * @throws DBException
	 */
	public User getUserId(User mailId) throws DBException {
		UserDAO dao = new UserDAO();
		return (dao.getParticularUserId(mailId));
	}

	/**
	 * This method gets the list of all songs from db
	 * 
	 * @param userId
	 * @return
	 * @throws DBException
	 */
	public List<Playlist> getAllPlaylistSongs(Playlist userId) throws DBException {
		PlaylistDAO dao = new PlaylistDAO();
		return (dao.getAllPlaylistSongs(userId));
	}
}
