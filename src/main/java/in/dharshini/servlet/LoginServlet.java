package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");

		try {
		boolean isValid = LoginService.loginDetailCheck(emailId, password);
			if (isValid) {
				// HttpSession session = request.getSession();
				// session.setAttribute("LOGGED_IN_USER", emailId);
				response.sendRedirect("Language.jsp");
			} else {
				String errormessage = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errormessage=" + errormessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
