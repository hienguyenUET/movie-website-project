package com.example.database.model.entity;

import com.example.database.model.dto.ActorDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private List<Film> films = new ArrayList<>();

    public ActorDto toDto() {
        return ActorDto.builder()
                .id(id)
                .name(name)
                .films(films)
                .build();
    }
}
