package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.*;


public interface IPremiumService {
 
	Premium_Repository getpremiumrepo();
	void setpremiumrepo(Premium_Repository  prm);
	Premium addPremium(Premium p);
	List<Premium> getallPremiums();
	List<Premium> getallPremiumsByDelivery_man(DeliveryMan dmm);
	
	void deletePremium(int id);
	Premium updatePremium(Premium p);
	List<Chart>statpremiumbymonth(String month, int year);
	List<Chart>statpremiumbyyear( int year);
	
	
	 
}
