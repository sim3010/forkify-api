package org.simran.services;

import java.util.List;

import org.simran.dao.DatabaseJSdemo;
import org.simran.model.DeliveryPerson;

public class DeliveryPersonService {
	
	public List<DeliveryPerson> getDeliveryPersonByLocation(String location){
		
		return DatabaseJSdemo.getDeliveryPersonByLocation(location);
	}
	

}
