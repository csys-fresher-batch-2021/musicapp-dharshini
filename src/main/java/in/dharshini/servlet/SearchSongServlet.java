package in.dharshini.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.dto.SongDTO;
import in.dharshini.model.Movie;
import in.dharshini.model.Song;
import in.dharshini.service.MovieService;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

@WebServlet("/SearchSongServlet")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchedSongOrMovie = request.getParameter("search");
		String errorMessage = "Sorry. No Results Found. Please make sure your words are spelled correctly or use less or different keywords";
		String movieName = null;
		String songName = null;
		SongService songService = new SongService();
		MovieService movieService = new MovieService();

		Song songOrMovieName = new Song(searchedSongOrMovie);
		List<SongDTO> searchSongList;
		List<Movie> searchMovieList;
		try {
			searchSongList = songService.searchSongList(songOrMovieName);
			searchMovieList = movieService.searchMovieList(searchedSongOrMovie);
			if (searchSongList != null || searchMovieList != null) {
				int index = 0;
				for (SongDTO song : searchSongList) {
					index++;
					songName = song.getSongName();
					movieName = song.getMovieName();
					if (index == 1) {
						break;
					}
				}
				request.setAttribute("searchSongList", searchSongList);
				request.setAttribute("searchMovieList", searchMovieList);

				request.setAttribute("songName", songName);
				request.setAttribute("movieName", movieName);
				request.setAttribute("errorMessage", errorMessage);

				RequestDispatcher rd = request.getRequestDispatcher("SearchSong.jsp");
				rd.forward(request, response);
			}
		} catch (IOException | DBException e) {
			Logger.println(e);
		}

	}

}