package org.simran.services;

import java.util.List;

import org.simran.dao.DatabaseClass;
import org.simran.model.DeliveryPerson;

public class DeliveryPersonService {
	
	public List<DeliveryPerson> getDeliveryPersonByLocation(String location){
		
		return DatabaseClass.getDeliveryPersonByLocation(location);
	}
	

}
