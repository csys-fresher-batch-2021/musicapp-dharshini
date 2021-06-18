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
 * Servlet implementation class RemoveSongServlet
 */
@WebServlet("/RemoveSongServlet")
public class RemoveSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String songName = request.getParameter("song");
		Song song = new Song(songName);
		boolean isDone = false;
		String errorMessage1 = "Cannot remove song. Song Does Not Exist";
		String message1 = "Successfully Removed";
		{
			SongService songService = new SongService();
			isDone = songService.removeSongs(song);
			if (isDone) {
				response.sendRedirect("AddOrDeleteSong.jsp?message=" + message1);
			} else {
				response.sendRedirect("AddOrDeleteSong.jsp?errorMessage=" + errorMessage1);
			}
		}

	}
}
