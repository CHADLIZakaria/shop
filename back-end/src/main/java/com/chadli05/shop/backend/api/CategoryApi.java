package com.chadli05.shop.backend.api;

import java.util.List;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> findAllCategory() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.POST)
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.save(category));
    }
}
