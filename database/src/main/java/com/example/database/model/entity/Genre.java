package com.example.database.model.entity;

import com.example.database.model.dto.GenreDto;
import com.example.database.model.enums.EGenre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre_name")
    private EGenre genreName;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EGenre getGenreName() {
        return genreName;
    }

    public void setGenreName(EGenre genreName) {
        this.genreName = genreName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public GenreDto toDto() {
        return GenreDto.builder()
                .id(id)
                .genre_name(genreName)
                .movies(movies)
                .build();
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
