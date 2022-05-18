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

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "profile_path")
    private String profilePath;

    @Column(name = "biography")
    private String biography;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Override
    public String toString() {
        return "Actor{" +
                "ID=" + id +
                ", name='" + name + '\'' +
//                ", movies=" + movies +
                '}';
    }
}
