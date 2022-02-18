package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.BasketRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.OrdersRepository;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class OrdersServiceImpl implements IOrdersService{

	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	BasketRepository basketrepository;
	
	@Autowired
	ClientRepository clientrepository;
	
	@Override
	public List<Orders> retrieveAll() {
		return (List<Orders>)ordersRepository.findAll();
	}

	@Override
	public Orders retrieveorders(String ordersId) {
		return ordersRepository.findById(Long.parseLong(ordersId)).orElse(null);	}

	@Override
	public void removeorders(String ordersId) {
		ordersRepository.deleteById(Long.parseLong(ordersId));
	}

	@Override
	public Orders updateorders(Orders ordersId) {
		ordersId.setFees_order(ordersId.getProduct().getPrice_prod()*ordersId.getQuantity());

		return ordersRepository.save(ordersId);
	}

	@Override
	public Orders addorders(Orders o) {
		//fees_order=quantity*price_product
		o.setFees_order(o.getProduct().getPrice_prod()*o.getQuantity());
		return ordersRepository.save(o);
		
	}

	@Override
	public void affecterOrdertoBasket(int orderId, int basketId) {
		Basket b = basketrepository.findById((long) basketId).orElse(null);
		Orders o = ordersRepository.findById((long) orderId).orElse(null);
		b.getOrders().add(o);
		
		//grant total va etre incrementé dans le basket
		b.setTotal(b.getTotal()+o.getFees_order());
		basketrepository.save(b);
		o.setBasket(b);
		ordersRepository.save(o);
		
	}

	@Override
	public List<Orders> findAll() {

		List<Orders> orders = (List<Orders>) ordersRepository.findAll();

		return orders;
	}
	
	@Override
	public List<Orders> GetOrderrsByProduct(Product product) {
		// TODO Auto-generated method stub
		return ordersRepository.GetOrderrsByProduct(product);
	}
}
