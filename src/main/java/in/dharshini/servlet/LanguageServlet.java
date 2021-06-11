package in.dharshini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.util.Logger;

/**
 * Servlet implementation class LanguageServlet
 */
@WebServlet("/LanguageServlet")
public class LanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doGet() is used to get languageName from language.jsp and redirect
	 * languageId to Movie.jsp
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String languageId = request.getParameter("languages");

			response.sendRedirect("Movie.jsp?languageId=" + languageId);
		} catch (Exception e) {
			Logger.println(e);
		}
	}
}
