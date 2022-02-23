package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.Category;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findByName(String name);
}
