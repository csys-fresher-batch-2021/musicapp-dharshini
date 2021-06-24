package in.dharshini.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.service.ImageUtilityService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class SongImageUtilitiesServlet
 */
@WebServlet("/SongImageUtilitiesServlet")
public class SongImageUtilitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imageName = request.getParameter("imageName");
		try {
			ImageUtilityService service = new ImageUtilityService();
			byte[] indexImageSrc = service.getSongImageSrc(imageName);
			OutputStream obj = response.getOutputStream();
			obj.write(indexImageSrc);
		} catch (DBException e) {
			Logger.println(e);
		}
	}
}
