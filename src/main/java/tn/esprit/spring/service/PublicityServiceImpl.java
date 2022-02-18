package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.PublicityRepository;

@Service
public class PublicityServiceImpl implements IPublicityService{

	@Autowired
	PublicityRepository pubRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Publicity> retrieveAllPublicitys() {
		// TODO Auto-generated method stub
		return (List<Publicity>) pubRepository.findAll();
	}

	@Override
	public Publicity addPublicity(Publicity pub) {
		// TODO Auto-generated method stub
		return pubRepository.save(pub);
	}

	@Override
	public void deletePublicity(Long id_pub) {
		// TODO Auto-generated method stub
		pubRepository.deleteById((long) id_pub);
	}

	@Override
	public Publicity updatePublicity(Publicity pub) {
		// TODO Auto-generated method stub
		return pubRepository.save(pub);
	}

	@Override
	public Publicity retrievePublicity(String id_pub) {
		// TODO Auto-generated method stub
		return pubRepository.findById(Long.parseLong(id_pub)).orElse(null);
	}
	
	@Override
	public List<Publicity> retrievePublicityByProduct(Product product) {
		// TODO Auto-generated method stub
		return pubRepository.SearchPublicityByProduct(product);
	}

	@Override
	public void affectProductaPublicity(int id_prod, int id_pub) {
		// TODO Auto-generated method stub
		Publicity publicity = pubRepository.findById((long) id_pub).orElse(null);
		Product product = productRepository.findById((long) id_prod).orElse(null);
		publicity.setProduct(product);
		;
		pubRepository.save(publicity);
	}

	@Override
	public List<Publicity> SearchPublicityByName(String name_pub) {
		// TODO Auto-generated method stub
		return pubRepository.SearchPublicityByName(name_pub);
	}
}
