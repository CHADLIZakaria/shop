package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
