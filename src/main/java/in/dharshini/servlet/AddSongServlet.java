package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.dto.SongDTO;
import in.dharshini.service.SongService;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AddSongServlet
 */
@WebServlet("/AddSongServlet")
public class AddSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			boolean isDone = false;
			String errorMessage = "Cannot Add Song. Check Input Details";
			String message = "Successfully added";
			Integer languageId = Integer.parseInt(request.getParameter("languageId"));
			Integer movieId = Integer.parseInt(request.getParameter("movieId"));
			String songName = request.getParameter("songName");
			String songFile = request.getParameter("songFile");
			String songImage = request.getParameter("songImage");
			SongDTO songDetails = new SongDTO(languageId, movieId, songName, songFile, songImage);
			isDone = SongService.addSong(songDetails);
			if (isDone) {
				response.sendRedirect("AddOrDeleteSong.jsp?message=" + message);
			} else {
				response.sendRedirect("AddOrDeleteSong.jsp?errorMessage=" + errorMessage);
			}
		} catch (NumberFormatException | IOException e) {
			Logger.println(e);
		}
	}
}
