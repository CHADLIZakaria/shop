package com.chadli05.shop.backend.serviceImpl;


import java.io.IOException;
import java.util.List;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.repository.CategoryRepository;
import com.chadli05.shop.backend.service.CategoryService;
import com.chadli05.shop.backend.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired 
    private FileStorageService fileStorageService;
    
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(MultipartFile file, Category category) throws IOException {
        Category categorySaved = categoryRepository.save(category);
         fileStorageService.save(file, "category_"+categorySaved.getId()+"_");
         categorySaved.setIcon("category_"+categorySaved.getId()+"_"+file.getOriginalFilename());
        return categoryRepository.save(categorySaved);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category udpate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
    
}
