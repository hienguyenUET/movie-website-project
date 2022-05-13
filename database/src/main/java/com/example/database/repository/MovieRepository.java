package com.example.database.repository;

import com.example.database.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie searchByTitle(String name);
    Boolean existsByTitle(String name);
}
