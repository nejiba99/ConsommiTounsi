package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.DeliveryMan;
import tn.esprit.spring.repository.DeliveryManRepository;

@Service
public class DeliveryManServiceImpl  {

	@Autowired
	DeliveryManRepository dmrepository ;
	
	
	public List<DeliveryMan> retrieveAllDeliveryMans() {
		// TODO Auto-generated method stub
		return (List<DeliveryMan>) dmrepository.findAll();
	}

	
	public DeliveryMan addDeliveryMan(DeliveryMan d) {
		// TODO Auto-generated method stub
		return dmrepository.save(d);
	}

	
	public void deleteDeliveryMan(Long id_delivery_man) {
		// TODO Auto-generated method stub
		dmrepository.deleteById((long) id_delivery_man);
	}

	
	public DeliveryMan updateDeliveryMan(DeliveryMan d) {
		// TODO Auto-generated method stub
		return dmrepository.save(d);
	}

	
	public DeliveryMan retrieveDeliveryMan(String id_delivery_man) {
		// TODO Auto-generated method stub
		return dmrepository.findById(Long.parseLong(id_delivery_man)).orElse(null);
	}

}
