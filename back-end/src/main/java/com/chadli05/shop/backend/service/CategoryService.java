package com.chadli05.shop.backend.service;

import com.chadli05.shop.backend.api.ResponseListPage;
import com.chadli05.shop.backend.model.Category;

public interface CategoryService {
    public ResponseListPage findAll(int pageNumber, int pageSize, String sortingBy);
    public Category save(Category category);
    public Category findById(Long id);
    public void deleteById(Long id);
    public Category udpate(Category category);
    public Category findByName(String name);
    
}
