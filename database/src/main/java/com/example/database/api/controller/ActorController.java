package com.example.database.api.controller;

import com.example.database.model.entity.Actor;
import com.example.database.payload.response.DetailedActor;
import com.example.database.service.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {
    @Autowired
    private ActorService actorService;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/get")
    public ResponseEntity<List<Actor>> getActor() {
        List<Actor> actors = actorService.findAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    public DetailedActor getDetailedActor(long id) {
        String api = "https://api.themoviedb.org/3/person/" + id + "?api_key=606b350a5be7a4ff1de563e915b76a18&language=en-US";
        ResponseEntity<DetailedActor> responseEntity = restTemplate.exchange(
                api,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<DetailedActor>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }
        );
        return responseEntity.getBody();
    }
}
