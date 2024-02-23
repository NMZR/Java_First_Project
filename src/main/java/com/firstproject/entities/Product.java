package com.firstproject.entities;

public class Product {
	
	    private int id;
	    private String name;
	    private int quantity;
		private double price;
		
		
		
	    public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPrice(int price) {
			price = price;
		}
		
		
	 
		

	    @Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
		}
		public Product() {
	    	
	    }

	    public Product(int id, String name, int quantity, int price) {
	        this.id = id;
	        this.name = name;
	        this.quantity = quantity;
	        this.price = price;
	    }
	    
	    public Product(String name, int quantity, int price) {
	       
	        this.name = name;
	        this.quantity = quantity;
	        this.price = price;
	    }

	    // Getters and Setters
		
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public int getQuantity() { return quantity; }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    public double getprice() {
			return price;
		}
		
	}


//i want to create a simple inventory management system with java: 
//manager:
//salesman
//	System Overview
//	Manager:
//	Full access to inventory (add, remove, update, and view products)
//	Salesman:
//	View inventory
//	Sell products (deduct products from inventory)
//	Record sales details (including customer information)
//	THIS IS MY PROJECT REQUIRMENT:
//Requirements
//
//Technologies:
//
//Java 8
//Scanner (Console inputs)
//JDBC (Database Connectivity)
//Stretch Goal: JUnit (Unit Testing)
//Stretch Goal: Logback (Logging)
//MySQL
//Maven (Dependency Management)
//Functionalities:
//
//Basic mathematic manipulation of the fields of an entity object.
//
//User login with passwords and logout.
//
//Stretch Goal: Passwords may not be stored in their raw form in the database. They must be encrypted somehow.
//Stretch Goal: User registration.
//Stretch Goal: Multi-tier Users - have at least two different types of user accounts each different functionality access.
//Validation for invalid inputs.
//
//Design:
//
//Data persistence in a SQL database.
//Must contain at least two entity tables. (Join tables do not count.)
//Must contain at least one relationship between tables.
//Stretch Goal: Create a Many to Many relationship between tables.
//Three layered architecture of the Java application.
//Stretch Goal: Reasonable test coverage of the service layer.
//Stretch Goal: Implement Test Driven Development.
//DAO design pattern.
//










