package com.firstproject.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.firstproject.entities.Product;
import com.firstproject.utilities.SQL_Connection;

public class ProductDaoImpl implements ProductDao{
	private Connection connection;

	@Override
	public int addProduct(Product product) {
	    int returnValue = 0;
	    
	    try {
	    	connection = SQL_Connection.getConnection();
	        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Products (name, quantity, price) VALUES (?, ?, ?)");
	        stmt.setString(1, product.getName());
	        stmt.setInt(2, product.getQuantity());
	        stmt.setDouble(3, product.getprice());
	        returnValue = stmt.executeUpdate();
	        stmt.close();
	        connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return returnValue;
	}


	@Override
	public int updateProduct(Product product) {
	    int returnValue = 0;
	    
	    try {
	    	connection = SQL_Connection.getConnection();
	        
	        PreparedStatement stmt = connection.prepareStatement("UPDATE Products SET quantity = ? WHERE product_id = ?");

	        stmt.setInt(1, product.getQuantity());
	     
	        stmt.setInt(2, product.getId());
	        returnValue = stmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return returnValue;
	}


	@Override
	public int deleteProduct(int productId) {
	    int returnValue = 0;
	    
	    try {
	    	connection = SQL_Connection.getConnection();
	        PreparedStatement stmt = connection.prepareStatement("DELETE FROM Products WHERE product_id = ?");
	        stmt.setInt(1, productId);
	        returnValue = stmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return returnValue;
	}


	@Override
	public List<Product> getAllProducts() {
	    List<Product> products = new ArrayList<>();
	    
	    try {
	    	connection = SQL_Connection.getConnection();
	        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Products");
	        ResultSet rs = stmt.executeQuery();
	       
	        
	        while (rs.next()) {
	            Product product = new Product();
	            product.setId(rs.getInt("product_id"));
	            product.setName(rs.getString("name"));
	            product.setQuantity(rs.getInt("quantity"));
	            product.setPrice(rs.getInt("price"));
	            products.add(product);
	        }
	        rs.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return products;
	}


}
