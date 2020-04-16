package org.simran.services;



import java.util.ArrayList;
import java.util.List;
import org.simran.dao.DatabaseClass;
import org.simran.model.Circle;
import org.simran.model.CircleService;
import org.simran.model.Customer;
import org.simran.model.Order;
import org.simran.model.OrderService;
import org.simran.model.Recommendation;

public class CustomerService {

	
	
	public CustomerService() {

	}
	
	public Customer getCustomer(long mobile,String password) {
		return DatabaseClass.getCustomer(mobile,password);
	}
	
	public Customer addCustomer(Customer cust) {
		DatabaseClass.addCustomer(cust);
		return cust;
	}
	
	public List<OrderService> getOrderByCustomer(long mobile){
		List<Order> o =  DatabaseClass.getOrderByCustomer(mobile);
		List<OrderService> os= new ArrayList<OrderService>();
		for(int i = 0; i < o.size(); i++) {
			String restName = DatabaseClass.getRestaurantNameById(o.get(i).getRestId());
		os.add(new OrderService(o.get(i).getOrderId(),restName,o.get(i).getDate(),o.get(i).getOrderStatus()));
		}
		return os;
	}
	
	public Order addOrderByCustomer(Order order) {
		DatabaseClass.addOrderByCustomer(order);
		return order;
	}
	
	public List<CircleService> getCircleRecommendation(long mobile){
		return DatabaseClass.getCircleRecommendation(mobile);
	}
	
	public Recommendation postRecommendation(long mobile,long restId) {
		return DatabaseClass.postRecommendation(mobile,restId);
	}
	
	public Circle expandCircle(long mobile,long friendMobile) {
		return DatabaseClass.expandCircle(mobile,friendMobile);
	}
}
