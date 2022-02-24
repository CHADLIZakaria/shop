package com.chadli05.shop.backend.api;

import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<Object> findAllCategory(
        @RequestParam(defaultValue = "1", name = "page", required = false) Integer pageNumber,
        @RequestParam(defaultValue = "2", name = "size", required = false) Integer size,
        @RequestParam(defaultValue = "id", name = "sortBy", required = false) String keyword
    ) {
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, categoryService.findAll(pageNumber-1, size, keyword));
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findCategoryById(@PathVariable Long id) {
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, categoryService.findById(id));
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategoryById(@PathVariable Long id) {
        try {
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, null);
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, categoryService.save(category));
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @RequestMapping(value="/category", method=RequestMethod.POST)
    public ResponseEntity<Object> saveCategory(@RequestBody Category category) {
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, categoryService.save(category));
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
