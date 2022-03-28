package com.example.database.service;

import com.example.database.api.form.FilmForm;
import com.example.database.model.entity.Film;

import java.util.List;

public interface FilmService {
    Film addNewFilm(FilmForm filmForm);

//    Film updateFilm(Long id, String name);
//
    void deleteFilm(Long id);

    Film getById(Long id);

    List<Film> getFilmList();

    Film save(Film film);
}
