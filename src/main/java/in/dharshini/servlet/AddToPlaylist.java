package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dharshini.model.Playlist;
import in.dharshini.service.PlaylistService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AddToPlaylist
 */
@WebServlet("/AddToPlaylist")
public class AddToPlaylist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String infoMessage = "Song Successfully added";
		String errorMessage = "Song Already Added to playlist";

		String songName = request.getParameter("song");
		PlaylistService pService = new PlaylistService();
		boolean isValid = false;
		Integer userId = (Integer) session.getAttribute("userId");
		try {
			Playlist playlist = new Playlist(userId, songName);
			isValid = pService.addPlaylist(playlist);
			if (isValid) {
				response.sendRedirect("PlaylistServlet?infoMessage=" + infoMessage);
			} else {
				response.sendRedirect("PlaylistServlet?errorMessage=" + errorMessage);
			}
		} catch (IOException | DBException e) {
			Logger.println(e);
		}
	}
}
