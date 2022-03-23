package com.chadli05.shop.backend;

import com.chadli05.shop.backend.model.Comment;
import com.chadli05.shop.backend.service.CategoryService;
import com.chadli05.shop.backend.service.CommentService;
import com.chadli05.shop.backend.service.FileStorageService;
import com.chadli05.shop.backend.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;

	
	@Autowired
	private FileStorageService fileStorageService;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Category category1 = categoryService.save(null, new Category(null, "Froid", ""));
		// Category category2 = categoryService.save(null, new Category(null, "Sport", ""));
		// Category category3 = categoryService.save(null, new Category(null, "Enfant", ""));
		// Category category4 = categoryService.save(null, new Category(null, "Adulte", ""));
			
		// Product product1=productService.save(new Product(null, "shirt 1", category1));
		// Product product2=productService.save(new Product(null, "shirt 2", category1));
		// Product product3=productService.save(new Product(null, "shirt 3", category1));
		// Product product4=productService.save(new Product(null, "shirt 4", category1));
		// Product product5=productService.save(new Product(null, "short 1", category2));
		// Product product6=productService.save(new Product(null, "short 2", category2));
		// for(int i=0; i<10; i++) {
		// 	commentService.save(new Comment(null, "comment "+(i+1)));
		// }
		// Comment comment1 = new Comment(null, "comment1");
		// Comment comment2 = new Comment(null, "comment2");
		// Comment comment3 = new Comment(null, "comment3");

		// commentService.save(comment1);
		// commentService.save(comment2);
		// commentService.save(comment3);
		

		//fileStorageService.deleteAll();
		fileStorageService.init();
	}

}
