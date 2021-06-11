package in.dharshini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.User;
import in.dharshini.service.RegistrationService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doPost() is used to get user details from registration.jsp and store
	 * them in database and redirect to login.jsp
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newMail = request.getParameter("email");
		String newPassword = request.getParameter("password");
		User user = new User(newMail, newPassword);
		try {
			boolean isValid = RegistrationService.checkNotRegisteredUser(user);
			if (isValid) {
				response.sendRedirect("Login.jsp");
			} else {
				String errormessage = "Already registered User or Invalid Registration Credentials";
				response.sendRedirect("Registration.jsp?errormessage=" + errormessage);
			}
		} catch (DBException e) {
			Logger.println(e);
		}
	}
}
