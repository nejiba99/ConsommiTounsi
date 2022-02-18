package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.*;
@Repository
public interface Delivery_Repository extends CrudRepository<Delivery,Integer> {
	//Native query
		@Query(value="select * from delivery d where d.status='Not Delivered' order by d.date",nativeQuery=true)
		List<Delivery> getDeliveriesNotDeliveredSorted();
	
	@Query(value="select o from Orders o where o not in (select orders from Delivery where orders=o ) order by date_order")
				List<Orders> getNotAffectedOrders();
		
}
