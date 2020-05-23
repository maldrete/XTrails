package com.mattaldrete.xtrails.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.User;
import com.mattaldrete.xtrails.services.UserService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4289" })

public class UserController {

	@Autowired
	UserService userSvc;

	@GetMapping("me")
	public User getUser(Principal principle) {
		System.err.println("in get user method");
		User user = userSvc.findByUsername(principle.getName());

		System.err.println(user.toString());
		return user;
	}

	@PutMapping("me")
	public User updateUser(@RequestBody User user, Principal principal) {
		user.setUsername(principal.getName());
		user = userSvc.updateUser(user);
		return user;
	}

//	@GetMapping("users")
//	public List<User> getAllUsers() {
//		return userSvc.getAllUsers();
//	}

	@DeleteMapping("users/{username}")
	public User deactivateUser(@PathVariable String username, Principal principal) {
		Boolean deactivated = false;
		User user = userSvc.findByUsername(username);
		if (userSvc.findByUsername(principal.getName()).getRole().equals("admin")) {
			deactivated = userSvc.deactivateUser(username);

		}
		return user;
	}

	@PutMapping("users/{username}")
	public User activateUser(@PathVariable String username, Principal princpal) {
		Boolean activated = false;
		User user = userSvc.findByUsername(username);
		if (userSvc.findByUsername(princpal.getName()).getRole().equals("admin")) {
			activated = userSvc.activateUser(username);
		}
		return user;
	}
	
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userSvc.getAllUsers();
	}
	

}
