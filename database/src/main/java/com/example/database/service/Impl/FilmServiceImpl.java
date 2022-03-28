package com.example.database.service.Impl;

import com.example.database.api.form.FilmForm;
import com.example.database.model.entity.Actor;
import com.example.database.model.entity.Comment;
import com.example.database.model.entity.Film;
import com.example.database.repository.*;
import com.example.database.service.FilmService;
import com.example.database.utils.exception.BadRequestException;
import com.example.database.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    TypeRepository typeRepository;

    @Override
    public Film addNewFilm(FilmForm filmForm) {
        if(!StringUtils.hasText(filmForm.getTitle())) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

        List<Actor> actors = new ArrayList<>();

        if(filmForm.getActorId().size() > 0) {
            filmForm.getActorId().forEach(item -> {
                Actor actor = actorRepository.findById(item).get();
                actors.add(actor);
            });
        }

        Film film = Film.builder()
                .homepage(filmForm.getHomepage())
                .title(filmForm.getTitle())
                .image(filmForm.getImage())
                .productionDate(filmForm.getProductionDate())
                .actors(actors)
                .build();

        if(!ObjectUtils.isEmpty(countryRepository.findById(filmForm.getCountryId()))) {
            film.setCountry(countryRepository.findById(filmForm.getCountryId()).get());
        }

        if(!ObjectUtils.isEmpty(typeRepository.findById(filmForm.getTypeId()))) {
            film.setType(typeRepository.findById(filmForm.getTypeId()).get());
        }

        return save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        Film film = filmRepository.findById(id).get();
        if(ObjectUtils.isEmpty(film)) {
            String mess = "film-not-exits";
            throw new NotFoundException(mess);
        }

        filmRepository.deleteById(id);
    }

    @Override
    public Film getById(Long id) {
        Film film = filmRepository.findById(id).get();
        if(ObjectUtils.isEmpty(film)) {
            String mess = "film-not-exits";
            throw new NotFoundException(mess);
        }

        return film;
    }

    @Override
    public List<Film> getFilmList() {
        List<Film> films = (List<Film>) filmRepository.findAll();
        if(ObjectUtils.isEmpty(films)) {
            return Collections.EMPTY_LIST;
        }

        return films;
    }

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
    }
}
