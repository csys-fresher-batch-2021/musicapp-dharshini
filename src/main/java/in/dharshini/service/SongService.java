package in.dharshini.service;

import java.util.List;

import in.dharshini.dao.MusicGenreDAO;
import in.dharshini.dao.SongDAO;
import in.dharshini.dto.SongDTO;
import in.dharshini.model.Movie;
import in.dharshini.model.MusicGenre;
import in.dharshini.model.Song;
import in.dharshini.userexception.DBException;

public class SongService {

	SongDAO songDao = new SongDAO();
	MusicGenreDAO musicGenreDao = new MusicGenreDAO();

	/**
	 * this method is used to add new song into database
	 *
	 * @param songName
	 * @throws DBException
	 */
	public boolean addSong(Song songDetails) throws DBException {
		return songDao.addSong(songDetails);
	}

	/**
	 * this method is used to add new song into genre_song_list database
	 *
	 * @param songName
	 * @throws DBException
	 */
	public boolean addGenreSong(MusicGenre songDetails) throws DBException {
		return musicGenreDao.addGenreSong(songDetails);
	}

	/**
	 * this method is used to add new Genre into genre database
	 *
	 * @param songName
	 * @throws DBException
	 */
	public boolean addGenre(String genre) throws DBException {
		return musicGenreDao.addGenre(genre);
	}

	/**
	 * this method is used to remove Genre from genre database
	 *
	 * @param songName
	 * @throws DBException
	 */
	public boolean removeGenre(String genre) throws DBException {
		return musicGenreDao.removeGenre(genre);
	}

	/**
	 * This method is used to delete a song from database
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public boolean removeSongs(Song songName) throws DBException {
		return songDao.removeSongs(songName);
	}

	/**
	 * This method is used to delete a song from genre database
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public boolean removeGenreSongs(Song songName) throws DBException {
		return musicGenreDao.removeGenreSongs(songName);
	}

	/**
	 * This method checks whether song is present in db or not
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public boolean isSongPresent(String songName) throws DBException {
		return songDao.isSongPresent(songName);
	}

	/**
	 * This method checks whether song is present in db or not
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public boolean isGenreSongPresent(String songName) throws DBException {
		return musicGenreDao.isGenreSongPresent(songName);
	}

	/**
	 * This method is used to get all songs list from database
	 *
	 * @param movieId
	 * @return
	 * @throws DBException
	 */
	public List<Song> getSongsNames(Movie movieName) throws DBException {
		return songDao.getAllSongNames(movieName);
	}

	/**
	 * This method is used to get song_source from database
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public byte[] getSongFile(String songName) throws DBException {
		return songDao.getSongSrc(songName);
	}

	/**
	 * This method is used to get music genre song_source from database
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public byte[] getMusicGenreSongSrc(String songName) throws DBException {
		return musicGenreDao.getMusicGenreSongSrc(songName);
	}

	/**
	 * This method is used to get list of songs for the user search keyword
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public List<SongDTO> searchSongList(Song songName) throws DBException {
		return songDao.searchSongList(songName);
	}

	/**
	 * This method is used to get song details
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public SongDTO getSearchSongDetails(String songName) throws DBException {
		return songDao.getSearchSongDetails(songName);
	}

	/**
	 * This method is used to get list of songs available in each music genre
	 *
	 * @param genreName
	 * @return
	 * @throws DBException
	 */
	public List<MusicGenre> getGenreSongList(Integer genreId) throws DBException {
		return musicGenreDao.getGenreSongList(genreId);

	}

	/**
	 * This method gives list of songs available for searched keyword
	 *
	 * @param songName
	 * @return
	 * @throws DBException
	 */
	public List<SongDTO> getSearchSongList(Song songName) throws DBException {
		return songDao.searchSongList(songName);
	}

}
