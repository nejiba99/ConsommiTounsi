package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.SubjectRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Subject> retrieveAll() {
		// TODO Auto-generated method stub
		return (List<Subject>) subjectRepository.findAll();
	}

	@Override
	public Subject addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public void deleteSubject(Long id) {
		// TODO Auto-generated method stub
		subjectRepository.deleteById(id);
	}

	@Override
	public Subject update(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public Subject retrieveSubject(Long id) {
		// TODO Auto-generated method stub
		return subjectRepository.findById(id).get();
	}

	@Override
	public List<Subject> retrieveSubjectByProduct(Long prodId) {
		// TODO Auto-generated method stub
		Product p = productRepository.findById(prodId).get();
		return subjectRepository.findByProduct(p);
	}

	@Override
	public void affectSubjectToClient(Long clientId, Long subjectId) {
		// TODO Auto-generated method stub
		Client c= (Client) userRepository.findById(clientId).get();
		Subject sub= subjectRepository.findById(subjectId).get();
		sub.setClient(c);
		subjectRepository.save(sub);
	}

	@Override
	public double similarity(String s1, String s2) {
		String longer = s1.toLowerCase(), shorter = s2.toLowerCase();
		if (s1.length() < s2.length()) {
			longer = s2.toLowerCase();
			shorter = s1.toLowerCase();
		}
		int longerLength = longer.length();
		if (longerLength == 0) {
			return 1.0; /* both strings have zero length */
		}
		return (longerLength - getLevenshteinDistance(longer, shorter)) / (double) longerLength;
	}

	@Override
	public int getLevenshteinDistance(String s, String t) {
		if (s == null || t == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}

		int n = s.length(); // length of s
		int m = t.length(); // length of t

		if (n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}

		if (n > m) {
			// swap the input strings to consume less memory
			String tmp = s;
			s = t;
			t = tmp;
			n = m;
			m = t.length();
		}

		int p[] = new int[n + 1]; // 'previous' cost array, horizontally
		int d[] = new int[n + 1]; // cost array, horizontally
		int _d[]; // placeholder to assist in swapping p and d

		// indexes into strings s and t
		int i; // iterates through s
		int j; // iterates through t

		char t_j; // jth character of t

		int cost; // cost

		for (i = 0; i <= n; i++) {
			p[i] = i;
		}

		for (j = 1; j <= m; j++) {
			t_j = t.charAt(j - 1);
			d[0] = j;

			for (i = 1; i <= n; i++) {
				cost = s.charAt(i - 1) == t_j ? 0 : 1;
				// minimum of cell to the left+1, to the top+1, diagonally left
				// and up +cost
				d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
			}

			// copy current distance counts to 'previous row' distance counts
			_d = p;
			p = d;
			d = _d;
		}

		// our last action in the above loop was to switch d and p, so p now
		// actually has the most recent cost counts
		return p[n];
	}

	@Override
	public List<Subject> getSubjectBySimilarity(String desc,Long prodId) {
		// TODO Auto-generated method stub
		Product p=productRepository.findById(prodId).get();
		List<Subject> listPerProduct = subjectRepository.findByProduct(p);
		List<Subject> res = new ArrayList<>();
		double taux = 0;

		if (listPerProduct.size() != 0) {
			for (int i = 0; i < listPerProduct.size(); i++) {
				taux = similarity(listPerProduct.get(i).getDesc_subject(), desc);
				if (taux >= 0.600)
					res.add(listPerProduct.get(i));
			}
		}
		
		return res;
	}

	@Override
	public List<Subject> getSubjectByClient(Long clientId) {
		// TODO Auto-generated method stub
		Client client=(Client) userRepository.findById(clientId).get();
		return subjectRepository.findByClient(client);
	}

}
