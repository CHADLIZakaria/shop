package com.chadli05.shop.backend.serviceImpl;

import java.util.List;

import com.chadli05.shop.backend.model.User;
import com.chadli05.shop.backend.repository.UserRepository;
import com.chadli05.shop.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    
}
