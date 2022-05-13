package com.example.database.repository;

import com.example.database.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findAllByGenreName(String genreName);
    Boolean existsByGenreName(String name);
    Genre findByGenreName(String name);
}
