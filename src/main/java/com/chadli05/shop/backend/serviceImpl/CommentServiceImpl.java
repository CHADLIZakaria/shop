package com.chadli05.shop.backend.serviceImpl;

import com.chadli05.shop.backend.message.ResponseListPage;
import com.chadli05.shop.backend.model.Comment;
import com.chadli05.shop.backend.repository.CommentRepository;
import com.chadli05.shop.backend.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ResponseListPage findAll(int page, int size, String sortBy) {
        PageRequest paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Comment> commentPage = commentRepository.findAll(paging);
        return new ResponseListPage(commentPage.getTotalPages(), commentPage.getTotalElements(), paging.getPageNumber()+1,commentPage.getContent());
    }

    @Override
    public void save(Comment comment) {
       commentRepository.save(comment);
    }


    
}
