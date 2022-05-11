package com.example.database.service.service;

import com.example.database.model.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
