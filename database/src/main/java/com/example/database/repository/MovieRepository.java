package com.example.database.repository;

import com.example.database.model.entity.Actor;
import com.example.database.model.entity.Genre;
import com.example.database.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie searchByTitle(String name);
    Boolean existsByTitle(String name);
    Boolean existsByIdAPI(String idAPI);
    List<Movie> findByGenre_GenreName(String genre_genreName);
    Movie findByIdAPI(String idAPI);
}
