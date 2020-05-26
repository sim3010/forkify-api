package org.simran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.simran.model.CircleService;
import org.simran.model.Customer;
import org.simran.model.DeliveryPerson;
import org.simran.model.Dish;
import org.simran.model.Order;
import org.simran.model.Restaurant;

public class DatabaseJSdemo {
	private static PreparedStatement stmt;
	private static ResultSet results;
	
	public static Customer getCustomer(long mobile,String password) {
		String query = "SELECT * from CUSTOMER where mobile = "+ String.valueOf(mobile) +" and custPassword = '"+password+"';";
		Customer customer = new Customer();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			results = stmt.executeQuery();
			if(!results.first())
				return null;	
			results.beforeFirst();
			while(results.next()) {
				customer.setMobile(Long.valueOf(results.getString("mobile")));
				customer.setCustName(results.getString("custName"));
				customer.setEmail(results.getString("email"));
				customer.setLocation(results.getString("location"));
				customer.setPassword(results.getString("custPassword"));
				customer.setAddress(results.getString("address"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	
	public static void addCustomer(Customer cust){
		String query = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?);";
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1,cust.getCustName());
			stmt.setString(2,cust.getPassword());
			stmt.setLong(3,cust.getMobile());
			stmt.setString(4,cust.getAddress());
			stmt.setString(5,cust.getLocation());
			stmt.setString(6,cust.getEmail());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Restaurant> getRestaurantsByLocation(String location){
		String query = "select * from RESTAURANT WHERE location = ?" ;
		List<Restaurant> restByLoc = new ArrayList<Restaurant>();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1,location);
			results = stmt.executeQuery();
			if(!results.first())
				return restByLoc;	
			results.beforeFirst();
			while(results.next()) {
				Restaurant rest = new Restaurant();
				rest.setCategory(results.getString("category"));
				rest.setLocation(results.getString("location"));
				rest.setRating(results.getDouble("rating"));
				rest.setRestId(results.getLong("restId"));
				rest.setRestName(results.getString("restName"));
				rest.setServingState(results.getBoolean("servingState"));
				restByLoc.add(rest);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return restByLoc;
	}
	
	public static List<Dish> getDishesByRestaurant(long restId){
		String query = "select * from DISH INNER JOIN SERVES on DISH.dishName = SERVES.dishName where SERVES.restId = ?;" ;
		List<Dish> dishByRest = new ArrayList<Dish>();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setLong(1,restId);
			results = stmt.executeQuery();
			if(!results.first())
				return dishByRest;	
			results.beforeFirst();
			while(results.next()) {
				Dish dish = new Dish();
				dish.setAvailable(results.getBoolean("available"));
				dish.setCategory(results.getString("category"));
				dish.setDishName(results.getString("dishName"));
				dish.setPrice(results.getDouble("price"));
				dish.setServingRestId(results.getLong("restId"));
				dish.setVeg(results.getBoolean("veg"));
				dishByRest.add(dish);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dishByRest;
	}
	
	public static List<Restaurant> getRestaurantByDish(String dish){
		String query = "SELECT * FROM RESTAURANT WHERE RESTAURANT.restId IN(select SERVES.restId from SERVES where dishName = ?);";
		List<Restaurant> restByDish = new ArrayList<Restaurant>();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1,dish);
			results = stmt.executeQuery();
			if(!results.first())
				return restByDish;	
			results.beforeFirst();
			while(results.next()) {
				Restaurant rest = new Restaurant();
				rest.setCategory(results.getString("category"));
				rest.setLocation(results.getString("location"));
				rest.setRating(results.getDouble("rating"));
				rest.setRestId(results.getLong("restId"));
				rest.setRestName(results.getString("restName"));
				rest.setServingState(results.getBoolean("servingState"));
				restByDish.add(rest);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return restByDish;
	}
	
	public static List<Order> getOrderByCustomer(long mobile){
		String query = "select * from ORDERS where mobile = ?;" ;
		List<Order> custOrders = new ArrayList<Order>();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setLong(1,mobile);
			results = stmt.executeQuery();
			if(!results.first())
				return custOrders;	
			results.beforeFirst();
			while(results.next()) {
				Order order = new Order();
				order.setDate(results.getDate("orderDate"));
				order.setMobile(results.getLong("mobile"));
				order.setOrderId(results.getLong("orderId"));
				order.setOrderStatus(results.getString("orderStatus"));
				order.setRestId(results.getLong("restId"));
				custOrders.add(order);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return custOrders;
	}
	
	public static String getRestaurantNameById(long restId) {
		String query = "SELECT restName from RESTAURANT where restId=?;";
		String restName = "";
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setLong(1,restId);
			results = stmt.executeQuery();
			if(!results.first())
				return null;	
			results.beforeFirst();
			while(results.next()) {
				restName = results.getString("restName");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return restName;
	}
	
	public static void addOrderByCustomer(Order order){
		String query = "INSERT INTO ORDERS VALUES(?,?,?,?,?);";
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setLong(1,order.getMobile());
			stmt.setLong(2, order.getRestId());
			stmt.setLong(3,order.getOrderId());
			stmt.setDate(4,order.getDate());
			stmt.setString(5,order.getOrderStatus());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<DeliveryPerson> getDeliveryPersonByLocation(String location){
		String query = "SELECT * FROM DELIVERYPERSON where location = ?;";
		List<DeliveryPerson> dp = new ArrayList<DeliveryPerson>();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1,location);
			results = stmt.executeQuery();
			if(!results.first())
				return dp;	
			results.beforeFirst();
			while(results.next()) {
				DeliveryPerson dev = new DeliveryPerson();
				dev.setAvailable(results.getBoolean("available"));
				dev.setDivPersonId(results.getLong("divPersonId"));
				dev.setDivPersonName(results.getString("divPersonName"));
				dev.setLocation(results.getString("location"));
				dev.setRating(results.getDouble("rating"));
				dev.setSalary(results.getDouble("salary"));
				dp.add(dev);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dp;
	}
	
	/*
  select * from CUSTOMER,RESTAURANT WHERE (CUSTOMER.mobile,RESTAURANT.restId) IN
	(select mobile,restId from RECOMMENDS where mobile IN
		(select followeeId as mobile from circle where followerId = 9837050954)
	);
	 */
	public static List<CircleService> getCircleRecommendation(long custId){
		String query = "select * from CUSTOMER,RESTAURANT WHERE (CUSTOMER.mobile,RESTAURANT.restId) IN(select mobile,restId from RECOMMENDS where mobile IN(select followeeId as mobile from circle where followerId = ?));";
		List<CircleService> cs = new ArrayList<CircleService>();
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setLong(1,custId);
			results = stmt.executeQuery();
			if(!results.first())
				return cs;	
			results.beforeFirst();
			while(results.next()) {
				CircleService cir = new CircleService();
				Restaurant rest = new Restaurant();
				Customer cust = new Customer();
				rest.setCategory(results.getString("category"));
				rest.setLocation(results.getString("location"));
				rest.setRating(results.getDouble("rating"));
				rest.setRestId(results.getLong("restId"));
				rest.setRestName(results.getString("restName"));
				rest.setServingState(results.getBoolean("servingState"));
				
				cust.setMobile(Long.valueOf(results.getString("mobile")));
				cust.setCustName(results.getString("custName"));
				cust.setEmail(results.getString("email"));
				cust.setLocation(results.getString("location"));
				cust.setPassword(results.getString("custPassword"));
				cust.setAddress(results.getString("address"));
				cir.setCustomer(cust);
				cir.setRestaurant(rest);
				
				cs.add(cir);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return cs;
	}
	
	
	public static void postRecommendation(long mobile,long restId){
		String query = "INSERT INTO RECOMMENDS VALUES(?,?);";
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setLong(1,mobile);
			stmt.setLong(2,restId);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void expandCircle(long mobile, long friendMobile){
		String query = "INSERT INTO CIRCLE VALUES(?,?);";
		try(Connection conn = DBConnection.createNewDBConnection()){
			stmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setLong(1,mobile);
			stmt.setLong(2,friendMobile);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
