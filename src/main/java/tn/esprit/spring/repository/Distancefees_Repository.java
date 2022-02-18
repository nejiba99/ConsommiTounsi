package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.*;
@Repository
public interface Distancefees_Repository extends CrudRepository<Distance_fees,Integer>  {

}
