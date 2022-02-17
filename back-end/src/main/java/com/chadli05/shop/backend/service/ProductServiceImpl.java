package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.model.Product;
import com.chadli05.shop.backend.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
    
}
