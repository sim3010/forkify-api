package org.simran.model;

public class Restaurant {
	String category;
	double rating;
	long restId;
	String location;
	String restName;
	boolean servingState;
	
	public Restaurant() {
		
	}
	public Restaurant(String category,double rating,long restId,String location,String restName,boolean servingState) {
		this.category = category;
		this.rating = rating;
		this.restId = restId;
		this.location = location;
		this.restName = restName;
		this.servingState = servingState;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public long getRestId() {
		return restId;
	}
	public void setRestId(long restId) {
		this.restId = restId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public boolean isServingState() {
		return servingState;
	}
	public void setServingState(boolean servingState) {
		this.servingState = servingState;
	}
	
}
