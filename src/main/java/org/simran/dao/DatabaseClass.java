package org.simran.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

import org.simran.model.Circle;
import org.simran.model.Customer;
import org.simran.model.DeliveryPerson;
import org.simran.model.Dish;
import org.simran.model.Order;
import org.simran.model.Restaurant;
import org.simran.model.Recommendation;
import org.simran.model.CircleService;

public class DatabaseClass {
	
	public static List<Customer> customers = new ArrayList<Customer>(Arrays.asList(
			new Customer(9837050954L,"Jagjeet","Bangalore","IISC","jagjeet@gmail.com","12345"),
			new Customer(9643041712L,"Simran","Mangalore","NITK","simran@gmail.com","sim1234")
			));
	
	public static List<Restaurant> restaurants = new ArrayList<Restaurant>(Arrays.asList(
			new Restaurant("fast food",4.5,12345L,"mangalore","g.dot",true),
			new Restaurant("north indian",4.0,3456L,"mangalore","bollywood cafe",true),
			new Restaurant("chinese",4.6,278641L,"bangalore","bombay brazier",false),
			new Restaurant("north indian",3.4,4567L,"surathkal","kalash",true)
			));
	
	
	public static List<Circle> circles = new ArrayList<Circle>(Arrays.asList(
			new Circle(9837050954L,new ArrayList<Customer>(Arrays.asList(
					customers.get(1)))),
			new Circle(9643041712L,new ArrayList<Customer>(Arrays.asList(
					customers.get(0))))
			));
	
	public static List<Recommendation> recommendations = new ArrayList<Recommendation>(Arrays.asList(
			new Recommendation(9837050954L,new ArrayList<Restaurant>(Arrays.asList(
					restaurants.get(0),restaurants.get(1)))),
			new Recommendation(9643041712L,new ArrayList<Restaurant>(Arrays.asList(
					restaurants.get(2),restaurants.get(3))))
			
			));
	public static List<Dish> dishes  = new ArrayList<Dish>(Arrays.asList(
			
			new Dish("white sauce pasta","starters",true,290,true,12345L),
			new Dish("chilly paneer","main course",true,350,false,3456L),
			new Dish("lime soda","beverages",true,160,true,12345L),
			new Dish("lime soda","beverages",true,100,true,4567L)
			
			));
	public static List<Order> orders = new ArrayList<Order>(Arrays.asList(
			
			new Order(89118L,4567L,9837050954L,new Date(),"delivered"),
			new Order(543657L,12345L,9643041712L,new Date(),"in process"),
			new Order(543656L,3456L,9643041712L,new Date(),"on way")
			
			));
	
	public static List<DeliveryPerson> deliveryPersons = new ArrayList<DeliveryPerson>(Arrays.asList(
			new DeliveryPerson(74972L,"harish",4.0,12000,"mangalore",true),
			new DeliveryPerson(39564L,"ramesh",4.6,15000,"bangalore",true),
			new DeliveryPerson(46453L,"soumya",3.5,9000,"mangalore",false)
			
			
			)); 
	
	public static Customer getCustomer(long mobile,String password) {
		for(int i = 0;i<customers.size();i++) {
			if(customers.get(i).getMobile() == mobile && customers.get(i).getPassword().equals(password))
				return customers.get(i);			
		}
		return null;
	}
	
	public static void addCustomer(Customer cust) {
		customers.add(cust);
	}
	
	
	public static List<Restaurant> getRestaurantsByLocation(String location){
		
		List<Restaurant> restByLoc = new ArrayList<Restaurant>();
		for(int i = 0; i < restaurants.size(); i++) {
			if(restaurants.get(i).getLocation().equals(location)) 
				restByLoc.add(restaurants.get(i));
		}
		return restByLoc;
	}
	
