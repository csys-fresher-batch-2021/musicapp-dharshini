package in.dharshini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dharshini.model.User;
import in.dharshini.service.LoginService;
import in.dharshini.service.PlaylistService;
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

		Integer userId = null;
		User mail = new User(emailId);
		PlaylistService pService = new PlaylistService();
		try {
			User userIdObj = pService.getUserId(mail);
			userId = userIdObj.getUserId();
		} catch (DBException e1) {
			Logger.println(e1);
		}

		HttpSession session = request.getSession();
		User user = new User(emailId, password);
		boolean isValid = LoginService.loginDetailCheck(user);
		if (isValid) {
			try {
				session.setAttribute("LOGGED_IN_USER", emailId);
				session.setAttribute("userId", userId);
				response.sendRedirect("Language.jsp");
			} catch (Exception e) {
				Logger.println(e);
			}
		} else {
			try {
				String errormessage = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errormessage=" + errormessage);
			} catch (Exception e) {
				Logger.println(e);
			}
		}
	}
}
