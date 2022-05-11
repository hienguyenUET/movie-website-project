package com.example.database.model.entity;

import com.example.database.model.dto.MovieDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

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
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "title")
    @JsonProperty("Title")
    private String title;
    //
//
    @Column(name = "release_date")
    private Date releaseDate;

//    @NonNull
//    @JsonIgnore
//    @ManyToMany(mappedBy = "movies")
//    private List<Account> people = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;


    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "cast",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Actor> actors;


    @ManyToMany(cascade = {CascadeType.PERSIST})
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

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    List<Country> countries;

    @ManyToMany
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
                .comments(comments)
                .genre(genre)
                .company(companies)
                .build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        if (this.actors == null) {
            this.actors = new ArrayList<>();
        }
        actors.add(actor);
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public void addGenre(Genre genre) {
        if (this.genre == null) {
            this.genre = new ArrayList<>();
        }
        this.genre.add(genre);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", actors=" + actors +
                ", genre=" + genre +
                '}';
    }
}
