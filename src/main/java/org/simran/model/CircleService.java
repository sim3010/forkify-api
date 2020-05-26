package org.simran.model;

public class CircleService {
	Customer customer;
	Restaurant restaurant;
	
	public CircleService(Customer customer,Restaurant restaurant) {
		this.customer = customer;
		this.restaurant = restaurant;
	}
	
	public CircleService() {
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}	
}
