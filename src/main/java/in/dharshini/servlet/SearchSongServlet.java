package in.dharshini.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.dharshini.model.Song;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;

@WebServlet("/SearchSongServlet")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doGet() is used to get song from Searchsong.jsp and get its song link from
	 * database and redirect to searchsong.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String errorMessage = "Sorry. No Results Found. Please make sure your words are spelled correctly or use less or different keywords";
		try {
			String searchedSong = request.getParameter("song");
			SongService songService = new SongService();
			Song songLink = songService.getSearchedSongLink(searchedSong);
			if (songLink != null) {
				request.setAttribute("songLink", songLink);
				request.setAttribute("searchedSong", searchedSong);
				RequestDispatcher rd = request.getRequestDispatcher("SearchSong.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("SearchSong.jsp?errorMessage=" + errorMessage);
			}
		} catch (IOException | ServletException | DBException e) {
			e.printStackTrace();
		}
	}

}
