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
import tn.esprit.spring.entity.DeliveryMan;
import tn.esprit.spring.service.DeliveryManServiceImpl;

@RestController
public class DeliveryManRestController {

	@Autowired
	DeliveryManServiceImpl dmservice ;
	
	//http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-deliverymans
			@GetMapping("/retrieve-all-deliverymans")
			@ResponseBody
			public List<DeliveryMan> getDeliveryMans() {
				List<DeliveryMan> list = dmservice.retrieveAllDeliveryMans();
				return list;
			}
			
			// http://localhost:8086/ConsomiTounsi/servlet/retrieve-deliveryman/{deliveryman-id}
			@GetMapping("/retrieve-user/{deliveryman-id}")
			@ResponseBody
			public DeliveryMan retrieveDeliveryMan(@PathVariable("deliveryman-id") String id_delivery_man) {
				return dmservice.retrieveDeliveryMan(id_delivery_man);
				
			}
			// Ajouter  : http://localhost:8086/ConsomiTounsi/servlet/add-deliveryman
			@PostMapping("/add-deliveryman")
			@ResponseBody
			public DeliveryMan addDeliveryMan(@RequestBody DeliveryMan deliveryman) {
				DeliveryMan dm1 = dmservice.addDeliveryMan(deliveryman);
				return dm1;
			}
			
			// http://localhost:8086/ConsomiTounsi/servlet/remove-deliveryman/{deliveryman-id}
			@DeleteMapping("/remove-deliveryman/{deliveryman-id}")
			@ResponseBody
			public void removeDeliveryMan (@PathVariable("deliveryman-id") Long id_delivery_man) {
				dmservice.deleteDeliveryMan(id_delivery_man);
			}
			
			// http://localhost:8086/ConsomiTounsi/servlet/modify-deliveryman
			@PutMapping("/modify-deliveryman")
			@ResponseBody
			public DeliveryMan modifyDeliveryMan(@RequestBody DeliveryMan deliveryman) {
				return dmservice.updateDeliveryMan(deliveryman);
			}
}
