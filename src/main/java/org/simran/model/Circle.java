package org.simran.model;

import java.util.List;

public class Circle {
	long mobile;
	List<Customer> circle;
	
	public Circle(long mobile,List<Customer> circle) {
		this.mobile = mobile;
		this.circle = circle;
	}
	
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public List<Customer> getCircle() {
		return circle;
	}
	public void setCircle(List<Customer> circle) {
		this.circle = circle;
	}
	
}
