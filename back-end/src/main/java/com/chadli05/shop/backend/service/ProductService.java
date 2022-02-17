package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.model.Product;

public interface ProductService {
    public List<Product> findAll();
    public List<Product> findByCategory(Category category);
    public Product save(Product product);
    
}
