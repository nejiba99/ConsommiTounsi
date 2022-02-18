package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Publicity;

public interface IPublicityService {

	List<Publicity> retrieveAllPublicitys();

	Publicity addPublicity(Publicity pub);

	void deletePublicity(Long id_pub);

	Publicity updatePublicity(Publicity pub);

	Publicity retrievePublicity(String id_pub);
	
	List<Publicity> retrievePublicityByProduct(Product product);

	public void affectProductaPublicity(int id_prod, int id_pub);

	List<Publicity> SearchPublicityByName(String name_pub);
}
