package com.example.database.service;

import com.example.database.api.form.ActorForm;
import com.example.database.model.entity.Actor;

import java.util.List;

public interface ActorService {
    Actor addNewActor(ActorForm actorForm);

    Actor updateActor(Long id, String name, List<Long> filmId);

    void deleteActor(Long id);

    Actor getById(Long id);

    List<Actor> getActorList();

    Actor save(Actor actor);
}
