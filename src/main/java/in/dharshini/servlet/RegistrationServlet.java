package in.dharshini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.service.RegistrationService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newMail = request.getParameter("email");
		String newPassword = request.getParameter("password");

		boolean isValid = RegistrationService.checkNotRegisteredUser(newMail, newPassword);
		if (isValid) {
			try {
				response.sendRedirect("Login.jsp");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			try {
				String errormessage = "Already registered User or Invalid Registration Credentials";
				response.sendRedirect("Registration.jsp?errormessage=" + errormessage);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
