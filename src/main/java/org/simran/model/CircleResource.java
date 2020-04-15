package org.simran.model;

public class CircleResource {
	String password;
	long mobile;
	long friendMobile;
	public CircleResource(){
		
	}
	public CircleResource(String password,long mobile,long friendMobile) {
		this.password = password;
		this.mobile = mobile;
		this.friendMobile = friendMobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public long getFriendMobile() {
		return friendMobile;
	}
	public void setFriendMobile(long friendMobile) {
		this.friendMobile = friendMobile;
	}
	
}
