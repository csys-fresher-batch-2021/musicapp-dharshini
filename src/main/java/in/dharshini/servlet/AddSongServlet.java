package in.dharshini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.Song;
import in.dharshini.service.SongService;

/**
 * Servlet implementation class AddSongServlet
 */
@WebServlet("/AddSongServlet")
public class AddSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isDone = false;
		String errorMessage = "Cannot Add Song. Check Input Details";
		String message = "Successfully added";

		Integer languageId = Integer.parseInt(request.getParameter("languageId"));
		Integer movieId = Integer.parseInt(request.getParameter("movieId"));
		String songName = request.getParameter("song");
		String songLink = request.getParameter("songLink");

		Song song = new Song(languageId, movieId, songName, songLink);
		isDone = SongService.addSong(song);
		if (isDone) {
			response.sendRedirect("AddOrDeleteSong.jsp?message=" + message);
		} else {
			response.sendRedirect("AddOrDeleteSong.jsp?errorMessage=" + errorMessage);
		}
	}
}
