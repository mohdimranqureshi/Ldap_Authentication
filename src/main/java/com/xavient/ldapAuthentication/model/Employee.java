package com.xavient.ldapAuthentication.model;

public class Employee {
	
	private String userName;
	private String password;
	
	public Employee(){}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
