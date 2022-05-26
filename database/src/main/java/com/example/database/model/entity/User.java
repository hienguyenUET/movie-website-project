package com.example.database.model.entity;

import com.example.database.model.dto.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size(min = 6, message = "Username must be longer than 6 characters")
    private String username;

    @JsonIgnore
    @Column
    private String name;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", updatable = false)
    private Role role;

    // Create new user's account
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_movie",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id"))
    List<Movie> favoriteMovies;

    public PersonDto toDto() {
        return PersonDto.builder()
                .id(id)
                .name(name)
                .password(password)
//                .movies(movies)
                .build();
    }

    public void addFavoriteMovie(Movie movie) {
        this.favoriteMovies.add(movie);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\n' +
                ", name='" + name + '\n' +
                ", password='" + password + '\n' +
                ", email='" + email + '\n' +
                '}';
    }
}
