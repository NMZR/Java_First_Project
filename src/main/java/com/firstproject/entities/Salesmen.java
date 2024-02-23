package com.firstproject.entities;

public class Salesmen {
	
	private String username;
	private int id;
	
	public Salesmen(String username, int id) {
		this.username = username;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public String toString() {
		return "Username of salesmen: " + username;
	}
}
