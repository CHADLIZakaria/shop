package com.chadli05.shop.backend.api;

import com.chadli05.shop.backend.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileApi {

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(method = RequestMethod.POST, value="/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileStorageService.store(file);
            return ResponseHandler.generateResponse("file uploaded", HttpStatus.OK,  null);
        }
        catch(Exception e) {
            return ResponseHandler.generateResponse("file not uploaded", HttpStatus.FORBIDDEN,  null);
        }
    }
    
}
