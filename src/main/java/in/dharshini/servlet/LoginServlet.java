package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dharshini.model.User;
import in.dharshini.service.UserService;
import in.dharshini.userexception.DBException;
import in.dharshini.util.Logger;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doPost() is used to get mailId and Password and check for registration
	 * in loginService amd redirect to language.jsp if registered user or redirect
	 * to login.jsp with error message
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		UserService loginService = new UserService();
		Integer userId = null;
		Integer age = null;

		HttpSession session = request.getSession();
		User user = new User(emailId, password);
		boolean isValid = loginService.loginDetailCheck(user);
		if (isValid) {
			User mail = new User(emailId);
			UserService userService = new UserService();
			try {
				User userIdObj = userService.getParticularUserDetails(mail);
				session.setAttribute("LOGGED_IN_USER", userIdObj.getFirstName());
				userId = userIdObj.getUserId();
				age = userIdObj.getAge();
				session.setAttribute("age", age);
				session.setAttribute("userId", userId);
				response.sendRedirect("HomeServlet");
			} catch (IOException | DBException e) {
				Logger.println(e);
			}
		} else {
			try {
				String errormessage = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errormessage=" + errormessage);
			} catch (IOException e) {
				Logger.println(e);
			}
		}

	}
}
