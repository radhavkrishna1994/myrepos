package com.jpmc.bean;

import java.io.Serializable;

public class Customer implements Serializable{
	private long custId;
	private String name;
	@Override
	public String toString() {
		return custId+" "+name+" "+address+" "+email+" "+phoneNo;
	}
	private String address;
	private String email;
	private String phoneNo;

	public Customer() {
		super();
	}
	public Customer(long custId, String name, String address, String email,
			String phoneNo) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
