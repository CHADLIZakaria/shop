package com.chadli05.shop.backend.repository;

import java.util.List;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.model.Product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
