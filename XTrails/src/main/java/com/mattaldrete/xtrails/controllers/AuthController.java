package com.mattaldrete.xtrails.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.User;
import com.mattaldrete.entities.UserToRegister;
import com.mattaldrete.xtrails.services.AuthService;

@RestController
@CrossOrigin({ "*", "http://localhost:4289" })
public class AuthController {

	@Autowired
	AuthService authSvc;

	@PostMapping("/register")
	public User register(@RequestBody UserToRegister userToRegister, HttpServletResponse res) {

		if (userToRegister == null) {
			res.setStatus(400);
		}

		User newUser = new User(userToRegister);
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
