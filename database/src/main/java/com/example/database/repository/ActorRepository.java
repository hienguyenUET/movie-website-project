package com.example.database.repository;

import com.example.database.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Optional<Actor> findAllByName(String name);
    Actor findActorByName(String name);
    Boolean existsByName(String name);
}
