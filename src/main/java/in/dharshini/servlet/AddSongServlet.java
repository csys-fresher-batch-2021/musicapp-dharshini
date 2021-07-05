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

import in.dharshini.model.Song;
import in.dharshini.service.SongService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AddSongServlet
 */
@MultipartConfig
@WebServlet("/AddSongServlet")
public class AddSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorMessage = "Cannot Add Song. Check Input Details";
		String message = "Successfully added";
		SongService songService = new SongService();
		boolean isDone = false;

		try {
			Integer languageId = Integer.parseInt(request.getParameter("languageId"));
			Integer movieId = Integer.parseInt(request.getParameter("movieId"));
			String songName = request.getParameter("songName");
			String singers = request.getParameter("singers");
			if (!songService.isSongPresent(songName)) {
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

				Song songDetails = new Song(languageId, movieId, songName, singers, uploads);
				isDone = songService.addSong(songDetails);
				if (isDone) {
					response.sendRedirect("AddOrDeleteSong.jsp?message=" + message);
				}
			} else {
				response.sendRedirect("AddOrDeleteSong.jsp?errorMessage=Song Already Exist");
			}
		} catch (DBException | IOException | ServletException e) {
			try {
				response.sendRedirect("AddOrDeleteSong.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				Logger.println(e1);
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
