package org.simran.model;

import java.sql.Date;

public class Order {
	long orderId;
	long restId;
	long mobile;
	Date date;
	String orderStatus;
	
	public Order() {
		
	}
	public Order(long orderId,long restId,long mobile,Date date,String orderStatus){
		this.orderId = orderId;
		this.restId = restId;
		this.mobile = mobile;
		this.date = date;
		this.orderStatus = orderStatus;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getRestId() {
		return restId;
	}
	public void setRestId(long restId) {
		this.restId = restId;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
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
