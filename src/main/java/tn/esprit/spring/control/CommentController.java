package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.service.ICommentService;

@RestController
public class CommentController {

	@Autowired
	ICommentService commentService;

	
		// http://localhost:8086/ConsomiTounsi/servlet/add-comment
		@PostMapping("/add-comment")
		@ResponseBody
		public Comment addComment(@RequestBody Comment comment) {
			Comment cm= commentService.addComment(comment);
			return cm;
		}

		// http://localhost:8086/ConsomiTounsi/servlet/remove-comment/{comment-id}
		@DeleteMapping("/remove-comment/{comment-id}")
		@ResponseBody
		public void removeComment(@PathVariable("comment-id") Long id) {
			commentService.deleteComment(id);
		}

		// http://localhost:8086/ConsomiTounsi/servlet/modify-comment
		@PutMapping("/modify-comment")
		@ResponseBody
		public Comment modifyComment(@RequestBody Comment comment) {
			return commentService.update(comment);
		}

		// http://localhost:8086/ConsomiTounsi/servlet/retrieve-comment-by-subject/{subject-id}
		@GetMapping("/retrieve-comment-by-subject/{subject-id}")
		@ResponseBody
		public List<Comment> retrieveCommentBySubject(@PathVariable("subject-id") Long id) {
			return commentService.retrieveCommentBySubject(id);
		}
		
		// http://localhost:8086/ConsomiTounsi/servlet/add-comment-to-subject/{cmt-id}/{sub-id}
		@PutMapping("/add-comment-to-subject/{cmt-id}/{sub-id}")
		@ResponseBody
		public void affectCommentToSubject(@PathVariable("cmt-id") Long cmtId, @PathVariable("sub-id") Long subId) {
			commentService.affectCommentToSubject(cmtId, subId);
		}

}
