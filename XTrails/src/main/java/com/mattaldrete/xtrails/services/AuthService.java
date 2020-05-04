package com.mattaldrete.xtrails.services;

import com.mattaldrete.entities.User;

public interface AuthService {

	public User register(User user);
	
	public User getUserById(Integer id);
	
	public User getUserByUsername(String username);
	
}
