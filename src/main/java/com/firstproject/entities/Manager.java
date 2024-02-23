package com.firstproject.entities;

public class Manager {
	int userid;
	String username;
	public Manager(int userid, String username) {
		this.userid = userid;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public int getUserid() {
		return userid;
	}
	
	
}
