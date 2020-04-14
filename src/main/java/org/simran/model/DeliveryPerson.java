package org.simran.model;

public class DeliveryPerson {
	long divPersonId;
	String divPersonName;
	double rating;
	double salary;	
	String location;
	boolean available;
	
	public DeliveryPerson() {
		
	}
	public DeliveryPerson(long divPersonId,String divPersonName,double rating,double salary,String location,boolean available) {
		this.divPersonId = divPersonId;
		this.divPersonName = divPersonName;
		this.rating = rating;
		this.salary = salary;
		this.location = location;
		this.available = available;	
	}
	public long getDivPersonId() {
		return divPersonId;
	}
	public void setDivPersonId(long divPersonId) {
		this.divPersonId = divPersonId;
	}
	public String getDivPersonName() {
		return divPersonName;
	}
	public void setDivPersonName(String divPersonName) {
		this.divPersonName = divPersonName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
