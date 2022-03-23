package com.example.database.model.entity;

import com.example.database.model.dto.CommentDto;
import com.example.database.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CommentDto toDto() {
        return CommentDto.builder()
                .id(id)
                .content(content)
                .film(film)
                .user(user)
                .build();
    }
}