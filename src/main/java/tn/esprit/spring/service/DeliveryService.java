package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DeliveryMan;
import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.repository.Delivery_Repository;

@Service
public class DeliveryService implements IDeliveryService {
@Autowired
Delivery_Repository delivrepo;


@Override
public Delivery addDelivery(Delivery p) {
	return delivrepo.save(p);
	
}

@Override
public List<Delivery> getallDeliverys() {
	
	return (List<Delivery>)delivrepo.findAll();
}




@Override
public List<Delivery> getDeliveriesNotDeliveredSorted() {
	
	return (List<Delivery>) delivrepo.getDeliveriesNotDeliveredSorted();
}

@Override
public void deleteDelivery(int id) {
	delivrepo.deleteById(id);
	
}

@Override
public Delivery updateDelivery(Delivery p) {
	
	
	return delivrepo.save(p);
}

@Override
public List<Orders> getNotAffectedOrders() {
	
	return (List<Orders>) delivrepo.getNotAffectedOrders();
}




}
