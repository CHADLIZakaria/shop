package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.model.User;

public interface UserService {
    public List<User> findAll();
    public void save(User user);
}
