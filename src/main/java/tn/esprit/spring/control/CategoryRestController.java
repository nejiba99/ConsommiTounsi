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

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.service.ICategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	ICategoryService catService;

	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-categorys
	@GetMapping("/retrieve-all-categorys")
	@ResponseBody
	public List<Category> getCategorys() {
		List<Category> list = catService.retrieveAllCategorys();
		return list;
	}

	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-category/{cat-id}
	@GetMapping("/retrieve-category/{cat-id}")
	@ResponseBody
	public Category retrieveCategory(@PathVariable("cat-id") String id_cat) {
		return catService.retrieveCategory(id_cat);
	}

	// Ajouter : http://localhost:8086/ConsomiTounsi/servlet/add-category
	@PostMapping("/add-category")
	@ResponseBody
	public Category addCategory(@RequestBody Category c) {
		Category cat = catService.addCategory(c);
		return cat;
	}

	// http://localhost:8086/ConsomiTounsi/servlet/remove-category/{cat-id}
	@DeleteMapping("/remove-category/{cat-id}")
	@ResponseBody
	public void removeCategory(@PathVariable("cat-id") Long id_cat) {
		catService.deleteCategory(id_cat);
	}

	// http://localhost:8086/ConsomiTounsi/servlet/modify-category
	@PutMapping("/modify-category")
	@ResponseBody
	public Category modifyCategory(@RequestBody Category c) {
		return catService.updateCategory(c);
	}
}
