package com.firstproject.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }
    
    public Inventory(ArrayList<Product> products) {
    	this.products = products;
    }

    public void addProduct(Product product) {
      
        int index = findProductIndexById(product.getId());
        if (index != -1) {
            products.set(index, product); 
        } else {
            products.add(product); 
        }
    }

    public void removeProduct(int productId) {
        int index = findProductIndexById(productId);
        if (index != -1) {
            products.remove(index);
        }
    }

    public void removeProduct(String productName) {
        int index = findProductIndexById(productName);
        if (index != -1) {
            products.remove(index);
        }
    }
    public void updateProductQuantity(int productId, int soldQuantity) {
        int index = findProductIndexById(productId);
        if (index != -1) {
            Product product = products.get(index);
            int newQuantity = product.getQuantity() - soldQuantity;
            product.setQuantity(newQuantity);
        }
    } public void updateProductQuantity(String productName, int soldQuantity) {
        int index = findProductIndexById(productName);
        if (index != -1) {
            Product product = products.get(index);
            int newQuantity = product.getQuantity() - soldQuantity;
            product.setQuantity(newQuantity);
        }
    }

    public void viewInventory() {
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ",Price" + product.getprice());
        }
    }
    public Product getProductByName(String productName) {
    	return products.stream().filter((s) ->{ return s.getName().equalsIgnoreCase(productName);}).collect(Collectors.toList()).get(0);//search for it what is stream 
    }
    private int findProductIndexById(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(productName)) {
                return i;
            }
        }
        return 0;
    }
   
    private int findProductIndexById(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                return i; 
            }
        }
        return 0;
    }
 }
