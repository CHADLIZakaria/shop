package com.chadli05.shop.backend.controller;

import com.chadli05.shop.backend.message.ResponseHandler;
import com.chadli05.shop.backend.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(
        @RequestParam(defaultValue = "5", name = "size", required = false) int size,
        @RequestParam(defaultValue = "1", name="page", required = false) int page,
        @RequestParam(defaultValue = "id", name="sortBy", required = false) String sortBy
    ) {
        return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, commentService.findAll(page-1, size, sortBy));
    }    
}
