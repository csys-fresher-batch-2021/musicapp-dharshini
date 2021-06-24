package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.Movie;
import in.dharshini.service.MovieService;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class RemoveLanguageServlet
 */
@WebServlet("/RemoveMovieServlet")
public class RemoveMovieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieName = request.getParameter("movie");
		Movie movie = new Movie(movieName);
		boolean isDone = false;
		String errorMessage1 = "Cannot remove movie. Movie Does Not Exist";
		String message1 = "Successfully Removed";
		try {
			MovieService movieService = new MovieService();
			isDone = movieService.removeMovies(movie);
			if (isDone) {
				response.sendRedirect("AddOrDeleteMovie.jsp?message=" + message1);
			} else {
				response.sendRedirect("AddOrDeleteMovie.jsp?errorMessage=" + errorMessage1);
			}
		} catch (IOException e) {
			Logger.println(e);
		}

	}
}