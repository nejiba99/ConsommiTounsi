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

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ISubjectService;

@RestController
public class SubjectController {

	@Autowired
	ISubjectService subjectService;

	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-subjects
	@GetMapping("/retrieve-all-subjects")
	@ResponseBody
	public List<Subject> getSubjects() {
		List<Subject> list = subjectService.retrieveAll();
		return list;
	}

	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-subject/{subject-id}
	@GetMapping("/retrieve-subject/{subject-id}")
	@ResponseBody
	public Subject retrieveSubject(@PathVariable("subject-id") Long id) {
		return subjectService.retrieveSubject(id);
	}

	// http://localhost:8086/ConsomiTounsi/servlet/add-subject
	@PostMapping("/add-subject")
	@ResponseBody
	public Subject addSubject(@RequestBody Subject subject) {
		return subjectService.addSubject(subject);

	}

	// http://localhost:8086/ConsomiTounsi/servlet/add-client-to-subject/{client-id}/{sub-id}
	@PutMapping("/add-client-to-subject/{client-id}/{sub-id}")
	@ResponseBody
	public void affectClientToSubject(@PathVariable("client-id") Long clientId, @PathVariable("sub-id") Long subId) {
		subjectService.affectSubjectToClient(clientId, subId);
	}

	// http://localhost:8086/ConsomiTounsi/servlet/remove-subject/{subject-id}
	@DeleteMapping("/remove-subject/{subject-id}")
	@ResponseBody
	public void removeSubject(@PathVariable("subject-id") Long id) {
		subjectService.deleteSubject(id);
	}

	// http://localhost:8086/ConsomiTounsi/servlet/modify-subject
	@PutMapping("/modify-subject")
	@ResponseBody
	public Subject modifySubject(@RequestBody Subject subject) {
		return subjectService.update(subject);
	}


	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-subject-by-product/{product-id}
	@GetMapping("/retrieve-subject-by-product/{product-id}")
	@ResponseBody
	public List<Subject> retrieveSubjectByProduct(@PathVariable("product-id") Long id) {
		return subjectService.retrieveSubjectByProduct(id);
	}

	// http://localhost:8086/ConsomiTounsi/servlet/subject-by-similarity/{desc}/{product-id}
	@GetMapping("/subject-by-similarity/{desc}/{product-id}")
	@ResponseBody
	public List<Subject> getSubjectBySimilarity(@PathVariable("desc") String desc,@PathVariable("product-id") Long prodId) {
		return subjectService.getSubjectBySimilarity(desc,prodId);

	}
	
	// http://localhost:8086/ConsomiTounsi/servlet/subject-by-client/{client-id}
		@GetMapping("/subject-by-client/{client-id}")
		@ResponseBody
		public List<Subject> getSubjectByClient(@PathVariable("client-id") Long clientId) {
			return subjectService.getSubjectByClient(clientId);

		}
}
