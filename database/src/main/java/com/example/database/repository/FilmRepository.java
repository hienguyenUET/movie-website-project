package com.example.database.repository;

import com.example.database.model.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
