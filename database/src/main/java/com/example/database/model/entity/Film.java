package com.example.database.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "films")
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

    @Column(name = "actor_id")
    private long actorId;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToMany(mappedBy = "films")
    private List<User> users = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "actor_film",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "film")
    private List<Comment> comments = new ArrayList<>();

}
