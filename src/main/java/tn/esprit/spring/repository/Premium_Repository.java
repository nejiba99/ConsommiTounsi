package tn.esprit.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.*;
@Repository
public interface Premium_Repository extends CrudRepository<Premium,Integer>{
	
	//JPQL
	@Query("Select p from Premium p where deliveryman=:d")
	List<Premium>GetPremiumsByDelivery_man(@Param("d") DeliveryMan dm );
	
	@Query("Select new tn.esprit.spring.entity.Chart( p.deliveryman as deliveryman,sum(p.premium) as sumPremium,count(p) as countPremium) from Premium p where p.month=:m and p.year=:y")
	List<Chart>statpremiumbymonth(@Param("m") String month,@Param("y") int year );
	
	@Query("Select new tn.esprit.spring.entity.Chart( p.deliveryman as deliveryman,sum(p.premium) as sumPremium,count(p) as countPremium) from Premium p where  p.year=:y group by p.deliveryman")
	List<Chart>statpremiumbyyear(@Param("y") int year );
	

}
 