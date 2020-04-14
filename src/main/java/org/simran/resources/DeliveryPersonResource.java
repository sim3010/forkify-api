package org.simran.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.simran.model.DeliveryPerson;
import org.simran.services.DeliveryPersonService;

@Path("/deliveryPerson")
public class DeliveryPersonResource {
	
	DeliveryPersonService deliveryPersonService = new DeliveryPersonService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{location}")
	public List<DeliveryPerson> getDeliveryPersonByLocation(@PathParam("location") String location){
		
		return deliveryPersonService.getDeliveryPersonByLocation(location);
	}

}
