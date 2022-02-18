package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Subject;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	public List<Comment> findBySubject(Subject subject);

}
