package org.simran.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	long mobile;
	String custName;
	String location;
	String address;
	String email;
	String password;
	
	public Customer() {
		
	}
	public Customer(long mobile,String custName,String location,String address,String email,String password) {
		this.mobile  = mobile;
		this.custName = custName;
		this.location = location;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
