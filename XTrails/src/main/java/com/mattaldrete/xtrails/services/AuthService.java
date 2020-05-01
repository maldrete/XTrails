package com.mattaldrete.xtrails.services;

import com.mattaldrete.enitities.User;

public interface AuthService {

	public User register(User user);
	
	public User getUserById(Integer id);
}
