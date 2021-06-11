package in.dharshini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.util.Logger;

/**
 * Servlet implementation class SongServlet
 */
@WebServlet("/SongServlet")
public class SongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doGet() gets song from song.jsp redirect to download.jsp with songId
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String songId = request.getParameter("songs");
			response.sendRedirect("Download.jsp?songId=" + songId);
		} catch (Exception e) {
			Logger.println(e);
		}
	}
}
