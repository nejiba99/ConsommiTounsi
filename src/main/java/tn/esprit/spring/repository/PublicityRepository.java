package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Publicity;

@Repository
public interface PublicityRepository extends CrudRepository<Publicity, Long>{

	@Query("SELECT p FROM Publicity p WHERE p.product= :product")
	List<Publicity> SearchPublicityByProduct(@Param("product") Product product);
	
	@Query("SELECT p FROM Publicity p WHERE p.name_pub= :name_pub")
	List<Publicity> SearchPublicityByName(@Param("name_pub") String name_pub);
}
