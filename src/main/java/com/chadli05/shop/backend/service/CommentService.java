package com.chadli05.shop.backend.service;

import com.chadli05.shop.backend.message.ResponseListPage;
import com.chadli05.shop.backend.model.Comment;

public interface CommentService {
    public ResponseListPage findAll(int page , int size, String sortBy);
    public void save(Comment comment);
    
}
