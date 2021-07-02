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
import in.dharshini.util.Logger;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService loginService = new UserService();
		String errorMessage = " Invalid Admin Credentials";
		String adminEmail = request.getParameter("adminEmail");
		String adminPass = request.getParameter("adminPass");

		User user = new User(adminEmail, adminPass);
		boolean isValid = loginService.adminLoginCheck(user);
		try {
			if (isValid) {
				HttpSession session = request.getSession(false);
				session.setAttribute("ROLE", "ADMIN");
				session.setAttribute("adminEmail", adminEmail);
				response.sendRedirect("Admin.jsp");
			} else {
				response.sendRedirect("AdminLogin.jsp?errorMessage=" + errorMessage);
			}
		} catch (IOException e) {
			Logger.println(e);
		}

	}

}
