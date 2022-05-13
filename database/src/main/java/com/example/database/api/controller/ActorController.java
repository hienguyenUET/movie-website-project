package com.example.database.api.controller;

import com.example.database.model.entity.Actor;
import com.example.database.service.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/get")
    public ResponseEntity<List<Actor>> getActor() {
        List<Actor> actors = actorService.findAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
}
