package com.chadli05.shop.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(int pageNumber, int pageSize, String sortingBy) {
        PageRequest paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortingBy));
        Page<Category> categories = categoryRepository.findAll(paging);
        if(categories.hasContent()) return categories.getContent();
        return new ArrayList<Category>();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
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
