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
 * Servlet implementation class AddSongServlet
 */
@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer languageId = Integer.parseInt(request.getParameter("languageId"));
			String movieName = request.getParameter("movie");
			Movie movie = new Movie(languageId, movieName);
			boolean isDone = false;
			String errorMessage = "Cannot Add Movie. Check Input Details";
			String message = "Successfully added";
			MovieService mService = new MovieService();
			isDone = mService.addMovies(movie);
			if (isDone) {
				response.sendRedirect("AddOrDeleteMovie.jsp?message=" + message);
			} else {
				response.sendRedirect("AddOrDeleteMovie.jsp?errorMessage=" + errorMessage);
			}
		} catch (NumberFormatException | IOException e) {
			Logger.println(e);
		}
	}
}
