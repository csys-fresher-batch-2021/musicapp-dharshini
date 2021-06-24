package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dharshini.model.User;
import in.dharshini.service.LoginService;
import in.dharshini.userexception.DBException;
import in.dharshini.userexception.ServiceException;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String infoMessage = "Successfully Updated Password";
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		boolean isUpdated = false;
		User user = null;
		user = new User(emailId, password);
		LoginService loginService = new LoginService();
		try {
			isUpdated = loginService.updatePassword(user);
			if (isUpdated) {
				response.sendRedirect("ForgotPassword.jsp?infoMessage=" + infoMessage);
			}
		} catch (ServiceException | IOException e) {
			response.sendRedirect("ForgotPassword.jsp?errorMessage=Please Enter Password In Correct Format");
		} catch (DBException e) {
			response.sendRedirect(
					"ForgotPassword.jsp?errorMessage1=Please Enter Registered MailId. Entered Mail Id is not registered.");
		}
	}
}
