package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.*;

@Repository
public interface Weightfees_Repository extends CrudRepository<Weight_fees,Integer> {

}
