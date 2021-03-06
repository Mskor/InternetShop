package ru.shop;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.shop.dto.Good;
import ru.shop.services.GoodService;

@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       	String sqlQuery = request.getParameter("sqlQuery");
       	
       	GoodService goodService = new GoodService();
       	
       	ArrayList<Good> goods;
		try {
			goods = goodService.getGoodsDetails(sqlQuery);
			HttpSession session = request.getSession();
			session.setAttribute("goodsTable", goods);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
       	
       	
	}         
}
