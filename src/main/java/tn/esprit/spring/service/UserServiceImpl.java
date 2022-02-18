package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository usrepository ;
	
	
	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) usrepository.findAll();

	}
	

	
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return (usrepository.save(u));
	}

	
	public void deleteUser(Long id_user) {
		// TODO Auto-generated method stub
		usrepository.deleteById(id_user);
	}

	
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return (usrepository.save(u));
	}

	
	public User retrieveUser(String id_user) {
		// TODO Auto-generated method stub
		return (usrepository.findById(Long.parseLong(id_user)).orElse(null));
	}

}
