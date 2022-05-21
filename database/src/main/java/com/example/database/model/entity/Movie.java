package com.example.database.model.entity;

import com.example.database.model.dto.MovieDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Todo: create relationship between:
 * movie-company
 * movie-keyword
 * <p>
 * Todo: create country table
 *       create language table
 */

@Entity
@Table(name = "movie")
@Setter
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "id_movie_api")
    private String idAPI;

    @NonNull
    @Column(name = "title")
    @JsonProperty("Title")
    private String title;

    @Column(name = "plot")
    private String overview;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "homepage")
    private String homepage;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "comment_id")
//    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    @Column(name = "poster_path")
    private String posterPath;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "keyword_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")

    )
    List<Keyword> keywords;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genre;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "movie_company",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    List<Country> countries;
//
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_language",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    List<Language> languages;

    public Movie(String title) {
        this.title = title;
    }

    public Movie() {
    }

    public MovieDto toDto() {
        return MovieDto.builder()
                .id(id)
//                .homepage(homepage)
                .title(title)
//                .productionDate(productionDate)
                .actors(actors)
                .country(countries)
//                .comments(comments)
                .genre(genre)
                .company(companies)
                .build();
    }

//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", idAPI='" + idAPI + '\n' +
                ", title='" + title + '\n' +
                ", plot='" + overview + '\n' +
                ", releaseDate=" + releaseDate + '\n' +
                ", runtime='" + runtime + '\n' +
                ", actors=" + actors + '\n' +
                ", genre=" + genre + '\n'+
                ", companies=" + companies + '\n' +
                ", countries=" + countries + '\n' +
                ", languages=" + languages + '\n' +
                '}';
    }
}
