package org.simran.model;

import java.util.List;

public class Recommendation {	
	long custId;
	List<Restaurant> recommendations;
	
	public Recommendation(long custId,List<Restaurant> recommendations) {
		this.custId = custId;
		this.recommendations = recommendations;
	}
	public Recommendation() {
		// TODO Auto-generated constructor stub
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public List<Restaurant> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Restaurant> recommendations) {
		this.recommendations = recommendations;
	}
	
	
}
