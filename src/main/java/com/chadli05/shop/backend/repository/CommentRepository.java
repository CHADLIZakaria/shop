package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.Comment;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    
}
