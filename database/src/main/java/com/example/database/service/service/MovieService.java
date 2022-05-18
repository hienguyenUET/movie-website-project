package com.example.database.service.service;

import com.example.database.model.entity.Genre;
import com.example.database.model.entity.Movie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieService {
    Movie searchByTitle(String name);
    List<Movie> findAll();
    Movie findById(int theId);
    void save(Movie movie);
    void deleteById(int theId);
    Boolean existsByTitle(String name);
    Boolean existsByIdAPI(String idAPI);
    List<Movie> findByGenre_GenreName(String genre_genreName);
    Movie findByIdAPI(String idAPI);
}
