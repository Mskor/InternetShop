package ru.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.shop.dto.ShoppingCart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		String goodId = request.getParameter("goodId");
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		if(operation.equalsIgnoreCase("add")){
			cart.addToCart(goodId);
			response.sendRedirect("index.jsp");
		}
		else if(operation.equalsIgnoreCase("remove")){
			cart.removeFromCart(goodId);
			response.sendRedirect("cart.jsp");
		}
		else{
			throw new ServletException("Wrong operation");
		}
	}

}
