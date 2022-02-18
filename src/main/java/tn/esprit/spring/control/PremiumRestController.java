package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Chart;
import tn.esprit.spring.entity.DeliveryMan;
import tn.esprit.spring.entity.Premium;
import tn.esprit.spring.service.IPremiumService;


@RestController
public class PremiumRestController {
  @Autowired
	private IPremiumService premiumservice;

	
	
	//http://localhost:8086/ConsomiTounsi/servlet/add-Premium
	@PostMapping("/add-Premium")
	  @ResponseBody
   public Premium addPremium (@RequestBody Premium p){
	   
	   premiumservice.addPremium(p);
	   return p;
   }
	
	//http://localhost:8086/ConsomiTounsi/servlet/getall-Premiums
	@GetMapping("/getall-Premiums")
	@ResponseBody
	public List<Premium> getallPremiums()
	{
		return premiumservice.getallPremiums();
	}
	
	//http://localhost:8086/ConsomiTounsi/servlet//delete-premium/2
	@DeleteMapping("/delete-premium/{id}")
	@ResponseBody
	public String deletePremium(@PathVariable ("id") int id) {
		premiumservice.deletePremium(id);
		return "deleted";
	}
	
	@PutMapping("/update-premium")
	@ResponseBody
	public Premium updatePremium(@RequestBody Premium p)
	{
		return premiumservice.updatePremium(p);
	}
	
	
	@GetMapping("/getallpremiumsbydeliveryMan")
	@ResponseBody
	public List<Premium> getallPremiumsByDelivery_man(@RequestBody DeliveryMan dmm)
	{
		return premiumservice.getallPremiumsByDelivery_man(dmm);
	}
	
	
	@GetMapping("/GetstatBymonth")
	@ResponseBody
	public ResponseEntity<?> GetstatBymonth()
	{
		Date today=new Date();
		int year=today.getYear()+1900;
		String[] dateLocal=today.toLocaleString().split(" ");
		String month=dateLocal[1];
		List<Chart> lista= premiumservice.statpremiumbymonth(month, year);
		return ResponseEntity.ok(lista);
		
	}
	
	
	@GetMapping("/GetstatByYear/{years}")
	@ResponseBody
	public ResponseEntity<?> GetstatByyear(@PathVariable(value="years", required=false) Optional<Integer> years)
	{
		int year;
		if(years!=null){
			year= years.get();
		}else{
		Date today=new Date();
		 year=today.getYear()+1900;
		}
		List<Chart> lista= premiumservice.statpremiumbyyear( year);
		return ResponseEntity.ok(lista);
		
	} 
	
}
	
