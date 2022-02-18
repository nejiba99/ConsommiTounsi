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

import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.service.DeliveryService;

@RestController
public class DeliveryRestController {
@Autowired
DeliveryService deliveryservice;


//http://localhost:8086/ConsomiTounsi/servlet/add-Delivery
	@PostMapping("/add-Delivery")
	  @ResponseBody
 public Delivery addDelivery (@RequestBody Delivery p){
	   
		deliveryservice.addDelivery(p);
	   return p;
 }
	
	//http://localhost:8086/ConsomiTounsi/servlet/getall-Deliverys
	@GetMapping("/getall-Deliverys")
	@ResponseBody
	public List<Delivery> getallDeliverys()
	{
		return deliveryservice.getallDeliverys();
	}
	
	//http://localhost:8086/ConsomiTounsi/servlet//delete-Delivery/2
	@DeleteMapping("/delete-Delivery/{id}")
	@ResponseBody
	public String deleteDelivery(@PathVariable ("id") int id) {
		deliveryservice.deleteDelivery(id);
		return "deleted";
	}
	
	@PutMapping("/update-Delivery")
	@ResponseBody
	public Delivery updateDelivery(@RequestBody Delivery p)
	{
		return deliveryservice.updateDelivery(p);
	}
	
	//http://localhost:8086/ConsomiTounsi/servlet/getDeliveriesNotDeliveredSorted
		@GetMapping("/getDeliveriesNotDeliveredSorted")
		@ResponseBody
		public List<Delivery> getDeliveriesNotDeliveredSorted()
		{
			return deliveryservice.getDeliveriesNotDeliveredSorted();
		}
		
		//http://localhost:8086/ConsomiTounsi/servlet/getNotAffectedOrders
				@GetMapping("/getNotAffectedOrders")
				@ResponseBody
				public List<Orders> getNotAffectedOrders()
				{
					return deliveryservice.getNotAffectedOrders();
				}
	
}
