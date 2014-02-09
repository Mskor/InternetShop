package ru.shop.dto;

public class User {
	private String name;
	private long userId, 
				 cash,
				 password;
	public User(){
		
	}
	public User(long userId, String name, long password, long cash) {
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.cash = cash;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCash() {
		return cash;
	}

	public void setCash(long cash) {
		this.cash = cash;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}	
}