	public static List<Dish> getDishesByRestaurant(long restId){
		
		List<Dish> dishesByRest = new ArrayList<Dish>();
		for(int i = 0;i < dishes.size(); i++) {
			if(dishes.get(i).getServingRestId() == restId)
				dishesByRest.add(dishes.get(i));
		}
		return dishesByRest;
	}
	
	public static List<Restaurant> getRestaurantByDish(String dish){
		List<Restaurant> restByDish = new ArrayList<>();
		HashSet<Long>  set = new HashSet<>(); 
		for(int i = 0; i < dishes.size(); i++) {
			if(dishes.get(i).getDishName().equals(dish))
				set.add(dishes.get(i).getServingRestId());
		}

		for(int i = 0; i < restaurants.size(); i++) {
			if(set.contains(restaurants.get(i).getRestId()))
				restByDish.add(restaurants.get(i));
		}
		return restByDish;
	}
	
	public static List<Order> getOrderByCustomer(long mobile){
		List<Order> custOrders = new ArrayList<>();
		for(int i = 0;i<orders.size();i++) {
			if(orders.get(i).getMobile() == mobile)
				custOrders.add(orders.get(i));
		}
		return custOrders;
	}
	
	public static void addOrderByCustomer(Order order) {
		orders.add(order);
	}
	
	public static List<DeliveryPerson> getDeliveryPersonByLocation(String location) {
		List<DeliveryPerson> dp = new ArrayList<>();
		for(int i = 0;i<deliveryPersons.size(); i++) {
			if(deliveryPersons.get(i).getLocation().equals(location))
				dp.add(deliveryPersons.get(i));
		}
		return dp;
	}
	
	public static String getRestaurantNameById(long restId) {
		for(int i = 0;i < restaurants.size(); i++) {
			if(restaurants.get(i).getRestId() == restId) 
				return restaurants.get(i).getRestName();
		}
		return "";
	}
	
	public static List<CircleService> getCircleRecommendation(long custId){
		List<Customer> myCircle = new ArrayList<>();
		List<CircleService> myRecomm = new ArrayList<>();
		for(int i = 0;i < circles.size(); i++) {
			if(circles.get(i).getMobile() == custId)
				myCircle = circles.get(i).getCircle();
		}
		for(int  i = 0;i < myCircle.size(); i++) {
			for(int j = 0;j < recommendations.size(); j++) {
				if(myCircle.get(i).getMobile() == recommendations.get(j).getMobile()) {
					for(int k = 0;k < recommendations.get(j).getRecommendations().size(); k++) {
						myRecomm.add(new CircleService(myCircle.get(i),recommendations.get(j).getRecommendations().get(k)));
					}
				}
			}
		}
		return myRecomm;
	}

	
	public static Recommendation postRecommendation(long mobile,long restId) {
		Restaurant rest = new Restaurant();
		for(int i = 0;i < restaurants.size(); i++) {
			if(restaurants.get(i).getRestId() == restId)
				rest = restaurants.get(i);
		}
		for(int i = 0;i < recommendations.size(); i++) {
			if(recommendations.get(i).getMobile() == mobile) {
				if(!recommendations.get(i).getRecommendations().contains(rest))
					recommendations.get(i).getRecommendations().add(rest);
				return recommendations.get(i);
			}
		}
		return new Recommendation();
	}
	
	public static boolean expandCircle(long mobile, long friendMobile, String password) {
		Customer friend = new Customer();
		
		for(int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getMobile() == mobile) {
				if(!customers.get(i).getPassword().equals(password))
					return false;
			}
			else if(customers.get(i).getMobile() == friendMobile)
				friend = customers.get(i);
		}
		if(friend == null)
			return false;
		for(int i = 0; i < circles.size(); i++) {
			if(circles.get(i).getMobile() == mobile) {
				circles.get(i).getCircle().add(friend);
				return true;
			}
		}
		circles.add(0, new Circle(mobile,new ArrayList<Customer>(Arrays.asList(friend))));
		return true;
	}
}
