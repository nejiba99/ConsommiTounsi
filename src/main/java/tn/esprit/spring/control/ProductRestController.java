package tn.esprit.spring.control;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Statistic;
import tn.esprit.spring.service.IProductService;
import tn.esprit.spring.service.ServiceStatistic;

@RestController
public class ProductRestController {

	@Autowired
	IProductService prodService;
	
	@Autowired
	ServiceStatistic statService;
	
	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-products
		@GetMapping("/retrieve-all-products")
		@ResponseBody
		public List<Product> getProducts() {
			List<Product> list = prodService.retrieveAllProducts();
			return list;
		}

		// http://localhost:8086/ConsomiTounsi/servlet/retrieve-product/{prod-id}
		@GetMapping("/retrieve-product/{prod-id}")
		@ResponseBody
		public Product retrieveProduct(@PathVariable("prod-id") String id_prod) {
			return prodService.retrieveProduct(id_prod);
		}

		// Ajouter : http://localhost:8086/ConsomiTounsi/servlet/add-product
		@PostMapping("/add-product")
		@ResponseBody
		public Product addProduct(@RequestBody Product p) {
			Product prod = prodService.addProduct(p);
			return prod;
		}

		// http://localhost:8086/ConsomiTounsi/servlet/remove-product/{prod-id}
		@DeleteMapping("/remove-product/{prod-id}")
		@ResponseBody
		public void removeProduct(@PathVariable("prod-id") Long id_prod) {
			prodService.deleteProduct(id_prod);
			;
		}

		// http://localhost:8086/ConsomiTounsi/servlet/modify-product
		@PutMapping("/modify-product")
		@ResponseBody
		public Product modifyProduct(@RequestBody Product p) {
			return prodService.updateProduct(p);
		}
		
		// recherche par nom
		// http://localhost:8086/ConsomiTounsi/servlet/search-product/{prod-name}
		@GetMapping("/search-product/{prod-name}")
		@ResponseBody
		public List<Product> SearchProductByName(@PathVariable("prod-name") String name_prod) {
			return prodService.SearchProductByName(name_prod);
		}

		// afficher par category
		// http://localhost:8086/ConsomiTounsi/servlet/search-category/{category}
		@GetMapping("/search-category/{category}")
		@ResponseBody
		public List<Product> SearchProductByCategory(@PathVariable("category") Category category) {
			return prodService.retrieveProductByCategory(category);
		}

		// range of price
		// http://localhost:8086/ConsomiTounsi/servlet/range/{min}/{max}
		@GetMapping("/range/{min}/{max}")
		@ResponseBody
		public List<Product> RangeProducts(@PathVariable("min") float min, @PathVariable("max") float max) {
			return prodService.Range(min, max);
		}

		// trie les prod par qantity asc
		// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-products-asc
		@GetMapping("/retrieve-all-products-asc")
		@ResponseBody
		public List<Product> orderByAscendingQantity() {
			List<Product> list = prodService.orderByAscendingQantity();
			return list;
		}

		// trie les prod par qantity desc
		// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-products-desc
		@GetMapping("/retrieve-all-products-desc")
		@ResponseBody
		public List<Product> orderByDescendingQantity() {
			List<Product> list = prodService.orderByDescendingQantity();
			return list;
		}

		// statistic
		// http://localhost:8086/ConsomiTounsi/servlet/statistic
		@GetMapping("/statistic")
		@ResponseBody
		public ResponseEntity<Statistic> getStatistic() {
			List<Product> products = prodService.retrieveAllProducts();
			Statistic statistics = statService.CreateStatistic(products);

			return ResponseEntity.ok(statistics);
		}

		// affecter category to product
		// http://localhost:8086/ConsomiTounsi/servlet/add-category-a-product/{cat-id}/{prod-id}
		@PutMapping("/add-category-a-product/{cat-id}/{prod-id}")
		@ResponseBody
		public void affectCategorytoProduct(@PathVariable("cat-id") int id_cat, @PathVariable("prod-id") int id_prod) {
			prodService.affectCategoryProduct(id_cat, id_prod);
		}

		// importer la liste des produits dans un fichier exel
		// http://localhost:8086/ConsomiTounsi/servlet/download
		@GetMapping("/download")
		@ResponseBody
		public ResponseEntity<Resource> getFile() {
			String filename = "products.xlsx";
			InputStreamResource file = new InputStreamResource(prodService.load());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		}

		// afficher le nombre des orders w chaque produit
		// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-productswithorders
		@GetMapping("/retrieve-all-productswithorders")
		@ResponseBody
		Map<Product, Integer> getProductss() {
			Map<Product, Integer> list = prodService.getProductsSells();
			return list;
		}

		// afficher la liste des produits qui sont vondue maximum
		// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-productswithorders/{n}
		@GetMapping("/retrieve-all-productswithorders/{n}")
		@ResponseBody
		Map<Product, Integer> getTopNProducts(@PathVariable("n") int n) {
			Map<Product, Integer> list = prodService.getTopNProducts(n);
			return list;
		}
}
