package com.example.database.model.entity;

import com.example.database.model.dto.CommentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity
@Table(name = "user_comment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    @Column
    private String comment;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "film_id")
//    private Film film;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Person person;


    public CommentDto toDto() {
        return CommentDto.builder()
                .id(id)
//                .content(content)
//                .film(film)
//                .person(person)
                .build();
    }
}