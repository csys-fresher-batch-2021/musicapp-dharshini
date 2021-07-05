package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dharshini.util.Logger;

/**
 * Servlet implementation class PlayServlet
 */
@WebServlet("/PlayServlet")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String songName = request.getParameter("songName");
			String movieName = request.getParameter("movieName");
			String genreSongName = request.getParameter("genreSongName");
			if (songName != null) {
				HttpSession session = request.getSession(false);
				session.setAttribute("songName", songName);
				response.sendRedirect("AlbumServlet?movieName=" + movieName);
			}
			if (genreSongName != null) {
				Integer genreId = Integer.parseInt(request.getParameter("genreId"));
				HttpSession session = request.getSession(false);
				session.setAttribute("genreSongName", genreSongName);
				response.sendRedirect("MusicGenreServlet?genreId=" + genreId);
			}
		} catch (NumberFormatException | IOException e) {
			Logger.println(e);
		}
	}
}
