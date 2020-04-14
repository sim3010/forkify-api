package org.simran.model;

public class Dish {
	String dishName;
	String category;
	boolean veg;
	double price;
	boolean available;
	long servingRestId;
	public Dish() {
		
	}
	public Dish(String dishName, String category,boolean veg,double price,boolean available,long servingRestId) {
		this.dishName = dishName;
		this.category = category;
		this.veg = veg;
		this.price = price;
		this.available = available;
		this.servingRestId = servingRestId;
	}
	public long getServingRestId() {
		return servingRestId;
	}
	public void setServingRestId(long servingRestId) {
		this.servingRestId = servingRestId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isVeg() {
		return veg;
	}
	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
