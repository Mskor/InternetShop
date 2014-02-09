package ru.shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.shop.dto.User;
import ru.shop.services.LoginService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String requestedName = request.getParameter("reqName");
		String password = request.getParameter("reqPass");
		LoginService loginService = new LoginService();
		try {
			User authUser = loginService.authenticate(requestedName, password);
			if(authUser != null){
				user.setName(authUser.getName());
				user.setCash(authUser.getCash());
				user.setUserId(authUser.getUserId());
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
