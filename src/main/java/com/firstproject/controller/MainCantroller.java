package com.firstproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.firstproject.doas.ProductDaoImpl;
import com.firstproject.doas.UserDAO;
import com.firstproject.doas.UserDAOImpl;
import com.firstproject.entities.Inventory;
import com.firstproject.entities.Product;
import com.firstproject.entities.SalesRecord;
//import com.firstproject.entities.Salesmen;
import com.firstproject.entities.Users;

public class MainCantroller {
	

	 private static Inventory inventory = new Inventory();
	 private static UserDAO userDAO = new UserDAOImpl();
	 private static ProductDaoImpl productDAO = new ProductDaoImpl();
	    //private static SalesRecord salesRecord = new SalesRecord();
	    private static Scanner scanner = new Scanner(System.in);
	    //private static ArrayList<SalesRecord> salesRecord = new ArrayList<SalesRecord>();
	   
	    public static void main(String[] args) {
	    	
	            inventory = new Inventory(new ArrayList<>(productDAO.getAllProducts()));
	            System.out.println("=========================================");
	            System.out.println("|| Welcome to the MZR DISTRIBUTION ||");
	            System.out.println("=========================================");
	            System.out.println("*            1. Login                  *");
	            System.out.println("*            2. Create New Account     *");
	            System.out.println("=========================================");
	            System.out.print("Choose an option: ");



	    	    
	    	    int initialChoice = scanner.nextInt();
	    	    scanner.nextLine(); 

	    	    switch (initialChoice) {
	    	        case 1:
	    	            loginUser();
	    	            break;
	    	        case 2:
	    	            createUser();
	    	            break;
	    	        default:
	    	            System.out.println("Invalid option. Exiting...");
	    	            System.exit(0);
	    	    }
	    	

	    	
	    	
	    	
	    	
	   
	    	System.out.println("======================================");
	    	System.out.println("| Inventory Management System Login |");
	    	System.out.println("======================================");
	        System.out.println("Are you a (1) Manager or (2) Salesman?");
	        System.out.print("Enter your role: ");
	        int role = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (role) {
	            case 1:
	                managerOperations();
	                break;
	            case 2:
	                salesmanOperations();
	                break;
	            default:
	                System.out.println("Invalid role. Exiting...");
	                System.exit(0);
	        }
	    }
	    
	    

	    private static void createUser() {
	        System.out.print("Enter Username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter Password: ");
	        String password = scanner.nextLine();
	        System.out.println("Enter Role (1 for Manager, 2 for Salesman):");
	        int role = scanner.nextInt();
	        scanner.nextLine(); 
	      
	        userDAO.createUser(new Users(username, password, (role == 1 ? "Manager":"Salesman")));
	        
	        System.out.println("User created successfully.");
	        selectRole();
	    }



	    private static void loginUser() {
	        System.out.print("Enter Username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter Password: ");
	        String password = scanner.nextLine();
	        
	        
	        boolean isAuthenticated = false;
			try {
				isAuthenticated = userDAO.authenticateUser(username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        if (isAuthenticated) {
	            selectRole();
	        } else {
	            System.out.println("Authentication failed. Exiting...");
	            System.exit(0);
	        }
	    }
	    
	    private static void selectRole() {
	    	System.out.println("Welcome to the system select your role to proceed");
	        System.out.println("1. Manager");
	        System.out.println("2. Salesman");
	        System.out.print("Enter your role: ");
	        int role = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (role) {
	            case 1:
	                managerOperations();
	                break;
	            case 2:
	                salesmanOperations();
	                break;
	            default:
	                System.out.println("Invalid role. Exiting...");
	                System.exit(0);
	        }
	    }



		private static void managerOperations() {
	        while (true) {
	        	System.out.println("**************************************************");
	        	System.out.println("*          Welcome to the  Manager Portal     *");
	        	System.out.println("**************************************************");
	        	System.out.println("* 1. Add Product                     *");
	        	System.out.println("* 2. Remove Product                  *");
	        	System.out.println("* 3. Update Product Quantity         *");
	        	System.out.println("* 4. View Inventory                  *");
	        	System.out.println("* 5. Exit                            *");
	        	System.out.println("**************************************");
	        	System.out.print("* Enter your choice: ");
	        	//System.out.println("*********************************");


	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    addProduct();
	                    break;
	                case 2:
	                    removeProduct();
	                    break;
	                case 3:
	                    updateProductQuantity();
	                    break;
	                case 4:
	                    inventory.viewInventory();
	                    break;
	                   
	                case 5:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void salesmanOperations() {
	        while (true) {
	        	System.out.println("//////////////////////////////////////////");
	        	System.out.println("//    Welcome to the  Salesman Portal   //");
	        	System.out.println("//////////////////////////////////////////");
	        	System.out.println("// 1. View Inventory       //");
	        	System.out.println("// 2. Update Product       //");
	        	System.out.println("// 3. Sold Product       //");
	        	System.out.println("// 4. Exit .....           //");
	        	System.out.println("//////////////////////////////////////////");
	        	System.out.print("// Enter your choice: ");

	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    inventory.viewInventory();
	                    break;
	                case 2:
	                	updateProductQuantity();
	                    break;
	                case 3:
	                	removeProduct();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void addProduct() {
	        System.out.println("Adding a new product...");
	        System.out.print("Enter Product Name: ");
	        scanner.nextLine(); 
	        String name = scanner.nextLine();
	        System.out.print("Enter Quantity: ");
	        int quantity = Integer.parseInt(scanner.nextLine());
	        System.out.println("Enter price: ");
	        int price = Integer.parseInt(scanner.nextLine());
	        Product product = new Product(name, quantity,price);
	        productDAO.addProduct(product);
	        inventory.addProduct(product);
	        System.out.println("Product added successfully.");
	    }

	    private static void removeProduct() {
	        System.out.print("Enter Product Name to remove: ");
	        scanner.nextLine(); 
	        String name = scanner.nextLine();
	        Product p = inventory.getProductByName(name);
	        inventory.removeProduct(p.getName());
	        productDAO.deleteProduct(p.getId());
	        System.out.println("Product removed successfully.");
	    }

	    private static void updateProductQuantity() {
	        System.out.print("Enter Product Name to update quantity: ");
	        scanner.nextLine(); 
	        String name = scanner.nextLine();
	        System.out.print("Enter new quantity: ");
	        int quantity = scanner.nextInt();
	        
	        inventory.updateProductQuantity(name, quantity);
	        
	        Product product =  inventory.getProductByName(name);
	        //System.out.println(product);
	        product.setQuantity(quantity);
	        //new Product(name, quantity, price);
	        productDAO.updateProduct(product);
	        System.out.println("Product quantity updated successfully.");
	        
	    }

	    
	}