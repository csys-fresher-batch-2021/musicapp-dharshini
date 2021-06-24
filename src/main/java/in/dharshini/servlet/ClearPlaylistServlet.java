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

/**
 * Servlet implementation class ClearPlaylistServlet
 */
@WebServlet("/ClearPlaylistServlet")
public class ClearPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String infoMessage2 = "Your Playlist Cleared Successfully";
		HttpSession session = request.getSession(false);
		Integer userId = (Integer) session.getAttribute("userId");
		Playlist userIdobj = new Playlist(userId);
		PlaylistService pService = new PlaylistService();
		pService.clearPlaylist(userIdobj);
		response.sendRedirect("PlaylistServlet?infoMessage2=" + infoMessage2);
	}

}
