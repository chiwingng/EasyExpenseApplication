package com.example.project.cwng.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class ExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseApplication.class, args);
	}

}
