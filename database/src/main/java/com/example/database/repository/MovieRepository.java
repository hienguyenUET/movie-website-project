package com.example.database.repository;

import com.example.database.model.entity.Keyword;
import com.example.database.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie searchByTitle(String name);
    Boolean existsByTitle(String name);
    Boolean existsByIdAPI(String idAPI);
    List<Movie> findByGenre_GenreName(String genre_genreName);
    Movie findByIdAPI(String idAPI);
    List<Movie> findByTitleContaining(String title);
    Set<Movie> findAllByKeywordsIn(List<Keyword> keywords);
}
