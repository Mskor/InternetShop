package ru.shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.shop.dto.ShoppingCart;
import ru.shop.dto.User;
import ru.shop.services.CashService;

/**
 * Servlet implementation class cashService
 */
@WebServlet("/CashServlet")
public class CashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation= request.getParameter("operation");
		long income = Long.valueOf(request.getParameter("income"));		
		User user = (User) session.getAttribute("user");
		CashService cashService = new CashService();
			try {				
				if(operation.equals("add")){
					cashService.addCash(user, income);
					user.setCash(user.getCash() + income);
					response.sendRedirect("cashier.jsp");
				}
				else if(operation.equals("remove") && user.getCash() - income >= 0) {
					income = -income;
					cashService.addCash(user, income);
					user.setCash(user.getCash() + income);
					ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
					cart.removeAll();
					response.sendRedirect("success.jsp");
				} else if(operation.equals("remove") && user.getCash() - income < 0){
					response.sendRedirect("failure.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}

}
