package in.dharshini.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.Movie;
import in.dharshini.model.Song;
import in.dharshini.service.MovieService;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AlbumServlet
 */
@WebServlet("/AlbumServlet")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieName = request.getParameter("movieName");
		SongService songService = new SongService();
		MovieService movieService = new MovieService();
		Movie movie = new Movie(movieName);
		try {
			Movie movieDetails = movieService.getMovieDetails(movie);
			List<Song> movieSongList = songService.getSongsNames(movie);
			request.setAttribute("movieDetails", movieDetails);
			request.setAttribute("movieSongList", movieSongList);

			RequestDispatcher rd = request.getRequestDispatcher("Album.jsp");
			rd.forward(request, response);
		} catch (IOException | DBException e) {
			Logger.println(e);
		}
	}
}
