package org.simran.model;

import java.util.List;

public class Circle {
	long custId;
	List<Customer> circle;
	
	public Circle(long custId,List<Customer> circle) {
		this.custId = custId;
		this.circle = circle;
	}
	
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public List<Customer> getCircle() {
		return circle;
	}
	public void setCircle(List<Customer> circle) {
		this.circle = circle;
	}
	
}
