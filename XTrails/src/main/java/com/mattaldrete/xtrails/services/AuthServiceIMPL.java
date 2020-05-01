package com.mattaldrete.xtrails.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mattaldrete.enitities.User;
import com.mattaldrete.xtrails.repositories.UserRepository;

public class AuthServiceIMPL implements AuthService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User register(User user) {
		Optional<User> optionalUser =userRepo.findById(user.getId());
//		String encodedPW = encoder.encode(user)
//		todo: add password to user field database
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
