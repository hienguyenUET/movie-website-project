package com.example.database.repository;

import com.example.database.model.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
}
