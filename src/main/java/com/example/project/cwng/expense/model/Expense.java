package com.example.project.cwng.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="expense")
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

	@Id
	private Long id;
	
	private String description;
	
	private Instant expensedate;
	
	private String location;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;

}
