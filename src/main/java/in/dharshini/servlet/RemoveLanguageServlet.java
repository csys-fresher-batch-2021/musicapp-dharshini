package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.Language;
import in.dharshini.service.LanguageService;
import in.dharshini.userexception.DBException;

/**
 * Servlet implementation class RemoveLanguageServlet
 */
@WebServlet("/RemoveLanguageServlet")
public class RemoveLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LanguageService languageService = new LanguageService();

		String languageName = request.getParameter("language");
		Language langName = new Language(languageName);
		boolean isDone = false;
		String errorMessage = "Cannot remove language. Language Does Not Exist";
		String message = "Successfully Removed";
		try {
			isDone = languageService.removeLanguage(langName);
			if (isDone) {
				response.sendRedirect("AddOrDeleteLanguage.jsp?message=" + message);
			}
		} catch (IOException | DBException e) {
			response.sendRedirect("AddOrDeleteLanguage.jsp?errorMessage=" + errorMessage);
		}
	}
}
