package in.dharshini.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.MusicGenre;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class SongDemoServlet
 */
@WebServlet("/MusicGenreServlet")
public class MusicGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer genreId = Integer.parseInt(request.getParameter("genreId"));
		String genreName = null;
		SongService service = new SongService();
		try {
			List<MusicGenre> genreSongList = service.getGenreSongList(genreId);
			request.setAttribute("list", genreSongList);
			for (MusicGenre genre : genreSongList) {
				genreName = genre.getGenre();
				break;
			}
			request.setAttribute("genre", genreName);
			request.setAttribute("genreId", genreId);

			RequestDispatcher rd = request.getRequestDispatcher("MusicGenre.jsp");
			rd.forward(request, response);
		} catch (IOException | DBException e) {
			Logger.println(e);
		}
	}
}
