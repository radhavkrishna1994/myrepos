package com.jpmc.bean;

import java.io.Serializable;

public class User implements Serializable{
	private String phoneNo;
	private String password;
	private String role;
	
	@Override
	public String toString() {
		return phoneNo+" "+role;
	}
	public User() {
		super();
	}
	public User(String phoneNo, String password, String role) {
		super();
		this.phoneNo = phoneNo;
		this.password = password;
		this.role = role;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
