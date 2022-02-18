package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Basket;



@Repository
public interface BasketRepository extends CrudRepository<Basket, Long>{

}
