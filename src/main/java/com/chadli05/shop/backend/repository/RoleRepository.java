package com.chadli05.shop.backend.repository;

import com.chadli05.shop.backend.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
