package com.chadli05.shop.backend.serviceImpl;

import java.util.List;

import com.chadli05.shop.backend.message.ResponseListPage;
import com.chadli05.shop.backend.model.Category;
import com.chadli05.shop.backend.model.Product;
import com.chadli05.shop.backend.repository.ProductRepository;
import com.chadli05.shop.backend.service.FileStorageService;
import com.chadli05.shop.backend.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public ResponseListPage findAll(int page, int size, String sortBy) {
        PageRequest paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Product> productPage = productRepository.findAll(paging);
        return new ResponseListPage(productPage.getTotalPages(), productPage.getTotalElements(), paging.getPageNumber()+1,productPage.getContent());
        
    }

    @Override
    public Product save(MultipartFile file, Product product) {
        Product productSaved = productRepository.save(product);
        fileStorageService.save(file, "product_"+productSaved.getId()+"_");
        productSaved.setImage("product_"+productSaved.getId()+"_"+file.getOriginalFilename());
        return productRepository.save(product);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Object findById(Long id) {
        return productRepository.findById(id);
    }
    
}
