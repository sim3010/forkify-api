package org.simran.model;

import java.util.List;

public class Recommendation {	
	long mobile;
	List<Restaurant> recommendations;
	
	public Recommendation(long mobile,List<Restaurant> recommendations) {
		this.mobile = mobile;
		this.recommendations = recommendations;
	}
	public Recommendation() {
		// TODO Auto-generated constructor stub
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public List<Restaurant> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Restaurant> recommendations) {
		this.recommendations = recommendations;
	}
	
	
}
