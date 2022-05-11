package com.example.database.service.service;

import com.example.database.model.entity.Movie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    Movie findById(int theId);
    void save(Movie movie);
    void deleteById(int theId);
}
