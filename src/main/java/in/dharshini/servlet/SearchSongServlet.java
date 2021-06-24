package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.dto.SongDTO;
import in.dharshini.model.Song;
import in.dharshini.service.SongService;
import in.dharshini.util.Logger;

@WebServlet("/SearchSongServlet")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doGet() is used to get song from Searchsong.jsp and get its song link
	 * from database and redirect to searchsong.jsp
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String searchedSong = request.getParameter("song");
		String errorMessage = "Sorry. No Results Found. Please make sure your words are spelled correctly or use less or different keywords";

		SongService songService = new SongService();
		Song songName = new Song(searchedSong.toLowerCase());

		SongDTO hasSongAndName = songService.isSongPresent(songName);
		try {
			if (hasSongAndName.getHasSong() == 1) {
				response.sendRedirect("SearchSong.jsp?songName=" + hasSongAndName.getSongName());
			} else {
				response.sendRedirect("SearchSong.jsp?errorMessage=" + errorMessage);

			}
		} catch (IOException e) {
			Logger.println(e);
		}
	}
}