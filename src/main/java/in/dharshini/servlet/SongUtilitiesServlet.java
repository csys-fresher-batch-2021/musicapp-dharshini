package in.dharshini.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class SongUtilitiesServlet
 */
@WebServlet("/SongUtilitiesServlet")
public class SongUtilitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String songName = request.getParameter("songName");

		try {
			SongService songService = new SongService();
			byte[] songSrc = songService.getSongFile(songName);
			OutputStream obj = response.getOutputStream();
			obj.write(songSrc);
		} catch (DBException e) {
			Logger.println(e);
		}
	}
}
