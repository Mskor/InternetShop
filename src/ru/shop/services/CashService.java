package ru.shop.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ru.shop.dto.User;

public class CashService {
	private static String username = "postgres";
	private static String password = "bottybot01";
	private static String URL = "jdbc:postgresql://127.0.0.1:5432/merashop";
	
	public void addCash(User user, long income) throws SQLException{
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Connection connection = DriverManager.getConnection(URL, username, password);
    	statement = connection.createStatement();
    	long resCash = user.getCash()+income; 
    	statement.executeUpdate("update users set cash = '" + resCash + "' where name = '" + user.getName()+"'");	
    	
	}
}
