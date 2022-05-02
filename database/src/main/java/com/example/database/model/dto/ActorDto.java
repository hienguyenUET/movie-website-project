package com.example.database.model.dto;

import com.example.database.model.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActorDto {
    private long id;

    private String name;

    private List<Movie> movies;
}
