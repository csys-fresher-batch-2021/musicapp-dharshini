package in.dharshini.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.dharshini.model.MusicGenre;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AddGenreSongServlet
 */
@MultipartConfig
@WebServlet("/AddGenreSongServlet")
public class AddGenreSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "AddOrDeleteGenreAndSong.jsp?errorMessage=Cannot Add Genre Song. Check Input Details";
	private static final String ERROR_MESSAGE1 = "AddOrDeleteGenreAndSong.jsp?errorMessage=Cannot add Genre.Check Input Details";
	private static final String INFO_MESSAGE = "AddOrDeleteGenreAndSong.jsp?errorMessage=Successfully added";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SongService songService = new SongService();
		boolean isDone = false;

		try {
			String songName = request.getParameter("songName");
			String musicDirector = request.getParameter("musicDirector");
			Integer genreId = Integer.parseInt(request.getParameter("genreId"));
			String singers = request.getParameter("singers");
			if (!songService.isGenreSongPresent(songName)) {
				final Part songPart = request.getPart("songFile");
				final String songFileName = getFileName(songPart);
				String fileLocation = getServletContext().getInitParameter("upload.location");
				if (fileLocation == null || "null".equals(fileLocation)) {
					fileLocation = "E:/MusicAppProjectUploads";
				}
				File uploads = new File(fileLocation + File.separator + songFileName);

				InputStream in = songPart.getInputStream();
				Files.copy(in, uploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
				in.close();
				MusicGenre songDetails = new MusicGenre(songName, musicDirector, genreId, singers, uploads);
				isDone = songService.addGenreSong(songDetails);
				if (isDone) {
					response.sendRedirect(INFO_MESSAGE);
				} else {
					response.sendRedirect(ERROR_MESSAGE);
				}
			} else {
				response.sendRedirect(ERROR_MESSAGE);
			}
		} catch (NumberFormatException | IOException | DBException e) {
			Logger.println(e);
		}

		String genre = request.getParameter("genre");
		if (genre != null) {
			try {
				isDone = songService.addGenre(genre);
				if (isDone) {
					response.sendRedirect(INFO_MESSAGE);
				} else {
					response.sendRedirect(ERROR_MESSAGE1);
				}
			} catch (IOException | DBException e) {
				Logger.println(e);
			}
		}
	}

	/**
	 * This method gets the name of the file to be added to db
	 *
	 * @param part
	 * @return
	 */
	public String getFileName(final Part songPart) {

		final String partHeader = songPart.getHeader("content-disposition");
		for (String content : partHeader.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
