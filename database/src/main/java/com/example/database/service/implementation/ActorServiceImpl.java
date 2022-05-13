package com.example.database.service.implementation;

import com.example.database.model.entity.Actor;
import com.example.database.repository.ActorRepository;
import com.example.database.service.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Autowired
    ActorRepository actorRepository;

    @Override
    public Boolean existsByName(String name) {
        return actorRepository.existsByName(name);
    }

    @Override
    public Optional<Actor> findAllByName(String name) {
        return actorRepository.findAllByName(name);
    }

    @Override
    public Actor findActorByName(String name) {
        return actorRepository.findActorByName(name);
    }

    @Override
    public void save(Actor actor) {
        actorRepository.save(actor);
    }
}
