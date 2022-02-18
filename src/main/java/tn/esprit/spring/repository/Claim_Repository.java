package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.*;

@Repository
public interface Claim_Repository extends CrudRepository<Claim,Long> {
	
	//Native query
	@Query(value="delete from claim where id_claim=:id",nativeQuery=true)
	void deleteClaim(@Param("id") long id );
	
}
