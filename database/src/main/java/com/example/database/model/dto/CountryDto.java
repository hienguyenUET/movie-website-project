package com.example.database.model.dto;

import com.example.database.model.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CountryDto {
    private Long id;
    private String countryName;
    private List<Movie> movies;
}
