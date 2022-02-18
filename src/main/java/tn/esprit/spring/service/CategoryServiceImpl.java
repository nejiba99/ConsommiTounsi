package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	CategoryRepository catRepository;

	@Override
	public List<Category> retrieveAllCategorys() {
		// TODO Auto-generated method stub
		return (List<Category>) catRepository.findAll();
	}

	@Override
	public Category addCategory(Category c) {
		// TODO Auto-generated method stub
		return catRepository.save(c);
	}

	@Override
	public void deleteCategory(Long id_cat) {
		// TODO Auto-generated method stub
		catRepository.deleteById((long) id_cat);
	}

	@Override
	public Category updateCategory(Category c) {
		// TODO Auto-generated method stub
		return catRepository.save(c);
	}

	@Override
	public Category retrieveCategory(String id_cat) {
		// TODO Auto-generated method stub
		return catRepository.findById(Long.parseLong(id_cat)).orElse(null);
	}
}
