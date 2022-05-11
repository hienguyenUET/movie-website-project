package com.example.database.service.service;

import com.example.database.model.entity.User;

public interface LoginService {
    User checkUsernameAndPassword(String username, String password);
}
