package com.mattaldrete.xtrails.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattaldrete.entities.Comment;
import com.mattaldrete.xtrails.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepo;

	@Override
	public Comment createComment(Comment newComment) {
		LocalDate dateCreated = LocalDate.now();
		newComment.setDatePosted(dateCreated);
		Comment commentCreated = commentRepo.saveAndFlush(newComment);
		return commentCreated;
	}

	@Override
	public Comment updateComment(Comment updatedComment) {
		Comment managedComment = commentRepo.findById(updatedComment.getId()).get();
		
		if (updatedComment.getActualComment() != null) {
			managedComment.setActualComment(updatedComment.getActualComment());
		}
		return managedComment;
	}

	@Override
	public Boolean deleteComent(Integer id) {
		Boolean deleted = false;
		try {
			Optional<Comment> managedComment = commentRepo.findById(id);
			if (managedComment.isPresent()) {
				commentRepo.delete(managedComment.get());
				deleted = true;
			}
		} catch (NullPointerException e) {
			System.err.println("Comment does not exist");
		}
		return deleted;
	}

}
