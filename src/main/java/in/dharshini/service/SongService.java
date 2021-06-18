package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.SearchSongDAO;
import in.dharshini.dao.SongDAO;
import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;

public class SongService {

	/**
	 * this method is used to add new song into database
	 * 
	 * @param songName
	 * @throws DBException
	 */
	public static boolean addSong(Song songName) {
		return SongDAO.addSong(songName);
	}
	
	/**
	 * This method is used to delete a song from database
	 * @param songName
	 * @return
	 */
	public boolean removeSongs(Song songName) {
		return SongDAO.removeSongs(songName);
	}

	/**
	 * This method is used to get songs from database
	 * 
	 * @param movieId
	 * @return
	 * @throws DBException
	 */
	public List<Song> getSongs(Integer movieId) throws DBException {
		return SongDAO.getAllSongs(movieId);
	}

	/**
	 * This method is used to get song_link from database
	 * 
	 * @param songId
	 * @return
	 * @throws DBException
	 */
	public Song getSongLink(Integer songId) throws DBException {
		return SongDAO.getSongLinkAndSong(songId);
	}

	/**
	 * This method is used to get song link of searched song
	 * 
	 * @param song
	 * @return
	 * @throws DBException
	 */
	public Song getSearchedSongLink(String song) throws DBException {
		return SearchSongDAO.getSearchedSongLink(song);

	}

}
