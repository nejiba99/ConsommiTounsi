package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	@Query("SELECT p FROM Product p WHERE p.name_prod= :name_prod")
	List<Product> SearchProductByName(@Param("name_prod") String name_prod);
	
	@Query("SELECT p FROM Product p WHERE p.category= :category")
	List<Product> SearchProductByCategory(@Param("category") Category category);
	
	@Query("select p from Product p where p.price_prod between :min and :max")
	public List<Product> Range(@Param("min") float min, @Param("max") float max);
	
	@Query("from Product order by quantity asc")
	public List<Product> orderByAscendingQantity();
	
	@Query("from Product order by quantity desc")
	public List<Product> orderByDescendingQantity();
	
	 @Query(value = "SELECT * from Product p WHERE p.name_prod = :name", nativeQuery = true)

	Product getByName(@Param("name")String name);
}
