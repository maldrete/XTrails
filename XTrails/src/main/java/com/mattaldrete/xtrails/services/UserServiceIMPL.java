package com.mattaldrete.xtrails.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mattaldrete.enitities.User;
import com.mattaldrete.xtrails.repositories.UserRepository;

public class UserServiceIMPL implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findById(Integer id) {
		User user = userRepo.findByIdAndEnabledTrue(id);
		return user;
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
