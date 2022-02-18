package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.LineManager;

@Repository
public interface LineManagerRepository extends CrudRepository<LineManager, Long> {

}
