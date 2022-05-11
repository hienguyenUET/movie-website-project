package com.example.database.model.dto;

import com.example.database.model.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class PersonDto implements Serializable {
    private int id;
    private String name;
    private String password;
    private List<Movie> movies;
}
