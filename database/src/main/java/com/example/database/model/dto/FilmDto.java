package com.example.database.model.dto;

import com.example.database.model.entity.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Builder
@Data
public class FilmDto {
    private long id;

    private String homepage;

    private String title;

    private String image;

    private Date productionDate;

    private Type type;

    private List<User> users;

    private List<Actor> actors;

    private Country country;

    private List<Comment> comments;
}
