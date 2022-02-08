package com.example.project.cwng.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.cwng.expense.model.Category;
import com.example.project.cwng.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	private CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("/categories")
	public List<Category> categories() {
		
		return categoryRepository.findAll();
		// select * from category
	}
	
	@GetMapping("/category/id/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/category/name/{name}")
	public ResponseEntity<?> getCategoryByName(@PathVariable String name) {
		Optional<Category> category = categoryRepository.findByName(name);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException{
		Category result = categoryRepository.save(category);
		// insert into category ...
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
	}
	
	@PutMapping("/category/{id}")
	ResponseEntity<Category> updateCategory(@Validated @RequestBody Category category) {
		Category result = categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
