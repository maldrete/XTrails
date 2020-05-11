package com.mattaldrete.xtrails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.Comment;
import com.mattaldrete.xtrails.repositories.CommentRepository;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4289" })

public class CommentController {
	
	@Autowired
	CommentRepository commentRepo;

	@GetMapping("comment/{id}")
	public Comment getCommentById(@PathVariable Integer id) {
		return commentRepo.findById(id).get();
	}
}
