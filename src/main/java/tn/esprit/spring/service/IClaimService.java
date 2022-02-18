package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.DeliveryMan;
import tn.esprit.spring.entity.Premium;
import tn.esprit.spring.repository.Premium_Repository;

public interface IClaimService {
  
	

	Claim addClaim(Claim c);
	List<Claim> getallClaims();
	void deleteClaim (long id);
	Claim updateClaim (Claim c);
}
