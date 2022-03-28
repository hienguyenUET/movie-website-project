package com.example.database.model.dto;

import com.example.database.model.entity.Film;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CountryDto {
    private Long id;

    private String name;

    private List<Film> films;
}
