package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.util.Pair;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.*;



public interface IDeliveryManService  {

	
	
	DeliveryMan addDeliveryMan(DeliveryMan dlm);
	List<DeliveryMan> getallDeliveryMan();
	DeliveryMan getDelivery_manById(long id);
	
	void deleteDeliveryMan(long id);
	DeliveryMan updateDeliveryMan(DeliveryMan dlm);
	Pair<String,String> getTimeDeliveryMan(long id);
	
}
