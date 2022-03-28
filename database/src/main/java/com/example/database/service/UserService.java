package com.example.database.service;

import com.example.database.api.form.UserForm;
import com.example.database.model.entity.Film;
import com.example.database.model.entity.User;

import java.util.List;

public interface UserService {
    User addNewUser(UserForm user);

    User updateUser(Long id, String password, List<Long> filmId);

    void deleteUser(Long id);

    User getById(Long id);

    List<User> getUserList();

    User save(User user);
}
