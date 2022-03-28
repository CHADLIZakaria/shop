package com.chadli05.shop.backend.service;

import java.util.List;

import com.chadli05.shop.backend.model.Role;

public interface RoleService {
    public Role findByName(String roleName);
    public Role save(Role role);
    public void deleteById(Long id);
    public List<Role> findAll();
    

}
