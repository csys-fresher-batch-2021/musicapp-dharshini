package in.dharshini.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dharshini.model.Movie;
import in.dharshini.model.MusicGenre;
import in.dharshini.service.MovieService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieService movie = new MovieService();
		HttpSession session = request.getSession(false);

		try {
			Integer age = (Integer) session.getAttribute("age");
			List<MusicGenre> recommendedGenre = movie.getRecommendedGenre(age);
			List<Movie> recentlyReleasedMovie = movie.getRecentReleasedMovie();
			List<MusicGenre> allMusicGenre = movie.getAllGenreNames();
			request.setAttribute("recentlyReleasedMovie", recentlyReleasedMovie);
			request.setAttribute("allMusicGenre", allMusicGenre);
			request.setAttribute("recommendedGenre", recommendedGenre);

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		} catch (IOException | DBException e) {
			Logger.println(e);
		}
	}
}
