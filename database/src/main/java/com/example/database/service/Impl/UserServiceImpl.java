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
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    private FilmRepository filmRepository;

    @Override
    public User addNewUser(UserForm data) {
        if(!StringUtils.hasText(data.getName())) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

//        List<Film> films = new ArrayList<>();
//
//        if(data.getFilmId().size() > 0) {
//            data.getFilmId().forEach(item -> {
//                Film film = filmRepository.findById(item).get();
//                films.add(film);
//            });
//        }
        User user = User.builder()
                .name(data.getName())
                .build();

//        Optional<List<Team>> teamLists = Optional.ofNullable(user.getTeams());
//        if(!teamLists.isPresent()) {
//            user.setTeams(teams);
//        }else {
//            teams.forEach(item -> {
//                teamLists.get().add(item);
//            });
//            user.setTeams(teamLists.get());
//        }

        return save(user);
    }

    @Override
    public User updateUser(Long id, String name) {
        User user = userRepository.findById(id).get();
        if(ObjectUtils.isEmpty(user)) {
            String mess = "user-not-exits";
            throw new NotFoundException(mess);
        }

        user.setName(name);

        return save(user);
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
