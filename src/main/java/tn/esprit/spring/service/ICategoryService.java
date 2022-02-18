package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Category;

public interface ICategoryService {

	List<Category> retrieveAllCategorys();

	Category addCategory(Category c);

	void deleteCategory(Long id_cat);

	Category updateCategory(Category c);

	Category retrieveCategory(String id_cat);
}
