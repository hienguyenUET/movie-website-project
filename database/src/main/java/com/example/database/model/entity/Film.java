package com.example.database.model.entity;

import com.example.database.model.dto.FilmDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "films")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "homepage")
    private String homepage;

//    @Column(name = "language")
//    private String language;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "production_date")
    private Date productionDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @JsonIgnore
    @ManyToMany(mappedBy = "films")
    private List<User> users = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "actor_film",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Actor> actors = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private List<Comment> comments = new ArrayList<>();

    public FilmDto toDto() {
        return FilmDto.builder()
                .id(id)
                .homepage(homepage)
                .title(title)
                .image(image)
                .productionDate(productionDate)
                .actors(actors)
                .country(country)
                .comments(comments)
                .type(type)
                .build();
    }

}
