package com.chadli05.shop.backend.controller;

import com.chadli05.shop.backend.message.ResponseHandler;
import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.service.CategoryService;
import com.chadli05.shop.backend.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<Object> findAllCategory() {
        try {
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, categoryService.findAll());
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
            categoryService.deleteById(id);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, null);
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // @RequestMapping(value="/categories/{id}", method = RequestMethod.PUT)
    // public ResponseEntity<Object> updateCategory(@PathVariable Long id, @RequestBody Category category) {
    //     try {
    //         return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, categoryService.save(category));
    //     }
    //     catch(Exception e) {
    //         return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
    //     }
    // }

    @RequestMapping(value="/category", method=RequestMethod.POST)
    public ResponseEntity<Object> saveCategory(@RequestParam("file") MultipartFile file, Category category) {
        try {
            return ResponseHandler.generateResponse("Successfully saved data", HttpStatus.OK, categoryService.save(file, category));
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // @GetMapping("/files")
    // public ResponseEntity<List<FileInfo>> getListFiles() {
    //   List<FileInfo> fileInfos = fileStorageService.loadAll().map(path -> {
    //     String filename = path.getFileName().toString();
    //     String url = MvcUriComponentsBuilder
    //         .fromMethodName(CategoryApi.class, "getFile", path.getFileName().toString()).build().toString();
    //     return new FileInfo(filename, url);
    //   }).collect(Collectors.toList());
    //   return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    // }

    @GetMapping("/uploads/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStorageService.load(filename);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
