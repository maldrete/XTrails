package com.mattaldrete.xtrails.services;

import com.mattaldrete.entities.Comment;

public interface CommentService {
	
	Comment createComment(Comment newComment);
	
	Comment updateComment(Comment updatedComment);
	
	Comment deleteComent(Integer id);

}
