package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.repository.Claim_Repository;


@Service
public class ClaimService implements IClaimService{


	@Autowired	
	Claim_Repository claimrepo; 
	
	
	
	@Override
	public Claim addClaim(Claim c) {
		
		return claimrepo.save(c);
	}

	@Override
	public List<Claim> getallClaims() {
		
		return (List<Claim>) claimrepo.findAll();
	}

	

	@Override
	public void deleteClaim(long id) {
		claimrepo.deleteClaim(id);
		
	}

	@Override
	public Claim updateClaim(Claim c) {
	
		return claimrepo.save(c);
	}

}
