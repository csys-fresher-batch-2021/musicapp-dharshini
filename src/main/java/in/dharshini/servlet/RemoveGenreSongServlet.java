package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.Song;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class RemoveGenreSongServlet
 */
@WebServlet("/RemoveGenreSongServlet")
public class RemoveGenreSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SongService songService = new SongService();
		String songName = request.getParameter("song");
		if (songName != null) {
			try {
				boolean isDone = false;
				String errorMessage = "Cannot remove song.";
				String message = "Successfully Removed";
				Song song = new Song(songName);
				isDone = songService.removeGenreSongs(song);
				if (isDone) {
					response.sendRedirect("AddOrDeleteGenreAndSong.jsp?message=" + message);
				} else {
					response.sendRedirect("AddOrDeleteGenreAndSong.jsp?errorMessage=" + errorMessage);
				}
			} catch (NumberFormatException | IOException | DBException e) {
				Logger.println(e);
			}
		}
		String genre = request.getParameter("genre");
		boolean isDone = false;
		if (genre != null) {
			String errorMessage = "Cannot remove Genre.Check Input Details";
			String message = "Successfully removed";
			try {
				isDone = songService.removeGenre(genre);
				if (isDone) {
					response.sendRedirect("AddOrDeleteGenreAndSong.jsp?message=" + message);
				} else {
					response.sendRedirect("AddOrDeleteGenreAndSong.jsp?errorMessage=" + errorMessage);
				}
			} catch (IOException | DBException e) {
				Logger.println(e);
			}
		}
	}
}