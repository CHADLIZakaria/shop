package com.chadli05.shop.backend;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.service.CategoryService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CategoryService categoryService) {
		return args -> { 
			categoryService.save(new Category(null, "Shirt"));
			categoryService.save(new Category(null, "Froid"));
			categoryService.save(new Category(null, "Sport"));
			
		};
	}

}
