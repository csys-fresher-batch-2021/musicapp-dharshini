package in.dharshini.service;

import in.dharshini.dao.UtilitiesDAO;
import in.dharshini.userexception.DBException;

public class ImageUtilityService {

	UtilitiesDAO utilityDao = new UtilitiesDAO();

	/**
	 * This method is used to get image source used for styling
	 *
	 * @param imageName
	 * @return
	 * @throws DBException
	 */

	public byte[] getStyleImageSrc(String imageName) throws DBException {
		return utilityDao.getStyleImageSrc(imageName);
	}
}
