package com.example.project.cwng.expense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 4)
public class Category {

	@Id // primary key in the table
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "port_gen")
	@Column(name="ID", unique=true, nullable=false)
	private long id;
	
	// E.g. travel, grocery,...
	@NonNull
	@Column(name="NAME")
	private String name;

}
