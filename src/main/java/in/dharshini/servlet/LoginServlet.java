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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");

		boolean isValid = LoginService.loginDetailCheck(emailId, password);
		if (isValid) {
			try {
				response.sendRedirect("Language.jsp");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			try {
				String errormessage = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errormessage=" + errormessage);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}