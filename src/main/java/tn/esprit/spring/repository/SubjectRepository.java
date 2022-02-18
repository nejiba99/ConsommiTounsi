package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Subject;
import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{

	public List<Subject> findByProduct(Product product);
	public List<Subject> findByClient(Client client);
}
