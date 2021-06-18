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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage="Song Already Added to playlist";
		HttpSession session = request.getSession(false);
		String songName = request.getParameter("song");
		String songLink = request.getParameter("songLink");
		PlaylistService pService = new PlaylistService();
		boolean isValid = false;
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println(userId);
		try {
			session.setAttribute("userId", userId);
			Playlist playlist = new Playlist(userId, songName, songLink);
			isValid = pService.addPlaylist(playlist);
			if(isValid) {
			response.sendRedirect("PlaylistServlet");
			}
			else {
				response.sendRedirect("Playlist.jsp?errorMessage="+errorMessage);
			}
		} catch (DBException e) {
			Logger.println(e);
		}

	}
}
