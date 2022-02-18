package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.Product;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{

	@Query("SELECT o FROM Orders o WHERE o.product= :product")
	List<Orders> GetOrderrsByProduct(@Param("product") Product product);
}
