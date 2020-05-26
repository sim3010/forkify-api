package org.simran.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.simran.model.Dish;
import org.simran.model.Restaurant;
import org.simran.services.RestaurantService;

@Path("/restaurants")
public class RestaurantResource {
	RestaurantService restaurantService = new RestaurantService();
	
	@GET
	@Path("/{location}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> getRestaurantByLocation(@PathParam("location") String location) {
		return restaurantService.getRestaurantsByLocation(location);
	}
	
	@GET
	@Path("/{restId}/dishes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Dish> getDishesByRestaurant(@PathParam("restId") long restId){
		return restaurantService.getDishesByRestaurant(restId);
	}
	
}
