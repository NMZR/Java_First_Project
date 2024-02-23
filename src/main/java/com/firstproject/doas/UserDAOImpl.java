package com.firstproject.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.firstproject.entities.Users;
import com.firstproject.utilities.SQL_Connection;

public class UserDAOImpl implements UserDAO {
	private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, role) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?;";
	

	private Connection connection;
	
	
	//private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?;";


	


	@Override
	public boolean authenticateUser(String username, String password) {
	    boolean isAuthenticated = false;
	    
	    
	    try {
	    	connection = SQL_Connection.getConnection();
	        PreparedStatement stmt = connection.prepareStatement(SELECT_USER_BY_USERNAME);
	        stmt.setString(1, username);
	        
	        ResultSet resultSet = stmt.executeQuery();
	        
	        if (resultSet.next()) {
	            String storedPassword = resultSet.getString("password");
	            
	            
	            isAuthenticated = password.equals(storedPassword);
	        }
	        
	        resultSet.close();
	        stmt.close();
	        connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return isAuthenticated;
	}




	@Override
	public int createUser(Users user) {
		int returnValue = 0;
	    
	    
	    try {
	    	connection = SQL_Connection.getConnection();
	        PreparedStatement stmt = connection.prepareStatement(INSERT_USER_SQL);
	        stmt.setString(1, user.getUsername());
	        stmt.setString(2, user.getPassword()); 
	        stmt.setString(3, user.getRole());
	        returnValue = stmt.executeUpdate();
	        stmt.close();
	        connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return returnValue;
	}
}

	   




