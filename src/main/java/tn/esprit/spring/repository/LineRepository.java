package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Line;

@Repository
public interface LineRepository extends CrudRepository<Line, Long> {

}
