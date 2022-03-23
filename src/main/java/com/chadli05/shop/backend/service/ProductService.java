package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.message.ResponseListPage;
import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.model.Product;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    public ResponseListPage findAll(int page, int size, String sortBy);
    public List<Product> findByCategory(Category category);
    public Product save(MultipartFile file, Product product);
    public Object findById(Long id);
}
