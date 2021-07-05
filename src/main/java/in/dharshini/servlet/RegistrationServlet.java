package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.User;
import in.dharshini.service.UserService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService loginService = new UserService();

		try {
			String firstName = request.getParameter("fName");
			Integer age = Integer.parseInt(request.getParameter("age"));
			String newMail = request.getParameter("email");
			String newPassword = request.getParameter("password");
			User user = new User(firstName, newMail, newPassword, age);
			boolean isValid = loginService.checkNotRegisteredUser(user);
			if (isValid) {
				response.sendRedirect("Login.jsp");
			} else {
				String errormessage = "Already registered User or Invalid Registration Credentials";
				response.sendRedirect("Registration.jsp?errormessage=" + errormessage);
			}
		} catch (NumberFormatException | DBException | IOException e) {
			Logger.println(e);
		}
	}
}
