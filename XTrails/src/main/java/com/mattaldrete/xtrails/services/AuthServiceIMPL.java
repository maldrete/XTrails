package com.mattaldrete.xtrails.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mattaldrete.entities.User;
import com.mattaldrete.xtrails.repositories.UserRepository;

@Service
public class AuthServiceIMPL implements AuthService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;

	@Override
	public User register(User user) {
//		Optional<User> optionalUser = userRepo.findById(user.getId());
//		if (optionalUser.isPresent()) {
//			throw new RuntimeException("Username alreadys exists");
//		}
		String encodedPW = encoder.encode(user.getPassword());
		user.setPassword(encodedPW);
		
		user.setEnabled(true);
		user.setRole("standard");
		user.setFavoriteActivities("");
		System.err.println("In rencodedpw" + encodedPW);
		
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User getUserById(Integer id) {
		User user = userRepo.findById(id).get();
		return user;

	}

	@Override
	public User getUserByUsername(String username) {
		User user = userRepo.findByUsernameAndEnabledTrue(username);
		return user;
	}

}
