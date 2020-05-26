package org.simran.services;
import java.util.List;

import org.simran.dao.DatabaseJSdemo;
import org.simran.model.Dish;
import org.simran.model.Restaurant;

public class RestaurantService {

	public List<Restaurant> getRestaurantsByLocation(String location){
		
		return DatabaseJSdemo.getRestaurantsByLocation(location);
	}
	
	public List<Dish> getDishesByRestaurant(long restId){
		return DatabaseJSdemo.getDishesByRestaurant(restId);
		
	}
	
	public List<Restaurant> getRestaurantByDish(String dish){
		
		return DatabaseJSdemo.getRestaurantByDish(dish);
	}
}
