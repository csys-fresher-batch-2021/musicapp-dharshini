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
 
	/** This doGet() is used to get language parameter from AddLanguage.jsp and adds that language into database
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String languageName = request.getParameter("language");
		Language langName = new Language(languageName);
		try {
			LanguageService.addLanguage(langName);
			response.sendRedirect("Language.jsp");
		} catch (DBException | IOException e) {
			Logger.println(e);		}
	}
}
