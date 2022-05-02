package com.example.database.model.entity;

import com.example.database.model.dto.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    @Size(min = 6, message = "Username must be longer than 6 characters")
    private String username;

    @Column
    private String name;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    @Email
    private String email;
//
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(name = "user_film",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "film_id")
//    )
//    private List<Movie> movies = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "person")
//    private List<Comment> comments = new ArrayList<>();

    public PersonDto toDto() {
        return PersonDto.builder()
                .id(id)
                .name(name)
                .password(password)
//                .movies(movies)
                .build();
    }
}
