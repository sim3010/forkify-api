package org.simran.services;
import java.util.List;

import org.simran.dao.DatabaseClass;
import org.simran.model.Dish;
import org.simran.model.Restaurant;

public class RestaurantService {

	public List<Restaurant> getRestaurantsByLocation(String location){
		
		return DatabaseClass.getRestaurantsByLocation(location);
	}
	
	public List<Dish> getDishByRestaurant(long restId){
		return DatabaseClass.getDishesByRestaurant(restId);
		
	}
	
	public List<Restaurant> getRestaurantByDish(String dish){
		
		return DatabaseClass.getRestaurantByDish(dish);
	}
}
