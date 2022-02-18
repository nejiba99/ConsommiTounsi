package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Subject;

public interface ICommentService {

	Comment addComment(Comment comment);
	void deleteComment(Long id);
	Comment update(Comment comment);
	List<Comment> retrieveCommentBySubject(Long subjectId);
	void affectCommentToSubject(Long commentId, Long subjectId);
}
