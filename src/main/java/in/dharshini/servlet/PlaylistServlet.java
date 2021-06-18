package in.dharshini.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dharshini.dao.PlaylistDAO;
import in.dharshini.model.Playlist;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class PlaylistServlet
 */
@WebServlet("/PlaylistServlet")
public class PlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Playlist> playlistList = new ArrayList<>();
		HttpSession session = request.getSession(false);

		Integer userId = (Integer) session.getAttribute("userId");
		Playlist playlist = new Playlist(userId);
		PlaylistDAO playlistDao = new PlaylistDAO();
		try {
			playlistList = playlistDao.getAllPlaylistSongs(playlist);
		} catch (DBException e) {
			Logger.println(e);
		}
		request.setAttribute("list", playlistList);
		RequestDispatcher rd = request.getRequestDispatcher("Playlist.jsp");
		rd.forward(request, response);
	}
}
