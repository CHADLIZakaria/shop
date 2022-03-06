package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.FileDB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB, Long> {
    
}
