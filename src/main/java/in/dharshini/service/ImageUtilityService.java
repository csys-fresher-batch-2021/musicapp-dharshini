package in.dharshini.service;

import in.dharshini.dao.SongDAO;
import in.dharshini.dao.UtilitiesDAO;
import in.dharshini.userexception.DBException;

public class ImageUtilityService {

	/**
	 * This method is used to get image source used for styling
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public byte[] getStyleImageSrc(String imageName) throws DBException {
		return UtilitiesDAO.getStyleImageSrc(imageName);
	}

	/**
	 * This method is used to get banner image source of songs
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */
	public byte[] getSongImageSrc(String imageName) throws DBException {
		return SongDAO.getSongImageSrc(imageName);
	}
}
