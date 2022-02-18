package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.SubjectRepository;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public Comment addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

	@Override
	public void deleteComment(Long id) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(id);
	}

	@Override
	public Comment update(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}


	@Override
	public List<Comment> retrieveCommentBySubject(Long subjectId) {
		// TODO Auto-generated method stub
		Subject sub= subjectRepository.findById(subjectId).get();
		return commentRepository.findBySubject(sub);
	}

	@Override
	public void affectCommentToSubject(Long commentId, Long subjectId) {
		// TODO Auto-generated method stub
		Subject sb = subjectRepository.findById(subjectId).get();
		Comment cmnt = commentRepository.findById(commentId).get();
		cmnt.setSubject(sb);
		commentRepository.save(cmnt);
		
	}

	
}
