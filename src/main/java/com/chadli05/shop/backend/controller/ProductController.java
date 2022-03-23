package com.chadli05.shop.backend.controller;

import java.util.List;

import com.chadli05.shop.backend.message.ResponseHandler;
import com.chadli05.shop.backend.model.Product;
import com.chadli05.shop.backend.service.CategoryService;
import com.chadli05.shop.backend.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired 
    private CategoryService categoryService;

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public ResponseEntity<Object> findAllProducts(
        @RequestParam(name="page", defaultValue = "1") int page,
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="sortBy", defaultValue = "id") String sortBy  
    ) {
        return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, productService.findAll(page-1, size, sortBy));
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById(
        @PathVariable Long id 
    ) {
        return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, productService.findById(id));
    }

    @RequestMapping(value="/products/save", method = RequestMethod.POST) 
    public ResponseEntity<Product> saveProduct(
        @RequestParam("file") MultipartFile file, 
        Product product) {
        return ResponseEntity.ok().body(productService.save(file, product));
    }
    @RequestMapping(value="/category/{name}/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findProductsByCategories(@PathVariable String name) {
        return ResponseEntity.ok().body(productService.findByCategory(categoryService.findByName(name)));
    }
}
