package com.mattaldrete.xtrails.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mattaldrete.entities.User;
import com.mattaldrete.xtrails.repositories.UserRepository;

public class AuthServiceIMPL implements AuthService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;

	@Override
	public User register(User user) {
		Optional<User> optionalUser = userRepo.findById(user.getId());
		String encodedPW = encoder.encode(user.getPassword());
		if (optionalUser.isPresent()) {
			throw new RuntimeException("Username alreadys exists");
		}
		user.setPassword(encodedPW);
		user.setEnabled(true);
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
		User user = userRepo.findByUserNameAndEnabledTrue(username);
		return user;
	}

}
