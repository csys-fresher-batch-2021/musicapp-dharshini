package in.dharshini.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.dharshini.model.Movie;
import in.dharshini.service.MovieService;
import in.dharshini.userexception.DBException;

/**
 * Servlet implementation class AddMovieServlet
 */
@MultipartConfig
@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorMessage = "Cannot Add Movie. Check Input Details";
		String message = "Successfully added";

		try {
			Integer languageId = Integer.parseInt(request.getParameter("languageId"));
			String movieName = request.getParameter("movie");
			String musicDirector = request.getParameter("musicDirector");
			String movieDate = request.getParameter("movieReleaseDate");
			Date movieReleaseDate = Date.valueOf(movieDate);
			final Part imagePart = request.getPart("movieImageFile");
			final String imageFileName = getFileName(imagePart);
			String fileLocation = getServletContext().getInitParameter("upload.location");
			if (fileLocation == null || "null".equals(fileLocation)) {
				fileLocation = "E:/MusicAppProjectUploads";
			}
			File uploads = new File(fileLocation + File.separator + imageFileName);

			InputStream in = imagePart.getInputStream();
			Files.copy(in, uploads.toPath(), StandardCopyOption.REPLACE_EXISTING);
			in.close();
			Movie movie = new Movie(languageId, movieName, musicDirector, movieReleaseDate, uploads);
			boolean isDone = false;
			MovieService mService = new MovieService();
			isDone = mService.addMovies(movie);
			if (isDone) {
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("AddOrDeleteMovie.jsp");
				rd.forward(request, response);
			}
		} catch (NumberFormatException | IOException | DBException e) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("AddOrDeleteMovie.jsp");
			rd.forward(request, response);
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
