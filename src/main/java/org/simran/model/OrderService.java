package org.simran.model;

import java.util.Date;

public class OrderService {
	long orderId;
	String restName;
	Date date;
	String orderStatus;
	
	public OrderService(long orderId,String restName,Date date,String orderStatus) {
		this.orderId = orderId;
		this.restName = restName;
		this.date = date;
		this.orderStatus = orderStatus;
		}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
