package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.Product;

public interface IOrdersService {

	List<Orders> GetOrderrsByProduct( Product product);
	List<Orders> retrieveAll();

	Orders retrieveorders(String ordersId);

	void removeorders(String ordersId);

	Orders updateorders(Orders ordersId);

	Orders addorders(Orders o);

	void affecterOrdertoBasket(int orderId, int basketId);

	List<Orders> findAll();
}
