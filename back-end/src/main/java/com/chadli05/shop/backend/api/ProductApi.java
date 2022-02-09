package com.chadli05.shop.backend.api;

import java.util.List;

import com.chadli05.shop.backend.model.Product;
import com.chadli05.shop.backend.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductApi {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok().body(productService.findAll());
    }
    
}
