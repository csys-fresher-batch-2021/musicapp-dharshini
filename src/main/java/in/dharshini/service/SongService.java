package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.SongDAO;
import in.dharshini.dto.SongDTO;
import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;

public class SongService {

	/**
	 * this method is used to add new song into database
	 *
	 * @param songName
	 * @throws DBException
	 */
	public static boolean addSong(SongDTO songDetails) {
		return SongDAO.addSong(songDetails);
	}

	/**
	 * This method is used to delete a song from database
	 *
	 * @param songName
	 * @return
	 */
	public boolean removeSongs(Song songName) {
		return SongDAO.removeSongs(songName);
	}

	/**
	 * This method is used to get all songs list from database
	 *
	 * @param movieId
	 * @return
	 * @throws DBException
	 */
	public List<Song> getSongsNames(Integer movieId) throws DBException {
		return SongDAO.getAllSongNames(movieId);
	}

	/**
	 * This method is used to get song_image_source from database
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public byte[] getSongImageFile(String imageName) throws DBException {
		return SongDAO.getSongImageSrc(imageName);
	}

	/**
	 * This method is used to get song_source from database
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public byte[] getSongFile(String songName) throws DBException {
		return SongDAO.getSongSrc(songName);
	}

	/**
	 * Checks whether song is available in database or not
	 *
	 * @param song
	 * @return
	 */
	public SongDTO isSongPresent(Song song) {
		return SongDAO.isSongPresent(song);
	}
}
