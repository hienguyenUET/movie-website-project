package com.example.database.service.Impl;

import com.example.database.api.form.UserForm;
import com.example.database.model.entity.Film;
import com.example.database.model.entity.User;
import com.example.database.repository.FilmRepository;
import com.example.database.repository.UserRepository;

import com.example.database.service.UserService;
import com.example.database.utils.exception.BadRequestException;
import com.example.database.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public User addNewUser(UserForm userForm) {
        // check xem có bỏ trống tên hay không
        if(!StringUtils.hasText(userForm.getName())) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

        // check xem tên đã tồn tại trong database chưa
        // nếu tồn tại rồi báo lỗi
        if(!ObjectUtils.isEmpty(userRepository.findByName(userForm.getName()))) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

        if(!StringUtils.hasText(userForm.getPassword())) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

        User user = User.builder()
                .name(userForm.getName())
                .password(userForm.getPassword())
                .build();
        return save(user);
    }

    @Override
    public User updateUser(Long id, String password, List<Long> filmId) {
        User user = userRepository.findById(id).get();
        if(ObjectUtils.isEmpty(user)) {
            String mess = "user-not-exits";
            throw new NotFoundException(mess);
        }
        user.setPassword(password);

        if(filmId == null) {
            return save(user);
        } else {
            filmId.forEach(item -> {
                int dem = (int) user.getFilms().stream().filter(film -> item == film.getId()).count();
                if(dem == 0) {
                    user.getFilms().add(filmRepository.findById(item).get());
                }
            });

            return save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        if(ObjectUtils.isEmpty(user)) {
            String mess = "user-not-exits";
            throw new NotFoundException(mess);
        }

        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        User user = userRepository.findById(id).get();
        if(ObjectUtils.isEmpty(user)) {
            String mess = "user-not-exits";
            throw new NotFoundException(mess);
        }
        return user;
    }

    @Override
    public List<User> getUserList() {
        List<User> users = (List<User>) userRepository.findAll();
        if(ObjectUtils.isEmpty(users)) {
            return Collections.EMPTY_LIST;
        }

        return users;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
