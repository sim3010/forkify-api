package org.simran.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.simran.model.Restaurant;
import org.simran.services.RestaurantService;

import java.util.List;

import javax.ws.rs.GET;

@Path("/dishes")
public class DishResource {

	RestaurantService restaurantService = new RestaurantService();	
	@GET
	@Path("/{dishName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> getRestaurantByDish(@PathParam("dishName") String dish) {
		return restaurantService.getRestaurantByDish(dish);
	}
}
