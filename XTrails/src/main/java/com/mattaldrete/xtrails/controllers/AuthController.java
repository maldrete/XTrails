package com.mattaldrete.xtrails.controllers;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.User;
import com.mattaldrete.xtrails.repositories.UserRepository;
import com.mattaldrete.xtrails.services.AuthService;
import com.mattaldrete.xtrails.services.UserService;

@RestController
@CrossOrigin({ "*", "http://localhost:4289" })
public class AuthController {

	@Autowired
	AuthService authSvc;

	@Autowired
	UserRepository userRepo;

	@PostMapping("register")
	public User register(@RequestBody User user, HttpServletResponse res) {
		try {
			User optionalUser = userRepo.findByUsername(user.getUsername());
			if(optionalUser.getUsername().equals(user.getUsername())) {
				throw new RuntimeException("Username alreadys exists");
			}
		} 
		
		catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		
		User newUser = new User(user);
		
		
		newUser = authSvc.register(newUser);

		return newUser;
	}

	@GetMapping("/authenticate")
	public Boolean authenticate(Principal principal) {
		User user = authSvc.getUserByUsername(principal.getName());
		if (user == null) {
			return false;
		} else {
			return true;
		}

	}

}
