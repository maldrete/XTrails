package com.mattaldrete.xtrails.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
