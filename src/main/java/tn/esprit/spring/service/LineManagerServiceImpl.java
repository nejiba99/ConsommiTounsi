package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.LineManager;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.LineManagerRepository;


@Service
public class LineManagerServiceImpl  {

	@Autowired
	LineManagerRepository lmrepository ;
	
	
	public List<LineManager> retrieveAllLineManagers() {
		// TODO Auto-generated method stub
		return (List<LineManager>) lmrepository.findAll();
	}

	
	public LineManager addLineManager(LineManager lm) {
		// TODO Auto-generated method stub
		return (lmrepository.save(lm));
	}

	
	public void deleteLineManager(Long id_line_manager) {
		// TODO Auto-generated method stub
		lmrepository.deleteById(id_line_manager);
	}

	
	public LineManager updateLineManager(LineManager linemanager) {
		// TODO Auto-generated method stub
		return (lmrepository.save(linemanager));
	}

	
	public LineManager retrieveLineManager(String id_line_manager) {
		// TODO Auto-generated method stub
		return (lmrepository.findById(Long.parseLong(id_line_manager)).orElse(null));
	}

}
