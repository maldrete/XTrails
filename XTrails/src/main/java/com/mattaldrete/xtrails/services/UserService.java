package com.mattaldrete.xtrails.services;

import java.util.List;

import com.mattaldrete.entities.User;

public interface UserService {

	public User findById(Integer id);
	
	public Boolean activateUser(String username);

	public User findByUsername(String username);

	public User updateUser(User updatedUser);
	
	public Boolean deactivateUser(String username);
	
	// Actually deletes
	public boolean deleteUser(String username);
	
	public List<User> getAllUsers();

}
