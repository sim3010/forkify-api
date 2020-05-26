package org.simran.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.simran.services.CustomerService;
import org.simran.model.CircleService;
import org.simran.model.Customer;
import org.simran.model.Order;
import org.simran.model.OrderService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

//All customers requests are handles in this class
@Path("/customers")
public class CustomerResource {
	CustomerService customerService = new CustomerService();
	
// handle api call /customers/custId and returns all the information of customer
	@GET
	@Path("/{custId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("custId") long mobile,@QueryParam("password") String password){
		return customerService.getCustomer(mobile,password);
	}
	
// handle api call /customers and create a customer
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer addCustomer(Customer cust) {
		return customerService.addCustomer(cust);
	}
	
// handle api call /customers/custId/orders display all orders of custId customer
	@GET
	@Path("/{custId}/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderService> getOrderByCustomer(@PathParam("custId") long mobile) {
		return customerService.getOrderByCustomer(mobile);
	}

// handle API customers/orders to add orders to the customer
	@POST
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Order addOrderByCustomer(Order order){
		return customerService.addOrderByCustomer(order);
	}
	
//	handle API call /customers/custId/circle  	
	@GET
	@Path("/{custId}/circle")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CircleService> getCircleRecommendation(@PathParam("custId") long mobile){
		return customerService.getCircleRecommendation(mobile);
	}
	
	@POST
	@Path("/{custId}/circle")
	@Consumes(MediaType.APPLICATION_JSON)
	public void expandCircle(long friendMobile,@PathParam("custId") long mobile) {
		customerService.expandCircle(mobile,friendMobile);
	}
	
	
	@POST
	@Path("/{custId}/recommend")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postRecommendation(long restId,@PathParam("custId") long mobile) {
		customerService.postRecommendation(mobile,restId);
	}
	
	
	
}


