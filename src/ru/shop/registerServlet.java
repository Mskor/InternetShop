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
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String requestedName = request.getParameter("registerName");
		Long password = Long.valueOf(request.getParameter("registerPass"));
		LoginService loginService = new LoginService();
		
		try {
			boolean authUser = loginService.register(requestedName, password);
			if(authUser != true){
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("register.jsp");
			}
		} catch (SQLException e) {
			response.sendRedirect("register.jsp");
		}
	}

}
