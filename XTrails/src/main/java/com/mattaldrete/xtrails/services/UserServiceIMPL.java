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
		User oldUser = userRepo.findByUsername(updatedUser.getUsername());
		System.out.println(updatedUser);

		if (updatedUser.getEmail() != null) {
			oldUser.setEmail(updatedUser.getEmail());
		}

		if (updatedUser.getPassword() != null) {
			System.out.println("hello im in password");
			String encodedPW = encoder.encode(updatedUser.getPassword());
			oldUser.setPassword(encodedPW); // only persist encoded password

		}
		userRepo.saveAndFlush(oldUser);
		return oldUser;
	}

	@Override
	public boolean activateUser(Integer id) {
		User user = userRepo.findByIdAndEnabledTrue(id);
		user.setEnabled(true);
		userRepo.saveAndFlush(user);

		return true;
	}

	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
