package org.simran.services;



import java.util.ArrayList;
import java.util.List;
import org.simran.dao.DatabaseJSdemo;
import org.simran.model.CircleService;
import org.simran.model.Customer;
import org.simran.model.Order;
import org.simran.model.OrderService;

public class CustomerService {

	
	
	public CustomerService() {

	}
	
	public Customer getCustomer(long mobile,String password) {
		return DatabaseJSdemo.getCustomer(mobile, password);
	}
	
	public Customer addCustomer(Customer cust) {
		DatabaseJSdemo.addCustomer(cust);
		return cust;
	}
	
	public List<OrderService> getOrderByCustomer(long mobile){
		List<Order> o =  DatabaseJSdemo.getOrderByCustomer(mobile);
		List<OrderService> os= new ArrayList<OrderService>();
		for(int i = 0; i < o.size(); i++) {
			String restName = DatabaseJSdemo.getRestaurantNameById(o.get(i).getRestId());
		os.add(new OrderService(o.get(i).getOrderId(),restName,o.get(i).getDate(),o.get(i).getOrderStatus()));
		}
		return os;
	}
	
	public Order addOrderByCustomer(Order order) {
		DatabaseJSdemo.addOrderByCustomer(order);
		return order;
	}
	
	public List<CircleService> getCircleRecommendation(long mobile){
		return DatabaseJSdemo.getCircleRecommendation(mobile);
	}
	
	public void postRecommendation(long mobile,long restId) {
		 DatabaseJSdemo.postRecommendation(mobile,restId);
	}
	
	public void expandCircle(long mobile,long friendMobile) {
		DatabaseJSdemo.expandCircle(mobile,friendMobile);
	}
}
