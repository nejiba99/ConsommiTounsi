package tn.esprit.spring.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.entity.Paiement;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.repository.BasketRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.OrdersRepository;


@Service
public class BasketServiceImpl implements IBasketService{
	@Autowired
	BasketRepository basketRepository;
	@Autowired
	OrdersRepository orderRepository;
	@Autowired
	ClientRepository clientRepository;
	@Override
	public List<Basket> retrieveAll() {
		// TODO Auto-generated method stub
		return (List<Basket>)basketRepository.findAll();
	}

	@Override
	public Basket retrieveBasket(String BasketId) {
		// TODO Auto-generated method stub
		return basketRepository.findById(Long.parseLong(BasketId)).orElse(null);	}

	@Override
	public void removeBasket(String BasketId) {
		// TODO Auto-generated method stub
		basketRepository.deleteById(Long.parseLong(BasketId));
	}

	@Override
	public Basket updateBasket(Basket Basket) {
		// TODO Auto-generated method stub
		return basketRepository.save(Basket);
	}

	@Override
	public Basket addBasket(Basket b) {
		b.setDate_basket(new Date());
		return basketRepository.save(b);
	}

	@Override
	public void ValidateBasket(int basketId, int clientId,String tp ) {
		Basket b = basketRepository.findById((long) basketId).orElse(null);
		Client c = clientRepository.findById((long) clientId).orElse(null);
		b.setClient(c);
		List  ods=new ArrayList<>(b.getOrders());
		for(int i=0;i<ods.size();i++){
			Orders o=(Orders) ods.get(i);
			o.setStatus_order("in Delivering");
			
		}
		 if(tp.toUpperCase().equals(Paiement.ATTHEDELIVERY) ){
			  b.setType_paiement(Paiement.ATTHEDELIVERY);
		   }
		 else {
			  b.setType_paiement(Paiement.BYCARD);

		 }
		
		basketRepository.save(b);
		
	 /*  c.setBasket(b);
	   basketRepository.save(b);
	   if(b.getType_paiement() == Paiement.ATTHEDELIVERY && b.getType_paiement() == Paiement.BYCARD){
		   o.setStatus_order("in delivering");         
	   }
	   else{
		   o.setStatus_order("payment type required");

	   }
	   orderRepository.save(o);*/
	}

	@Override
	public void Reduction(int basketId) {
		
		Basket b = basketRepository.findById((long) basketId).orElse(null);
		if(b.getTotal()>99){
			b.setTotal(b.getTotal()-(b.getTotal()*0.05f));

		}
		else if(b.getTotal()>130){
			b.setTotal(b.getTotal()-(b.getTotal()*0.1f));

		}
		else if(b.getTotal()>200){
			b.setTotal(b.getTotal()-(b.getTotal()*0.2f));
			  

		}
		else if(b.getTotal()>299){
			b.setTotal(b.getTotal()-(b.getTotal()*0.4f));

		}
		else {
			b.setTotal(b.getTotal()-(b.getTotal()*0.5f));

		}
		  basketRepository.save(b);
	}
	
	
}
