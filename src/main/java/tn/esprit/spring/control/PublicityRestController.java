package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.service.IPublicityService;

@RestController
public class PublicityRestController {

	@Autowired
	IPublicityService pubService;

	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-publicity
	@GetMapping("/retrieve-all-publicity")
	@ResponseBody
	public List<Publicity> getPublicitys() {
		List<Publicity> list = pubService.retrieveAllPublicitys();
		return list;
	}

	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-publicity/{pub-id}
	@GetMapping("/retrieve-publicity/{pub-id}")
	@ResponseBody
	public Publicity retrievePublicity(@PathVariable("pub-id") String id_pub) {
		return pubService.retrievePublicity(id_pub);
	}

	// Ajouter : http://localhost:8086/ConsomiTounsi/servlet/add-publicity
	@PostMapping("/add-publicity")
	@ResponseBody
	public Publicity addPublicity(@RequestBody Publicity pub) {
		Publicity publ = pubService.addPublicity(pub);
		return publ;
	}

	// http://localhost:8086/ConsomiTounsi/servlet/remove-publicity/{pub-id}
	@DeleteMapping("/remove-publicity/{pub-id}")
	@ResponseBody
	public void removePublicity(@PathVariable("pub-id") Long id_pub) {
		pubService.deletePublicity(id_pub);
		;
	}

	// http://localhost:8086/ConsomiTounsi/servlet/modify-publicity
	@PutMapping("/modify-publicity")
	@ResponseBody
	public Publicity modifyPublicity(@RequestBody Publicity pub) {
		return pubService.updatePublicity(pub);
	}
	
	// search by product
		// http://localhost:8086/ConsomiTounsi/servlet/search-byproduct/{product}
		@GetMapping("/search-byproduct/{product}")
		@ResponseBody
		public List<Publicity> SearchPublicitybyProduct(@PathVariable("product") Product product) {
			return pubService.retrievePublicityByProduct(product);
		}

		// affecter product to publicity
		// http://localhost:8086/ConsomiTounsi/servlet/add-product-a-publicity/{prod-id}/{pub-id}
		@PutMapping("/add-product-a-publicity/{prod-id}/{pub-id}")
		@ResponseBody
		public void affectCategorytoProduct(@PathVariable("prod-id") int id_prod, @PathVariable("pub-id") int id_pub) {
			pubService.affectProductaPublicity(id_prod, id_pub);
			;
		}

		// recherche par nom
		// http://localhost:8086/ConsomiTounsi/servlet/search-publicity/{pub-name}
		@GetMapping("/search-publicity/{pub-name}")
		@ResponseBody
		public List<Publicity> SearchPublicityByName(@PathVariable("pub-name") String name_pub) {
			return pubService.SearchPublicityByName(name_pub);
		}
		
}
