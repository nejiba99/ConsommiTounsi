package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.service.IClaimService;



@RestController
public class ClaimRestContoller {

	
	  @Autowired
	  IClaimService claimservice;
	   
	   
	 //http://localhost:8086/ConsomiTounsi/servlet/add-Claim
	 	@PostMapping("/add-Claim")
	 	  @ResponseBody
	    public Claim addClaim (@RequestBody Claim c){
	 	   
	 	   claimservice.addClaim(c);
	 	   return c;
	    }
	 	
	 	//http://localhost:8086/ConsomiTounsi/servlet/getall-Claims
	 	@GetMapping("/getall-Claims")
		  @ResponseBody
	 	public List<Claim> getallClaims(){
	 		return claimservice.getallClaims();
	 	}
	 	
	 	//http://localhost:8086/ConsomiTounsi/servlet/update-Claim
	 	@PutMapping("/update-Claim")
		@ResponseBody
	 	public Claim updateDeliveryMan(@RequestBody Claim c){
	 		return claimservice.updateClaim(c);
	 	}
	   
	 	//http://localhost:8086/ConsomiTounsi/servlet//delete-Claim/{id}
	 		@DeleteMapping("/delete-Claim/{id}")
	 		@ResponseBody
	 		public String deleteClaim (@PathVariable ("id") long id) {
	 			claimservice.deleteClaim(id);
	 			return "deleted";
	 		}
	 	
	 	
	   
}
