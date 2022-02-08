package com.example.project.cwng.expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data // Lombok handles all getter/setters etc. for you
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private Long id;
	
	private String name;
	
	private String email;
	
	
}
