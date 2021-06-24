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
import in.dharshini.util.Logger;

/**
 * Servlet implementation class RemovePlaylistServlet
 */
@WebServlet("/RemovePlaylistServlet")
public class RemovePlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String infoMessage = "Song Successfully Removed";
			String errorMessage = "Song cannot be removed from playlist";
			PlaylistService pService = new PlaylistService();
			String songName = request.getParameter("song");
			HttpSession session = request.getSession(false);
			Integer userId = (Integer) session.getAttribute("userId");
			Playlist idAndSong = new Playlist(userId, songName);
			if (pService.removePlaylistSong(idAndSong)) {
				response.sendRedirect("PlaylistServlet?infoMessage=" + infoMessage);
			} else {
				response.sendRedirect("PlaylistServlet?errorMessage=" + errorMessage);
			}
		} catch (IOException e) {
			Logger.println(e);
		}
	}

}
