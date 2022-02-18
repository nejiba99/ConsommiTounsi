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
import tn.esprit.spring.entity.LineManager;
import tn.esprit.spring.service.LineManagerServiceImpl;

@RestController
public class LineManagerRestController {

	@Autowired
	LineManagerServiceImpl lmservice ;
	
	//http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-linemanagers
	@GetMapping("/retrieve-all-linemanagers")
	@ResponseBody
	public List<LineManager> getDeliveryMans() {
		List<LineManager> list = lmservice.retrieveAllLineManagers();
		return list;
	}
	
	
	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-linemanager/{linemanager-id}
				@GetMapping("/retrieve-user/{linemanager-id}")
				@ResponseBody
				public LineManager retrieveLineManager(@PathVariable("linemanager-id") String id_line_manager) {
					return lmservice.retrieveLineManager(id_line_manager);
					
				}
	
	
				// Ajouter  : http://localhost:8086/ConsomiTounsi/servlet/add-linemanager
				@PostMapping("/add-linemanager")
				@ResponseBody
				public LineManager addLineManager(@RequestBody LineManager linemanager) {
					LineManager lm1 = lmservice.addLineManager(linemanager);
					return lm1;
				}
				
				// http://localhost:8086/ConsomiTounsi/servlet/remove-linemanager/{linemanager-id}
				@DeleteMapping("/remove-linemanager/{linemanager-id}")
				@ResponseBody
				public void removeLineManager (@PathVariable("linemanager-id") Long id_line_manager) {
					lmservice.deleteLineManager(id_line_manager);
				}
				
				// http://localhost:8086/ConsomiTounsi/servlet/modify-linemanager
				@PutMapping("/modify-linemanager")
				@ResponseBody
				public LineManager modifyLineManager(@RequestBody LineManager linemanager) {
					return lmservice.updateLineManager(linemanager);
				}
}
