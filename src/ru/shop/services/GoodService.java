package ru.shop.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ru.shop.dto.Good;

public class GoodService {
	
	private static String username = "postgres";
	private static String password = "bottybot01";
	private static String URL = "jdbc:postgresql://127.0.0.1:5432/merashop";
	
	public ArrayList<Good> getGoodsDetails(String sqlQuery) throws SQLException{
		ArrayList<Good> goodsList = new ArrayList<Good>();
		
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Connection connection = DriverManager.getConnection(URL, username, password);
    	statement = connection.createStatement();
		    	
    	try {
			ResultSet rs = statement.executeQuery(sqlQuery);
					
			while(rs.next()){
				Good e = new Good(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4));				
				goodsList.add(e);			
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement.close();
		return goodsList;
	}
}
