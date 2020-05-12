package com.mattaldrete.xtrails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.Comment;
import com.mattaldrete.xtrails.repositories.CommentRepository;
import com.mattaldrete.xtrails.services.CommentService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4289" })

public class CommentController {
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	CommentService commentSvc;

	@GetMapping("comment/{id}")
	public Comment getCommentById(@PathVariable Integer id) {
		return commentRepo.findById(id).get();
	}
	
	@PostMapping("comment")
	public Comment createComment(@RequestBody Comment comment) {
		return commentSvc.createComment(comment);
	}
	
	@PutMapping("comment")
	public Comment updateComment(@RequestBody Comment updatedComment) {
		return commentSvc.updateComment(updatedComment);
	}
	
	@DeleteMapping("comment/{id}")
	public Boolean deleteComment(@PathVariable Integer id) {
		return commentSvc.deleteComent(id);
	}
	
}
