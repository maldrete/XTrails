package com.mattaldrete.xtrails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mattaldrete.entities.User;
import com.mattaldrete.xtrails.repositories.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User findById(Integer id) {
		User user = userRepo.findByIdAndEnabledTrue(id);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		System.err.println("in find by username");
		User user = userRepo.findByUsernameAndEnabledTrue(username);
		return user;
	}

	@Override
	public User updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean activateUser(Integer id) {
		User user = userRepo.findByIdAndEnabledTrue(id);
		user.setEnabled(true);
		userRepo.saveAndFlush(user);
		
		return true;
	}

}
