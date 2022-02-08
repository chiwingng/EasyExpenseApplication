package com.example.project.cwng.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.cwng.expense.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
