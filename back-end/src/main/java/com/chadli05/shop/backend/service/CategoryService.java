package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.model.Category;

public interface CategoryService {
    public List<Category> findAll();
    public Category save(Category category);
    public Category findById(Long id);
    public void deleteById(Long id);
    public Category udpate(Category category);
    public Category findByName(String name);
    
}
