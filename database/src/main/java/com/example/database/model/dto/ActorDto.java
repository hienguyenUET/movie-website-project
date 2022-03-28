package com.example.database.model.dto;

import com.example.database.model.entity.Film;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ActorDto {
    private long id;

    private String name;

    private List<Film> films;
}
