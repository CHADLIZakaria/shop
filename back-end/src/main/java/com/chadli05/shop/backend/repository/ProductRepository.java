package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
