package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
