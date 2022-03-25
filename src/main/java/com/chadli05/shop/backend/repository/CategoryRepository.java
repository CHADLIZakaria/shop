package com.chadli05.shop.backend.repository;

import java.util.List;

import com.chadli05.shop.backend.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Category findByName(String name);
    List<Category> findByNameContainingIgnoreCase(String name);
}
