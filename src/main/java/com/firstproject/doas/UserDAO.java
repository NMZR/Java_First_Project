package com.firstproject.doas;

import com.firstproject.entities.Users;

public interface UserDAO {
	
	    boolean authenticateUser(String username, String password);
	    
	    int createUser(Users user);
	}



