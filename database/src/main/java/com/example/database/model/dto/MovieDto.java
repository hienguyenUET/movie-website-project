package com.example.database.model.dto;

import com.example.database.model.entity.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class MovieDto {
    private long id;

    private String homepage;

    private String title;

    private String image;

    private Date productionDate;

    private Set<Genre> genre;

    private List<Account> people;

    private List<Actor> actors;

    private List<Company> company;

    private List<Country> country;

    private List<Comment> comments;
}
