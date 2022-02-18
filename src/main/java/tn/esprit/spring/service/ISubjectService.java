package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Subject;

public interface ISubjectService {

	List<Subject> retrieveAll();
	Subject addSubject(Subject subject);
	void deleteSubject(Long id);
	Subject update(Subject subject);
	Subject retrieveSubject(Long id);
	List<Subject> retrieveSubjectByProduct(Long productId);
	void affectSubjectToClient(Long commentId, Long subjectId);
	double similarity(String s1, String s2);
	int getLevenshteinDistance(String s, String t);
	List<Subject> getSubjectBySimilarity(String description, Long prodId);
	List<Subject> getSubjectByClient(Long clientId);
}
