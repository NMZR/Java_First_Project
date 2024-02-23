package com.firstproject.entities;

import java.util.ArrayList;
import java.util.List;

public class SalesRecord {
    //private List<String> sales;
    private Salesmen salesmen;
    private Product product;
    private int quantity_sold;
    
    public SalesRecord( Salesmen salesmen, Product product, int quantity_sold) {
    	this.salesmen = salesmen;
    	this.product = product;
    	this.quantity_sold = quantity_sold;
    }
    public SalesRecord() {
     //   this.sales = new ArrayList<>();
    }

   // public void addSale(int productId, String salesmanName, String customerName, int quantity) {
    	
     //   String saleDetails = "Product ID: " + productId + ", Salesman: " + salesmanName + ", Customer: " + customerName + ", Quantity: " + quantity;
     //   sales.add(saleDetails);
   // }
    public String toString() {
    	return "prodiuct: " + product.getName() + " price: " + product.getprice() + " quantity: " + quantity_sold + " sold  by: " + salesmen.toString();
    }
    
   }


