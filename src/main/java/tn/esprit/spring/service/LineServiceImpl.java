package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Line;
import tn.esprit.spring.repository.LineRepository;

@Service
public class LineServiceImpl {

	@Autowired
	LineRepository lnrepository ;
	
	
	public List<Line> retrieveAllLines() {
		// TODO Auto-generated method stub
		return (List<Line>) lnrepository.findAll();
	}

	
	public Line addLine(Line l) {
		// TODO Auto-generated method stub
		return (lnrepository.save(l));
	}

	
	public void deleteLine(Long id_line) {
		// TODO Auto-generated method stub
		lnrepository.deleteById(id_line);
	}

	
	public Line updateLine(Line l) {
		// TODO Auto-generated method stub
		return (lnrepository.save(l));
	}

	
	public Line retrieveLine(String id_line) {
		// TODO Auto-generated method stub
		return (lnrepository.findById(Long.parseLong(id_line)).orElse(null));
	}

}
