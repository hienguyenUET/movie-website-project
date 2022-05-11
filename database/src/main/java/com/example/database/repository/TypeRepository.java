package com.example.database.repository;

import com.example.database.model.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Genre, Long> {
}
