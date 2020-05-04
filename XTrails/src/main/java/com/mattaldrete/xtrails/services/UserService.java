package com.mattaldrete.xtrails.services;

import com.mattaldrete.entities.User;

public interface UserService {

	public User findById(Integer id);
	
	public boolean activateUser(Integer id);

	public User findByUsername(String username);

	public User updateUser(User updatedUser);

}
