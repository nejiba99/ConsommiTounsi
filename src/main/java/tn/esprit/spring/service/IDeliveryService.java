package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.entity.Orders;

public interface IDeliveryService {
	Delivery addDelivery(Delivery d);
	List<Delivery> getallDeliverys();
	List<Delivery> getDeliveriesNotDeliveredSorted();
	
	void deleteDelivery(int id);
	Delivery updateDelivery(Delivery d);
	
	
	List<Orders> getNotAffectedOrders();
}
