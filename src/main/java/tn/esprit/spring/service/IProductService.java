package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Product;

public interface IProductService {

	List<Product> retrieveAllProducts();

	Product addProduct(Product p);

	void deleteProduct(Long id_prod);

	Product updateProduct(Product p);

	Product retrieveProduct(String id_prod);
	
	List<Product> SearchProductByName(String name_prod);

	List<Product> retrieveProductByCategory(Category category);

	public List<Product> Range(float min, float max);

	public List<Product> orderByAscendingQantity();

	public List<Product> orderByDescendingQantity();

	public void affectCategoryProduct(int id_cat, int id_prod);

	public ByteArrayInputStream load();

	public Map<Product, Integer> getTopNProducts(int n);

	Map<Product, Integer> getProductsSells();

}
