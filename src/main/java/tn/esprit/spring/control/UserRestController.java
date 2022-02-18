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
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
public class UserRestController {
	
@Autowired
UserServiceImpl usservice ;
	



//http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-users
			@GetMapping("/retrieve-all-users")
			@ResponseBody
			public List<User> getPublicitys() {
				List<User> list = usservice.retrieveAllUsers();
				return list;
			}
				
			// http://localhost:8086/ConsomiTounsi/servlet/retrieve-user/{user-id}
						@GetMapping("/retrieve-user/{user-id}")
						@ResponseBody
						public User retrieveUser(@PathVariable("user-id") String id_user) {
							return usservice.retrieveUser(id_user);
						}		
				
						// Ajouter  : http://localhost:8086/ConsomiTounsi/servlet/add-user
						@PostMapping("/add-user")
						@ResponseBody
						public User addUser(@RequestBody User user) {
							User u1 = usservice.addUser(user);
							return u1;
						}
						
						
				
						// http://localhost:8086/ConsomiTounsi/servlet/remove-user/{user-id}
						@DeleteMapping("/remove-user/{user-id}")
						@ResponseBody
						public void removeUser (@PathVariable("user-id") Long id_user) {
							usservice.deleteUser(id_user);
						}
					
						// http://localhost:8086/ConsomiTounsi/servlet/modify-user
						@PutMapping("/modify-user")
						@ResponseBody
						public User modifyUser(@RequestBody User user) {
							return usservice.updateUser(user);
						}
	
}
