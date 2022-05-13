package com.example.database.model.dto;

import com.example.database.model.entity.Genre;
import com.example.database.model.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GenreDto {
    private long id;

    private String genre_name;

    private List<Movie> movies;
}
