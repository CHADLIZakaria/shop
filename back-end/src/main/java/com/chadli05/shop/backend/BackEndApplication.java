package com.chadli05.shop.backend;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.model.Product;
import com.chadli05.shop.backend.service.CategoryService;
import com.chadli05.shop.backend.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category1 = categoryService.save(new Category(null, "Froid"));
		Category category2 = categoryService.save(new Category(null, "Sport"));	
		Product product1=productService.save(new Product(null, "shirt 1", category1));
		Product product2=productService.save(new Product(null, "shirt 2", category1));
		Product product3=productService.save(new Product(null, "shirt 3", category1));
		Product product4=productService.save(new Product(null, "shirt 4", category1));

		Product product5=productService.save(new Product(null, "short 1", category2));
		Product product6=productService.save(new Product(null, "short 2", category2));
	}

}
