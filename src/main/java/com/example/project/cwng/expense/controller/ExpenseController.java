package com.example.project.cwng.expense.controller;

import com.example.project.cwng.expense.model.Expense;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.project.cwng.expense.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@GetMapping("/expenses")
	public List<Expense> getExpenses() {
		return expenseRepository.findAll();
	}
	
	@GetMapping("/expense/{id}")
	public Expense getExpense(@PathVariable Long id) {
		return expenseRepository.findById(id).get();
	}
	
	@DeleteMapping("/expense/{id}")
	public ResponseEntity<?> deteleExpense(@PathVariable Long id) {
		expenseRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/expense")
	public ResponseEntity<Expense> createExpense(@Validated @RequestBody Expense expense) throws URISyntaxException {
		Expense result = expenseRepository.save(expense);
		return ResponseEntity.created(new URI("/api/expense" + result.getId())).body(result);
	}
	
	@PutMapping("/expense/{id}")
	ResponseEntity<Expense> updateExpense(@Validated @RequestBody Expense expense, @PathVariable Long id) {
		expense.setId(id);
		Expense result = expenseRepository.save(expense);
		return ResponseEntity.ok().body(result);
	}
	
}
