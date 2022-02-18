package tn.esprit.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Message;


@Repository
public interface ChatMessageRepository extends CrudRepository<Message,Long> {
	
	@Query(value="SELECT * FROM Message m WHERE ROUND(TIME_TO_SEC(timediff(now(),m.date))/60) < 10",nativeQuery=true)
	public List<Message> findHistory();

}
