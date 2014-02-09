package ru.shop.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ru.shop.dto.User;

public class LoginService {
	private static String username = "postgres";
	private static String password = "bottybot01";
	private static String URL = "jdbc:postgresql://127.0.0.1:5432/merashop";
	
	public User authenticate(String reqName, String reqPass) throws SQLException{
		User res = null;
		
		
		ArrayList<User> userList = new ArrayList<User>();
		
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Connection connection = DriverManager.getConnection(URL, username, password);
    	statement = connection.createStatement();
		    	
    	
			ResultSet rs = statement.executeQuery("select * from users");
					
			while(rs.next()){
				User u = new User(rs.getLong(1),rs.getString(2),rs.getLong(3), rs.getLong(4));				
				userList.add(u);			
			}	
		
			for(User u : userList){
				if(reqName.equals(u.getName()) && reqPass.equals(((Long)u.getPassword()).toString())){
					res = u;
				};
			}
		return res;
	}
	
	public boolean register(String userName, long userPassword) throws SQLException{
		User res = null;
		
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		Connection connection = DriverManager.getConnection(URL, username, password);
    	statement = connection.createStatement();
    	
    	return statement.execute("insert into users (name, passhash, cash) values ('"+userName+"', "+userPassword+", 0)"); 
    	
	}
}
