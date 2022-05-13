package com.example.database.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
//    @ManyToMany
//    @JoinTable(
//            name = "movie_actor",
//            joinColumns = @JoinColumn(name = "actor_id"),
//            inverseJoinColumns = @JoinColumn(name = "movie_id")
//    )
//    private List<Movie> movies;

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String personName) {
        this.name = personName;
    }

//    public List<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//    }

    @Override
    public String toString() {
        return "Actor{" +
                "ID=" + id +
                ", name='" + name + '\'' +
//                ", movies=" + movies +
                '}';
    }
}
