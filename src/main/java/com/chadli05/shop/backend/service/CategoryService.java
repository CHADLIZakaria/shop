package com.chadli05.shop.backend.service;

import java.io.IOException;
import java.util.List;

import com.chadli05.shop.backend.model.Category;

import org.springframework.web.multipart.MultipartFile;

public interface CategoryService {
    public List<Category> findAll();
    public Category save(MultipartFile file, Category category)  throws IOException;
    public Category findById(Long id);
    public void deleteById(Long id);
    public Category udpate(Category category);
    public Category findByName(String name);
    
}
