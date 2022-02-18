package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.*;

@Service
public class PremiumService implements IPremiumService {
@Autowired
	private Premium_Repository prmrepo;

	@Override
	public Premium_Repository getpremiumrepo() {
		
		return prmrepo;
	}

	@Override
	public void setpremiumrepo(Premium_Repository prm) {
		this.prmrepo=prm;	
	}

	@Override
	public Premium addPremium(Premium p) {
		return prmrepo.save(p);
		
	}

	@Override
	public List<Premium> getallPremiums() {
		
		return (List<Premium>)prmrepo.findAll();
	}
	
	
	

	@Override
	public List<Premium> getallPremiumsByDelivery_man(DeliveryMan dmm) {
		
		return (List<Premium>) prmrepo.GetPremiumsByDelivery_man(dmm);
	}

	@Override
	public void deletePremium(int id) {
		prmrepo.deleteById(id);
		
	}

	@Override
	public Premium updatePremium(Premium p) {	
		
		return prmrepo.save(p);
		
	}
	
	@Override
	public List<Chart>statpremiumbymonth(String month, int year){
		return prmrepo.statpremiumbymonth(month, year);
	}

	@Override
	public List<Chart> statpremiumbyyear(int year) {
		return prmrepo.statpremiumbyyear(year);
	}
	
	
	
}
