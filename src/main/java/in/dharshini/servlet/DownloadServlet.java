package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.dto.SongDTO;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String songName = request.getParameter("songName");
		try {
			SongService service = new SongService();
			SongDTO songDetails = service.getSearchSongDetails(songName);
			if (songDetails != null) {
				request.setAttribute("songDetails", songDetails);
				RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
				rd.forward(request, response);
			}
		} catch (IOException | DBException e) {
			Logger.println(e);
		}

	}
}
