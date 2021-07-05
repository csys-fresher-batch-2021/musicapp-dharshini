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
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AddLanguageServlet
 */
@WebServlet("/AddLanguageServlet")
public class AddLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LanguageService languageService = new LanguageService();
		String languageName = request.getParameter("language");
		Language langName = new Language(languageName);
		boolean isDone = false;
		String errorMessage = "Cannot add language.Check Input Details";
		String message = "Successfully added";
		try {
			isDone = languageService.addLanguage(langName);
			if (isDone) {
				response.sendRedirect("AddOrDeleteLanguage.jsp?message=" + message);
			}
		} catch (IOException | DBException e) {
			try {
				response.sendRedirect("AddOrDeleteLanguage.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				Logger.println(e1);
			}
		}
	}
}
