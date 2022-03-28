package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.model.User;

public interface UserService {
    public List<User> findAll();
    public User save(User user);
    public User findByUsername(String username);
    public void addRoleToUser(String username, String roleName);
    public void deleteById(Long id);
}
