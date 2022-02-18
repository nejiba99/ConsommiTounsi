package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Basket;

public interface IBasketService {
	List<Basket> retrieveAll();

	Basket retrieveBasket(String BasketId);

	void removeBasket(String BasketId);

	Basket updateBasket(Basket BasketId);

	Basket addBasket(Basket b);
	void ValidateBasket(int basketId, int clientId ,String tp );
	void Reduction(int basketId);

}
