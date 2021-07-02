package in.dharshini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.dharshini.model.Movie;
import in.dharshini.service.MovieService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AllMoviesServlet
 */
@WebServlet("/AllMoviesServlet")
public class AllMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieService movieService = new MovieService();
		try {
			List<Movie> allMovieList = movieService.getAllMovies();

			Gson gson = new Gson();
			String json = gson.toJson(allMovieList);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (DBException e) {
			Logger.println(e);
		}
	}
}
